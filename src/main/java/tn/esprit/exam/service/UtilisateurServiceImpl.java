package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.repository.ClasseRepo;
import tn.esprit.exam.repository.UserRepo;

@Service
@AllArgsConstructor
@Slf4j
public class UtilisateurServiceImpl implements IUtilisateurService{
    UserRepo userrepo;
    ClasseRepo classrepo;


    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur){
        return userrepo.save(utilisateur);
    }


    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse) {
        Utilisateur user = userrepo.findById(idUtilisateur).get();
        Classe classe = classrepo.findById(codeClasse).get();

        user.setClasse(classe);
        userrepo.save(user);
    }

    public Integer nbUtilisateursParNiveau(Niveau nv) {
        return userrepo.countByClasseNiveau(nv);
    }

}
