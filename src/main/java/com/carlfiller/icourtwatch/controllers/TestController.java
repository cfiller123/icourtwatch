package com.carlfiller.icourtwatch.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {

    @RequestMapping(value="")
    @ResponseBody
    public String index(){
        return "This is where your capstone will live.";
    }
}
