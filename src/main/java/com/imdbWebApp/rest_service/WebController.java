package com.imdbWebApp.rest_service;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {



    private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);
    CustomerRepository repository;

    public WebController(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/validationResults").setViewName("validationResults");
    }
    @GetMapping("/")
    public String showForm(Customer customer){
        return "form";
    }

    @PostMapping("/")
    public String checkCustomerinfo(@Valid Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        repository.save(customer);
        log.info(customer.toString());
        return  "redirect:/validationResults";
    }

}
