package tn.esprit.exam.service;

import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.entity.enums.Specialite;

public interface ICoursClassroomService {
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
    void desaffecterCoursClassroomClasse(Integer idCours);
}
