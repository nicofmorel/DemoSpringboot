package com.example.demo.service;

import com.example.demo.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    //TODO:Agregar javadocs a los metodos
    List<PersonaDTO> listAll();

    PersonaDTO getById(Long id);

    PersonaDTO save(PersonaDTO personaDTO);

    PersonaDTO update(PersonaDTO personaDTO);

    void delete(Long id);
}
