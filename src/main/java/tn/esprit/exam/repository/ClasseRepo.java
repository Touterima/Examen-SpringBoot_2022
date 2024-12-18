package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Classe;

@Repository
public interface ClasseRepo extends JpaRepository<Classe, Integer> {
}
