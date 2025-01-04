package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.enums.Niveau;
import tn.esprit.exam.entity.enums.Specialite;
import tn.esprit.exam.service.ICoursClassroomService;

@Tag(name = "Ce Web Service gère le CRUD pour un cour classroom")
@RestController
@AllArgsConstructor
@RequestMapping("/classroom")
public class CoursClassroomController {
    ICoursClassroomService coursClassroomService;

    //POST http://localhost:8089/rima-toute-4sae2/classroom/add-coursClassroom?codeClasse=4AG1
    @PostMapping("/add-coursClassroom")
    public CoursClassroom ajouterCoursClassroom (@RequestBody CoursClassroom cc, @RequestParam Integer codeClasse){
        return coursClassroomService.ajouterCoursClassroom(cc, codeClasse);
    }

    @PutMapping("/desaffecterCoursClassroomClasse/{idCours}")
    public void desaffecterCoursClassroomClasse(@PathVariable Integer idCours) {
        coursClassroomService.desaffecterCoursClassroomClasse(idCours);
    }

    @GetMapping("/nb-heures/{specialite}/{niveau}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable Specialite specialite, @PathVariable Niveau niveau) {
        return coursClassroomService.nbHeuresParSpecEtNiv(specialite, niveau);
    }


}
