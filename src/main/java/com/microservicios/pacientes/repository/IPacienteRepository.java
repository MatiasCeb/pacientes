package com.microservicios.pacientes.repository;

import com.microservicios.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long > {

}
