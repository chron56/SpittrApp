package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrServiceException;
import spittrpackage.service.SpittrService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class SpittleControllerSpring {

    @Autowired
    SpittrService aService;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listSpittles(ModelMap model) {
        try {
            model.addAttribute("spittles", aService.getAllSpittles());
            model.addAttribute("spitters", aService.getAllSpitters());
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "listSpittles";
    }

    @RequestMapping(value = { "/addSpitter" }, method = RequestMethod.GET)
    public String addSpitter(ModelMap model) {
        return "addSpitter";
    }

    @RequestMapping(value = { "/addSpittle" }, method = RequestMethod.GET)
    public String addSpittle(ModelMap model) {
        try{
            model.addAttribute("spitters", aService.getAllSpitters());
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "addSpittle";
    }

    @RequestMapping(value = { "/updateSpittle/{id}" }, method = RequestMethod.GET)
    public String updateSpittle(ModelMap model, @PathVariable String id) {
        int spittleId = Integer.parseInt(id);
        try{
            Spittle aSpittle = aService.getSpittle(spittleId);
            model.addAttribute("spittle",aSpittle);
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "updateSpittle";
    }

    @RequestMapping(value = { "/deleteSpittle/{id}" }, method = RequestMethod.GET)
    public String deleteSpittle(@PathVariable String id) {
        int spittleId = Integer.parseInt(id);
        try{
            Spittle aSpittle = aService.getSpittle(spittleId);
            aService.deleteSpittle(aSpittle);
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/addSpitter", method = RequestMethod.POST)
    public String addSpitterPost(HttpServletRequest request) {
        String  spitterUsername = request.getParameter("spitterUsername");
        try{
            Spitter aSpitter =  new Spitter();
            aSpitter.setUsername(spitterUsername);
            aService.addSpitter(aSpitter);
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/addSpittle", method = RequestMethod.POST)
    public String addSpittlePost(HttpServletRequest request) {
        int spitterId = Integer.parseInt(request.getParameter("spitterId"));
        try{
            Spitter aSpitter = aService.getSpitter(spitterId);
            Spittle aSpittle = new Spittle();
            aSpittle.setSpitter(aSpitter);
            aSpittle.setText(request.getParameter("spittleText"));
            aService.addSpittle(aSpittle);
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/updateSpittle/{id}", method = RequestMethod.POST)
    public String updateSpittlePost(HttpServletRequest request) {
        int spittleId = Integer.parseInt(request.getParameter("spittleId"));
        String spittleText = request.getParameter("spittleText");
        try{
            Spittle aSpittle = aService.getSpittle(spittleId);
            aSpittle.setText(spittleText);
            aService.updateSpittle(aSpittle);
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "redirect:/list";
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.POST)
    public String filterBySpitter(ModelMap model, HttpServletRequest request) {
        int spitterId = Integer.parseInt(request.getParameter("spitterId"));
        try{
            if (spitterId == 0){
                model.addAttribute("spittles", aService.getAllSpittles());
            }
            else{
                Spitter aSpitter = aService.getSpitter(spitterId);
                model.addAttribute("spittles", aService.getSpittersSpittles(aSpitter));
            }
            model.addAttribute("spitters", aService.getAllSpitters());
        }
        catch (SpittrServiceException ex) {
            ex.printStackTrace();
        }
        return "listSpittles";
    }
}
