//package com.etrener.Web;
//
//import com.etrener.arch_to_delete.TrainingRequestRepository;
//import com.etrener.arch_to_delete.TrainingRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/requests")
//@SessionAttributes("request")
//public class NewTrainingRequestController {
//
//    private TrainingRequestRepository requestRepo;
//
//    public NewTrainingRequestController(TrainingRequestRepository requestRepo) {
//        this.requestRepo = requestRepo;
//    }
//
//    public NewTrainingRequestController() {
//    }
//
//    @GetMapping("/new")
//    public String requestForm() {
//        return "requestForm";
//    }
//
//    @PostMapping
//    public String processOrder(@Valid TrainingRequest trainingRequest, Errors errors, SessionStatus sessionStatus) {
//        if (errors.hasErrors()) {
//            return "requestForm";
//        }
//
//        requestRepo.save(trainingRequest);
//        sessionStatus.setComplete();
//
//        return "redirect:/";
//    }
//}
