package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.service.IUtilisateurService;

@Tag(name = "Ce Web Service gère le CRUD pour un user")
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurController {
    IUtilisateurService utilisateurService;

    @PostMapping("/add-user")
    public Utilisateur ajouterUtilisateur (@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouterUtilisateur(utilisateur);
    }

    @PostMapping("/affecterUtilisateurClasse/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable Integer idUtilisateur, @PathVariable Integer codeClasse) {
        utilisateurService.affecterUtilisateurClasse(idUtilisateur, codeClasse);
    }

    //GET /user/nbUtilisateursParNiveau/QUATRIEME
    @GetMapping("/nbUtilisateursParNiveau/{niveau}")
    public Integer nbUtilisateursParNiveau(@PathVariable Niveau niveau) {
        return utilisateurService.nbUtilisateursParNiveau(niveau);
    }

}
