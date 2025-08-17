package com.pm.patientservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    public List<PatientResponseDTO> getPatients () {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = 
            patients.stream().map(PatientMapper::toDTO).toList();
            
        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO PatientRequestDTO) {
        Patient newPatient = patientRepository.save(
            PatientMapper.toModel(PatientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }
}
