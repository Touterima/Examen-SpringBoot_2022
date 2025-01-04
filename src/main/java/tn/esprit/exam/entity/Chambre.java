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
**One To One (Unidirectionnelle)  ml projet vers ProjetDetail  --> clé coté projet
@OneToOne
private Projet_Detail projetDetail;

**One To One Bidirectionnelle   --> clé coté projet
@OneToOne
private Projet_Detail projetDetail;
@OneToOne(mappedBy="projetDetail")
private Projet projet;

**One To Many (Unidirectionnelle)  Entreprise -> Equipe  -->Table
@OneToMany(cascade = CascadeType.ALL)
private Set<Equipe> Equipes;

**Many To One (Unidirectionnelle)     Equipe* -> 1Entreprise  -->Cle coté equipe
@ManyToOne(cascade = CascadeType.ALL)
Entreprise entreprise;

Many To One (Bidirectionnelle)                   -->clé coté equipe
@ManyToOne(cascade = CascadeType.ALL)
Entreprise entreprise;
@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
private Set<Equipe> Equipes;

**Many To Many (Unidirectionnelle)  Equipe* -> *Entreprise    -->Table
@ManyToMany(cascade = CascadeType.ALL)
private Set<Projet> projets;

Many To Many (Bidirectionnelle)          -->Table
@ManyToMany(cascade = CascadeType.ALL)
private Set<Projet> projets;
@ManyToMany(mappedBy="projets", cascade = CascadeType.ALL)
private Set<Equipe> equipes;

 */