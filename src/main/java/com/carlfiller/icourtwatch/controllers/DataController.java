package com.carlfiller.icourtwatch.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.Watch;
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

    public List<Integer> getAverages(Judge foundJudge) {
        List<Watch> watches = watchDao.findByJudge(foundJudge);
        int audability = 0;
        int caseDetails = 0;
        int courtProceedings = 0;
        int explainCharges = 0;
        int eyeContact = 0;
        int listeningSkills = 0;
        int timeMgmt = 0;
        int voiceTone = 0;
        for (Watch w : watches) {
            audability = audability + w.getAudability();
            caseDetails = caseDetails + w.getCaseDetails();
            courtProceedings = courtProceedings + w.getCourtProceedings();
            explainCharges = explainCharges + w.getExplainCharges();
            eyeContact = eyeContact + w.getEyeContact();
            listeningSkills = listeningSkills + w.getListeningSkills();
            timeMgmt = timeMgmt + w.getTimeMgmt();
            voiceTone = voiceTone + w.getVoiceTone();
        }
        audability = audability/watches.size();
        caseDetails = caseDetails/watches.size();
        courtProceedings = courtProceedings/watches.size();
        explainCharges = explainCharges/watches.size();
        eyeContact = eyeContact/watches.size();
        listeningSkills = listeningSkills/watches.size();
        timeMgmt = timeMgmt/watches.size();
        voiceTone = voiceTone/watches.size();
        List<Integer> data = new ArrayList<>();
        data.addAll(Arrays.asList(audability,caseDetails,courtProceedings,explainCharges, eyeContact,listeningSkills
        , timeMgmt, voiceTone));
        return data;
//        return String.valueOf(audability) + ", " + String.valueOf(caseDetails) + ", " + String.valueOf(courtProceedings)
//                + ", " + String.valueOf(explainCharges) + ", " + String.valueOf(eyeContact) + ", " + String.valueOf(listeningSkills)
//                + ", " + String.valueOf(timeMgmt) + ", " + String.valueOf(voiceTone);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String displaySummary(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());
        String name = user.getUsername();

        model.addAttribute("title", "Summary Statistics");
        model.addAttribute("watches",watchDao.findAll().size());
        model.addAttribute("judges",judgeDao.findAll());
        model.addAttribute("yourname",name);

        return "data/index";
    }

    @RequestMapping(value="canvasjs", method = RequestMethod.GET)
    public String springMVC(ModelMap modelmap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelmap.addAttribute("dataPointsList", canvasjsDataList);
        modelmap.addAttribute("title","Dashboard");
        return "data/canvasjs";
    }

    @RequestMapping(value="highchart",method = RequestMethod.GET)
    public String highchart(Model model, int id) {
        Judge foundjudge = judgeDao.findOne(id);
        model.addAttribute("title","Summary Statistics");
        model.addAttribute("chartTitle",foundjudge.getName() + "'s Results");
        model.addAttribute("chartScale","Scale from 1-5 with 1 being the lowest");
        model.addAttribute("data",getAverages(foundjudge)); //need to pass as integers not string
        model.addAttribute("chartMetric","Eye Contact");
        return "data/highchart";
    }

}