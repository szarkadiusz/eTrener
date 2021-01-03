//package com.etrener.Web;
//
//import com.etrener.arch_to_delete.TrainingPropertiesRepository;
//import com.etrener.arch_to_delete.TrainingRepository;
//import com.etrener.arch_to_delete.Training;
//import com.etrener.arch_to_delete.TrainingRequest;
//import com.etrener.arch_to_delete.TrainingProperties;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Slf4j
//@Controller
//@RequestMapping("/trainings")
//@SessionAttributes("request")
//@AllArgsConstructor
//public class NewWorkerTrainingsController {
//
//
//    private TrainingPropertiesRepository propertiesRepository;
//    private TrainingRepository trainingRepository;
//
//
//    @ModelAttribute(name = "request")
//    public TrainingRequest requestOrder() {
//        return new TrainingRequest();
//    }
//
//    @ModelAttribute(name = "training")
//    public Training newTraining() {
//        return new Training();
//    }
//
//    @GetMapping
//    public String showDesignForm(Model model) {
//        List<TrainingProperties> trainings = new ArrayList<>();
//        propertiesRepository.findAll().forEach(i -> trainings.add(i));
//
//        TrainingProperties.TrainingType[] types = TrainingProperties.TrainingType.values();
//        for (TrainingProperties.TrainingType type : types) {
//            model.addAttribute(type.toString().toLowerCase(),
//                    filterByType(trainings, type));
//        }
//
//        return "newTraining";
//    }
//
//
//    @PostMapping
//    public String processDesign(
//            @Valid Training training, Errors errors,
//            @ModelAttribute TrainingRequest TrainingRequest) {
//
//        if (errors.hasErrors()) {
//            return "design";
//        }
//
//        Training saved = trainingRepository.save(training);
//        TrainingRequest.addTraining(saved);
//
//        return "redirect:/orders/current";
//    }
//
//
//
//    private List<TrainingProperties> filterByType(
//            List<TrainingProperties> trainings, TrainingProperties.TrainingType type) {
//        return trainings
//                .stream()
//                .filter(x -> x.getType().equals(type))
//                .collect(Collectors.toList());
//    }
//}