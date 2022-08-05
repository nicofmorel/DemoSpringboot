package com.example.demo.mapper;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.model.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapperImpl implements IPersonaMapper {

    @Override
    public PersonaDTO toDTO(Persona entity) {
        if ( entity == null ) {
            return null;
        }

        PersonaDTO canchaDTO = new PersonaDTO();

        canchaDTO.setId( entity.getId() );
        canchaDTO.setNombre( entity.getNombre() );
        canchaDTO.setDireccion( entity.getDireccion() );

        return canchaDTO;
    }

    @Override
    public Persona fromDTO(PersonaDTO entity) {
        if ( entity == null ) {
            return null;
        }

        Persona cancha = new Persona();

        cancha.setId( entity.getId() );
        cancha.setNombre( entity.getNombre() );
        cancha.setDireccion( entity.getDireccion() );

        return cancha;
    }
}
