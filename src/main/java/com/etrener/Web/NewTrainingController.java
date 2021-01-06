package com.etrener.Web;

import com.Service.NewTrainingService;
import com.etrener.NewTraining;
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

    @GetMapping("/newTraining")
    public String getNewTraining(Model model) {

        NewTraining newTraining = new NewTraining();

        model.addAttribute("listOfTrainers", newTraining.addTrainersToList());
        model.addAttribute("listOfTraings", newTraining.addTrainingTypesToList());
        model.addAttribute("newTraining", newTraining);

        return "newTraining";
    }

    @PostMapping("/newTraining")
    public String postNewTraining(Model model) {



        newTrainingService.saveNewTraining((NewTraining) model.getAttribute(postNewTraining(model)));

        return "redirect:/saved";
    }


    @GetMapping("/saved")
    public String displaySavedPage() {
        return "saved";
    }
}
