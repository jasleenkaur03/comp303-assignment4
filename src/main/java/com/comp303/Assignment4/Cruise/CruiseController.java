package com.comp303.Assignment4.Cruise;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CruiseController {

    @Autowired
    CruiseService cruiseService;

    @GetMapping("/admin")
    public String home() {
        return "home";
    }

    @GetMapping("/cruise/all")
    public String dashboard(Model model) throws Exception {
        model.addAttribute("cruises", cruiseService.findAll());
        return "allcruises";
    }

    @GetMapping("/cruise/add")
    public String addCruise() {
        return "newcruise";
    }

    @RequestMapping(value= "/cruise/edit/{cruiseId}", method = RequestMethod.POST)
    public String editCruise(@PathVariable("cruiseId") String cruiseID, Model model) throws Exception {
        Cruise cruise = cruiseService.findCruise(cruiseID).get();
        model.addAttribute("cruiseData", cruise);
        return "editcruise";
    }

    @RequestMapping(value = "/cruise/add", method = RequestMethod.POST)
    public String addCruisePost(@RequestParam(name = "cruiseId", required = true) String cruiseId,
            @RequestParam(name = "departureDate", required = true) String departureDate,
            @RequestParam(name = "cruiseDestination", required = true) String cruiseDestination,
            @RequestParam(name = "cruiseLine", required = true) String cruiseLine,
            @RequestParam(name = "visitingPlaces", required = true) String visitingPlaces,
            @RequestParam(name = "duration", required = true) int duration,
            @RequestParam(name = "price", required = true) String price, Model model) throws Exception {

        Cruise cruise = new Cruise(cruiseId, cruiseDestination, cruiseLine, departureDate, visitingPlaces, duration, Double.parseDouble(price));

        if (new SimpleDateFormat("yyyy-MM-dd").parse(departureDate).before(new Date())) {
            model.addAttribute("error", "departure cruise date is past");
            return "newcruise";
        } else {
            cruiseService.saveCruise(cruise);
            return "redirect:all";
        }

    }

    @RequestMapping(value = "/cruise/edit", method = RequestMethod.POST)
    public String editCruisePost(@RequestParam(name = "cruiseId", required = true) String cruiseId,
            @RequestParam(name = "departureDate", required = true) String departureDate,
            @RequestParam(name = "cruiseDestination", required = true) String cruiseDestination,
            @RequestParam(name = "cruiseLine", required = true) String cruiseLine,
            @RequestParam(name = "visitingPlaces", required = true) String visitingPlaces,
            @RequestParam(name = "duration", required = true) int duration,
            @RequestParam(name = "price", required = true) String price, Model model) throws Exception {

        Cruise cruise = new Cruise(cruiseId, cruiseDestination, cruiseLine, departureDate, visitingPlaces, duration, Double.parseDouble(price));

        if (new SimpleDateFormat("yyyy-MM-dd").parse(departureDate).before(new Date())) {
            model.addAttribute("error", "departure cruise date is past");
            model.addAttribute("cruiseData", cruise);
            return "editcruise";
        } else {
            cruiseService.updateCruise(cruise);
            return "redirect:all";
        }

    }

    @RequestMapping(value = "/cruise/delete/{cruiseId}", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
    String deleteCruise(@PathVariable("cruiseId") String cruiseID) throws Exception {
        cruiseService.delCruise(cruiseID);
        return "redirect:/cruise/all";

    }
}
