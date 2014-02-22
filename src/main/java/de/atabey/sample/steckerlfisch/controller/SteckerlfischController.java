package de.atabey.sample.steckerlfisch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuat Atabey
 */
@Controller
public class SteckerlfischController {

    @RequestMapping("/show")
    public String showConfiguration(Model model) {
        return "hello";
    }
}
