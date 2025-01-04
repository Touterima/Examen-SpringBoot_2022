package tn.esprit.exam.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.exam.entity.enums.Niveau;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeClasse;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ToString.Exclude
    @OneToMany(mappedBy = "classe")
    private Set<CoursClassroom> coursClassrooms;

/*
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CoursClassroom> coursClassrooms;
*/
}
