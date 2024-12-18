package tn.esprit.exam.service;

import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.entity.enums.Niveau;

public interface IUtilisateurService {

    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau nv);

}
