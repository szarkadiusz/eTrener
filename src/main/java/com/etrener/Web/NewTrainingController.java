package com.etrener.Web;

import com.Service.NewTrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class NewTrainingController implements WebMvcConfigurer {
    NewTrainingService newTrainingService;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @GetMapping("/newtraining")
    public String getNewTraining (Model model){

        return "newTraining";
    }

    @PostMapping("/newtraining")
    public void postNewTraining (Model model){


    }


    @GetMapping("/saved")
    public String displaySavedPage(){
        return "saved";
    }
}
