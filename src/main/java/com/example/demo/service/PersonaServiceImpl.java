package com.example.demo.service;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.mapper.IPersonaMapper;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {

    public static final String FIELD_WITH_ID = "Field with id = ";
    public static final String DOES_NOT_EXIST = " does not exist.";
    public static final String ALREADY_EXISTS = " already exists.";
    private final PersonaRepository personaRepository;
    private final IPersonaMapper personaMapper;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository, IPersonaMapper personaMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    @Override
    public List<PersonaDTO> listAll() {
        return personaRepository.findAll()
                .stream()
                .map(this.personaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO getById(Long id) {
        return personaMapper.toDTO(personaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(FIELD_WITH_ID + id + DOES_NOT_EXIST)));
    }

    @Override
    public PersonaDTO save(PersonaDTO persona) {
        boolean exists = persona.getId() != null && personaRepository.existsById(persona.getId());
        if (exists) {
            throw new IllegalArgumentException(FIELD_WITH_ID + persona.getId() + ALREADY_EXISTS);
        }
        return this.personaMapper
                .toDTO(
                        personaRepository.save(this.personaMapper.fromDTO(persona)));
    }

    @Override
    public PersonaDTO update(PersonaDTO persona) {
        boolean exists = personaRepository.existsById(persona.getId());
        if (!exists) {
            throw new NoSuchElementException(FIELD_WITH_ID + persona.getId() + DOES_NOT_EXIST);
        }
        return this.personaMapper
                .toDTO(
                        personaRepository.save(this.personaMapper.fromDTO(persona)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = personaRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException(FIELD_WITH_ID + id + DOES_NOT_EXIST);
        }
        personaRepository.deleteById(id);
    }

}
