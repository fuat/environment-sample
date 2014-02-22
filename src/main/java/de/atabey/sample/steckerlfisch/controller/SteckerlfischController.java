package de.atabey.sample.steckerlfisch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Fuat Atabey
 */
@Controller
public class SteckerlfischController {

    @Autowired
    private Environment environment;

    @Value("#{environment.maxLimit ?:25}")
    private int maxLimit;

    @RequestMapping("/show")
    public ModelAndView showConfiguration(Model model) {
        model.addAttribute("maxLimit", maxLimit);
        model.addAttribute("environment", environment);
        return new ModelAndView("config");
    }
}
