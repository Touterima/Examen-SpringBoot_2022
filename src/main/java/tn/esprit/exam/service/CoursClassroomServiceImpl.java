package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.entity.enums.Specialite;
import tn.esprit.exam.repository.ClasseRepo;
import tn.esprit.exam.repository.CoursClassroomRepo;

import java.util.List;

@Service
@AllArgsConstructor
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

    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom coursClassroom = coursClassroomRepo.findById(idCours)
                .orElseThrow(() -> new RuntimeException("CoursClassroom non trouvé"));
        coursClassroom.setClasse(null);
        coursClassroomRepo.save(coursClassroom);
    }

    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv){

        return coursClassroomRepo.sumNbHeuresBySpecialiteAndNiveau(sp, nv);
    }


    // Méthode de planification
    @Scheduled(initialDelay = 2 * 24 * 60 * 60 * 1000, fixedRate = 5 * 60 * 1000)
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursList = coursClassroomRepo.findAll();
        for (CoursClassroom cours : coursList) {
            cours.setArchive(true);
        }
        coursClassroomRepo.saveAll(coursList);
        System.out.println("Tous les coursClassroom ont été archivés.");
    }
}
