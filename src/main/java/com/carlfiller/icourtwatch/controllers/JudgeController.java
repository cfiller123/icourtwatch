package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.data.JudgeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

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
            return "judge/addwatch";
        }

        judgeDao.save(newJudge);
        return "judge/index";
    }

    @RequestMapping(value = "viewwatch", method = RequestMethod.GET)
    public String viewWatch(Model model, int id) {
        Judge foundJudge = judgeDao.findOne(id);
        model.addAttribute("judge", foundJudge);
        return "judge/viewatch";
    }
}
