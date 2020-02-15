package pl.venustus.Soup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WwwController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
