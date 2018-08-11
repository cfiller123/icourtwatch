package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("judge")
public class JudgeController extends AbstractController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model){
        // TODO: Create a list of last 10 watches to pass to the view.
        model.addAttribute("title","Welcome to CourtWatch!");
        model.addAttribute("judges", judgeDao.findAll());
        return "judge/index";
    }

    @RequestMapping(value = "addwatch", method = RequestMethod.GET)
    public String displayAddWatchForm(Model model) {

        model.addAttribute("title","Add Your Court Watch");
        model.addAttribute(new Judge());
        model.addAttribute("dispositions",Disposition.values());
        return "judge/addwatch";
    }

    @RequestMapping(value = "addwatch", method = RequestMethod.POST)
    public String processAddWatchForm(@ModelAttribute @Valid Judge newJudge, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title","Add Your Court Watch");
            model.addAttribute(new Judge());
            model.addAttribute("dispositions",Disposition.values());
            return "judge/addwatch";
        }

        judgeDao.save(newJudge);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "viewwatch", method = RequestMethod.GET)
    public String viewWatch(Model model, int id) {
        Judge foundJudge = judgeDao.findOne(id);
        model.addAttribute("judge", foundJudge);
        model.addAttribute("dispositions", Disposition.values());
        return "judge/viewwatch";
    }

    @RequestMapping(value = "viewwatch", method = RequestMethod.POST)
    public String processViewWatch(@ModelAttribute @Valid Judge updateJudge, Errors errors, Model model, int judgeId) {

        if (errors.hasErrors()) {
            return "redirect:";

        }
        Judge foundJudge = judgeDao.findOne(judgeId);
        foundJudge.setName(updateJudge.getName());
        foundJudge.setDisposition(updateJudge.getDisposition());
        foundJudge.setCourt(updateJudge.getCourt());
        foundJudge.setDate(updateJudge.getDate());
        foundJudge.setDefendant(updateJudge.getDefendant());
        judgeDao.save(foundJudge);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "removewatch", method = RequestMethod.GET)
    public String viewRemoveWatch(Model model, int id) {
        Judge foundJudge = judgeDao.findOne(id);
        model.addAttribute("title","Delete Watch");
        model.addAttribute("judge", foundJudge);
        model.addAttribute("disposition", foundJudge.getDisposition());

        return "/judge/removewatch";
    }

    @RequestMapping(value = "removewatch", method = RequestMethod.POST)
    public String processRemoveWatch(@ModelAttribute Judge judge, Model model, int judgeId) {
        // TODO: Flash message warning user that they're about to delete a judge

        judgeDao.delete(judgeId);

        return "redirect:/judge/index";
    }

    @RequestMapping(value = "summary", method = RequestMethod.GET)
    public String displaySummary(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        String name = user.getUsername();

        model.addAttribute("title", "Summary Statistics");
        model.addAttribute("watches",judgeDao.findAll().size());
        model.addAttribute("yourname",name);

        return "judge/summary";
    }
}
