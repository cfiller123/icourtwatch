package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Judge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("judge")
public class JudgeController {

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title","Welcome to CourtWatch!");

        return "judge/index";
    }

    @RequestMapping(value = "addwatch", method = RequestMethod.GET)
    public String displayAddWatchForm(Model model) {

        model.addAttribute("title","Add Your Court Watch");
        model.addAttribute(new Judge());
        return "judge/addwatch";
    }
}
