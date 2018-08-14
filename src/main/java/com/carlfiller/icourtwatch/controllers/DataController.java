package com.carlfiller.icourtwatch.controllers;

import java.util.List;
import java.util.Map;

import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("data")
public class DataController extends AbstractController{

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(value = "summary", method = RequestMethod.GET)
    public String displaySummary(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        String name = user.getUsername();

        model.addAttribute("title", "Summary Statistics");
        model.addAttribute("watches",watchDao.findAll().size());
        model.addAttribute("yourname",name);

        return "data/summary";
    }

    @RequestMapping(value="index", method = RequestMethod.GET)
    public String springMVC(ModelMap modelmap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelmap.addAttribute("dataPointsList", canvasjsDataList);
        modelmap.addAttribute("title","Dashboard");
        return "data/index";
    }

    @RequestMapping(value="highchart",method = RequestMethod.GET)
    public String highchart(Model model) {
        return "data/highchart";
    }

}