package com.imdbWebApp.rest_service;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Controller
public class SearchFormController implements WebMvcConfigurer {


    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);
    CustomerRepository repository;
    IMDBRepository imdbRepository;
    IMDBMovieAndCrewRepository imdbMovieAndCrewRepository;

    public SearchFormController(IMDBMovieAndCrewRepository imdbMovieAndCrewRepository) {
        this.imdbMovieAndCrewRepository = imdbMovieAndCrewRepository;
    }

    public Optional<Movie> findByID(Long id) {
        return imdbRepository.findById(id);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/validationResults").setViewName("validationResults");
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("GetCrewForMovieTitle", new GetCrewForMovieTitle());
        return "searchMovies";
    }


    @PostMapping("/")
    public String submitMovieSearchQuery(@ModelAttribute("getCrewForMovieTitle") GetCrewForMovieTitle getCrewForMovieTitle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "searchMovies";
        }
        //findByID(@RequestParam(value = "id") String id, Model model) {
        return "redirect:/dataBaseDisplay";
    }
}