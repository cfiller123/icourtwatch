package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.Disposition;
import com.carlfiller.icourtwatch.models.Judge;
import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.Watch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("watch")
public class WatchController extends AbstractController{

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());
        int ownerId = user.getId();
        model.addAttribute("title","Watch Dashboard");
        model.addAttribute("watches", watchDao.findByOwnerId(ownerId));
        return "watch/index";
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String indexAll(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());
        int ownerId = user.getId();
        model.addAttribute("title","Watch Dashboard");
        model.addAttribute("watches", watchDao.findByOwnerId(ownerId));
        return "watch/all";
    }

    @RequestMapping(value = "addwatch", method = RequestMethod.GET)
    public String displayAddWatchForm(Model model) {

        model.addAttribute("title","Add Your Watch");
        model.addAttribute(new Watch());
        model.addAttribute("dispositions",Disposition.values());
        model.addAttribute("judges",judgeDao.findAll());
        return "watch/addwatch";
    }

    @RequestMapping(value = "addwatch", method = RequestMethod.POST)
    public String processAddWatchForm(@ModelAttribute @Valid Watch newWatch, Errors errors, Model model, HttpServletRequest request, @RequestParam int judgeId) {
        User user = getUserFromSession(request.getSession());
        int userId = user.getId();
        Judge judge = judgeDao.findOne(judgeId);
        if (errors.hasErrors()) {
            model.addAttribute("title","Add Your Watch");
            model.addAttribute(new Watch());
            model.addAttribute("dispositions",Disposition.values());
            model.addAttribute("judges",judgeDao.findAll());
            return "watch/addwatch";
        }
        newWatch.setOwnerId(userId);
        newWatch.setJudge(judge);
        watchDao.save(newWatch);
        return "redirect:/watch/index";
    }

    @RequestMapping(value = "editwatch", method = RequestMethod.GET)
    public String viewWatch(Model model, int id) {
        Watch foundWatch = watchDao.findOne(id);
        model.addAttribute("watch", foundWatch);
        model.addAttribute("dispositions", Disposition.values());
        model.addAttribute("judges",judgeDao.findAll());
        return "watch/editwatch";
    }

    @RequestMapping(value = "editwatch", method = RequestMethod.POST)
    public String processViewWatch(@ModelAttribute @Valid Watch updateWatch, Errors errors, Model model, int watchId) {

        if (errors.hasErrors()) {
            return "redirect:";
        }

        Watch foundWatch = watchDao.findOne(watchId);

        foundWatch.setDisposition(updateWatch.getDisposition());
        foundWatch.setDate(updateWatch.getDate());
        foundWatch.setDefendant(updateWatch.getDefendant());
        foundWatch.setAudability(updateWatch.getAudability());
        foundWatch.setCaseDetails(updateWatch.getCaseDetails());
        foundWatch.setCourtProceedings(updateWatch.getCourtProceedings());
        foundWatch.setExplainCharges(updateWatch.getExplainCharges());
        foundWatch.setEyeContact(updateWatch.getEyeContact());
        foundWatch.setListeningSkills(updateWatch.getListeningSkills());
        foundWatch.setVoiceTone(updateWatch.getVoiceTone());
        foundWatch.setTimeMgmt(updateWatch.getTimeMgmt());
        watchDao.save(foundWatch);
        return "redirect:/watch/index";
    }

    @RequestMapping(value = "removewatch", method = RequestMethod.GET)
    public String viewRemoveWatch(Model model, int id) {
        Watch foundWatch = watchDao.findOne(id);
        model.addAttribute("title","Delete Watch");
        model.addAttribute("watch", foundWatch);
        model.addAttribute("disposition", foundWatch.getDisposition());
        model.addAttribute("judge",judgeDao.findOne(foundWatch.getJudge().getId()));

        return "watch/removewatch";
    }

    @RequestMapping(value = "removewatch", method = RequestMethod.POST)
    public String processRemoveWatch(@ModelAttribute Watch watch, Model model, int watchId) {
        watchDao.delete(watchId);
        return "redirect:/watch/index";
    }

}

