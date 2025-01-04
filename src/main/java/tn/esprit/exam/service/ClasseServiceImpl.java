package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.repository.ClasseRepo;

@Service
@AllArgsConstructor
@Slf4j
public class ClasseServiceImpl implements IClasseService{

    ClasseRepo classeRepo;

    public Classe ajouterClasse (Classe c){
        return classeRepo.save(c);
    }
}
