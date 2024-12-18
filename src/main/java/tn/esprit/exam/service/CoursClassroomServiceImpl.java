package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.entity.enums.Specialite;
import tn.esprit.exam.repository.ClasseRepo;
import tn.esprit.exam.repository.CoursClassroomRepo;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class CoursClassroomServiceImpl implements ICoursClassroomService {
    CoursClassroomRepo coursClassroomRepo;
    ClasseRepo classeRepo;

    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse){
        Classe classe = classeRepo.findById(codeClasse).get();
        cc.setClasse(classe);
        classe.getCoursClassrooms().add(cc);
        coursClassroomRepo.save(cc);
        return cc;
    }

    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv){

        return coursClassroomRepo.sumNbHeuresBySpecialiteAndNiveau(sp, nv);
    }

}
