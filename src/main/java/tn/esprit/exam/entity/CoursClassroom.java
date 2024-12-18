package tn.esprit.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.exam.entity.enums.Specialite;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoursClassroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCours;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private String nom;
    private int nbHeures;
    private boolean archive;

    @ManyToOne/*(mappedBy="coursClassrooms")*/
    private Classe classe;
}
