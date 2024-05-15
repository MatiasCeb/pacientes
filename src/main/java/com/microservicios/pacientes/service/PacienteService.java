package com.microservicios.pacientes.service;

import com.microservicios.pacientes.model.Paciente;
import com.microservicios.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Paciente pac) {
        this.savePaciente(pac);
    }
}
