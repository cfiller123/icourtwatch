package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
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
        model.addAttribute("title","Judge Dashboard");
        model.addAttribute("judges", judgeDao.findAll());
        return "judge/index";
    }

    @RequestMapping(value = "addjudge", method = RequestMethod.GET)
    public String displayAddJudgeForm(Model model) {
        model.addAttribute("title","Add Judge");
        model.addAttribute(new Judge());
        return "judge/addjudge";
    }

    @RequestMapping(value = "addjudge", method = RequestMethod.POST)
    public String processAddJudgeForm(@ModelAttribute @Valid Judge newJudge, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Your Court Watch");
            model.addAttribute(new Judge());
            model.addAttribute("dispositions",Disposition.values());
            return "judge/addjudge";
        }
        judgeDao.save(newJudge);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "editjudge", method = RequestMethod.GET)
    public String viewJudge(Model model, int id) {
        Judge foundJudge = judgeDao.findOne(id);
        model.addAttribute("judge", foundJudge);
        return "judge/editjudge";
    }

    @RequestMapping(value = "editjudge", method = RequestMethod.POST)
    public String processViewJudge(@ModelAttribute @Valid Judge updateJudge, Errors errors, Model model, int judgeId) {
        if (errors.hasErrors()) {
            return "redirect:";
        }

        Judge foundJudge = judgeDao.findOne(judgeId);
        foundJudge.setName(updateJudge.getName());
        foundJudge.setCourt(updateJudge.getCourt());
        judgeDao.save(foundJudge);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "removejudge", method = RequestMethod.GET)
    public String viewRemoveJudge(Model model, int id) {
        Judge foundJudge = judgeDao.findOne(id);
        model.addAttribute("title","Delete Watch");
        model.addAttribute("judge", foundJudge);
        return "/judge/removejudge";
    }

    @RequestMapping(value = "removejudge", method = RequestMethod.POST)
    public String processRemovejudge(@ModelAttribute Judge judge, Model model, int judgeId) {
        judgeDao.delete(judgeId);
        return "redirect:/judge/index";
    }

}
