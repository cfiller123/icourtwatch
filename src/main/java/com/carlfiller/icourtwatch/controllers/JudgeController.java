package com.carlfiller.icourtwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("judge")
public class JudgeController {

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title","Welcome to CourtWatch!");

        return "judge/index";
    }
}
