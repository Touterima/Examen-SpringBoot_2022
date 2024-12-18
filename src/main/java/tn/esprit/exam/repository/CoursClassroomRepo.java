package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.entity.enums.Specialite;

@Repository
public interface CoursClassroomRepo extends JpaRepository<CoursClassroom, Integer> {
    @Query("SELECT SUM(c.nbHeures) FROM CoursClassroom c WHERE c.specialite = :specialite AND c.classe.niveau = :niveau AND c.archive = false")
    Integer sumNbHeuresBySpecialiteAndNiveau(Specialite specialite, Niveau niveau);

}
