package com.carlfiller.icourtwatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TestController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }
}
