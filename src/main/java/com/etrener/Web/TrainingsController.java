package com.etrener.Web;

import com.etrener.arch_to_delete.TrainingService;
import com.etrener.arch_to_delete.TrainingProperties;
import com.etrener.arch_to_delete.TrainingRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class TrainingsController implements WebMvcConfigurer {

    TrainingService trainingService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home-old");
    }

    //NEW TRAINING PAGE-============================================================================================
    @GetMapping("/newTraining")
    public String getTrainingProperties(Model model) {
        TrainingProperties trainingProperties;

        model.addAttribute("trainingPropertiesList", TrainingProperties.addTrainingTypesToList());
        model.addAttribute("trainersList", TrainingProperties.addTrainersToList());



        return "newTraining-old";
    }


    @PostMapping("/newTraining")
    public TrainingProperties saveTrainingProperties(Model model, TrainingProperties trainingProperties) {
        model.addAttribute("trainingProperties", new TrainingProperties());
        trainingProperties.setDedicatedTrainer(String.valueOf(model.addAttribute("trainerDeclaredByUser",model.getAttribute(trainingProperties.getDedicatedTrainer()))));

        return trainingProperties;
    }

    //NEW TRAINING REQUEST PAGE-======================================================================================
    @GetMapping("/requestForm")
    public String getTrainingRequest(Model model) {
        TrainingRequest trainingRequest;
//TODO podac p[arametry z formulasrtza]
        model.addAttribute("trainingRequestDeclaredByUser", new TrainingRequest());
        return "requestForm";
    }

    @PostMapping("/requestForm")
    public String saveNewTrainings(Model model) {

        trainingService.saveTrainingProperties((TrainingProperties) model.getAttribute("trainingPropertiesDeclaredByUser"));
        trainingService.saveTrainingRequest((TrainingRequest) model.getAttribute("trainingPropertiesDeclaredByUser"));

//    TODO stworzsyc strone
        return "redirect:/";
    }

    public String listTrainings(Model model) {
//    TODO stworzsyc hgtgml
        return "html";
    }

}
