package tn.esprit.exam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;

    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;


}

/*
* OneTo many (Unidirectionnelle)  1 -> *        table
* OneToMany(cascade = CascadeType.All)  1
* private Set<Equipe> Equipes;
*
* OneToMany (Bidirectionnelle)  1 -> *          clé  coté many
* OneToMany
* ManyToOne
* private Entreprise entreprise;
*
* ManyToMnay   (Bidirectionnelle)
* @ManyToMnay(cascade=CascadeType.All)    parent
* private Set<Projet> projets;
* @ManyToMany(mappedBy="projets")     le fils contient le mappedby
* private Set<Equipe> equipes;
*
* One to one
* @OneToOne
* private Projet_Detail projetDetail;
* @OneToOne(mappedBy="projetDetail")     la classe fils contient le mapped by
* private Projet projet;
* */