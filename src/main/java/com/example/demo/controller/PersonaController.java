package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/persona")
public class PersonaController {

    private final IPersonaService personaService;

    @Autowired
    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("")
    public ResponseEntity<List<PersonaDTO>> listAll() {
        return ResponseEntity.ok(personaService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.getById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<PersonaDTO> savePersona(@RequestBody PersonaDTO persona) {
        PersonaDTO savedPersona = personaService.save(persona);
        return new ResponseEntity<>(savedPersona, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonaDTO> updatePersona(@PathVariable Long id, @RequestBody PersonaDTO persona) {
        persona.setId(id);
        PersonaDTO updatedPersona = personaService.update(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
