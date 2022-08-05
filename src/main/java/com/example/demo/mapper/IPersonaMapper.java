package com.example.demo.mapper;


import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.Persona;

public interface IPersonaMapper {
    //TODO: agregar javadocs
    PersonaDTO toDTO(Persona entity);
    Persona fromDTO(PersonaDTO entity);

}
