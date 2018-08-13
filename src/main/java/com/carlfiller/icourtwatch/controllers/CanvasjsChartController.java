package com.carlfiller.icourtwatch.controllers;

import java.util.List;
import java.util.Map;

import com.carlfiller.icourtwatch.models.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("data")
public class CanvasjsChartController extends AbstractController{

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(value="index", method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "index";
    }

}