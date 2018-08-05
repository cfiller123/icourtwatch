package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.data.JudgeDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        judgeDao.setUserInfoById(updateJudge.getName(),updateJudge.getCourt(),updateJudge.getDate(),updateJudge.getDefendant(), updateJudge.getDisposition(), updateJudge.getId());
        judgeDao.save(foundJudge);
        return "redirect:/judge/index";
    }
}
