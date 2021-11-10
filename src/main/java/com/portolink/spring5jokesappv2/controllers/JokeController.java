package com.portolink.spring5jokesappv2.controllers;

import com.portolink.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    public String sayJoke() {
        return jokeService.getJoke();
    }

    @RequestMapping({"/", "", "/jokes"})
    public String getJoke(Model model) {
        model.addAttribute("piada", jokeService.getJoke());
        return "jokes/joke";
    }
}
