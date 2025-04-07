package fr.ensai.running.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.service.AthleteService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private AthleteService athleteService;

    /**
     * Get all athletes
     */
    @GetMapping("/athlete")
    public List<Athlete> allAthletes() {

        return athleteService.findAll();
    }

    /**
     * Get athlete by id
     */
    @GetMapping("/athlete/{id}")
    public ResponseEntity<Athlete> getAthleteById(@PathVariable Long id_athlete) {
        Athlete athlete = athleteService.findById(id_athlete);
        if (athlete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(athlete);
    }

    /**
     * Delete athlete by id
     */
    @GetMapping("/athlete/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id_athlete) {
        Athlete athlete = athleteService.findById(id_athlete);
        if (athlete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Update athlete by id
     */
    @GetMapping("/athlete/{id}")
    public ResponseEntity<Athlete> updateAthlete(@PathVariable Long id_athlete, @RequestBody Athlete athlete) {
        Athlete athlete_existant = athleteService.findById(id_athlete);
        if (athlete_existant == null){
            return ResponseEntity.notFound().build();
        }
        athlete.setId(id_athlete);
        Athlete athlete_maj = athleteService.save(athlete);
        return ResponseEntity.ok(athlete_maj);
    }
}
