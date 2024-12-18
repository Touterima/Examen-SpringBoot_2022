package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.service.IClasseService;

@Tag(name = "Ce Web Service gère le CRUD pour une Classe")
@RestController
@AllArgsConstructor
@RequestMapping("/classe")
public class ClasseController {

    IClasseService classeService;

    @PostMapping("/add-class")
    public Classe ajouterClasse (Classe c){
        return classeService.ajouterClasse(c);
    }
}
