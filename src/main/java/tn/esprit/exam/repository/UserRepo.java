package tn.esprit.exam.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.entity.enums.Niveau;

@Repository
public interface UserRepo extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT COUNT(u) FROM Utilisateur u WHERE u.classe.niveau = :niveau")
    Integer countByClasseNiveau(Niveau niveau);
}
