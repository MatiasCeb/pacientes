package com.microservicios.pacientes.controller;

import com.microservicios.pacientes.model.Paciente;
import com.microservicios.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteServ;

    // 1 - Crear un nuevo paciente
    @PostMapping("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente pac) {
        pacienteServ.savePaciente(pac);

        return "Paciente creado correctamente";
    }

    // 2 - Obtener todos los pacientes
    @GetMapping("/pacientes/traer")
    public List<Paciente> traerPacientes () {
        return pacienteServ.getPacientes();
    }

    // 3 - Eliminar un paciente
    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteServ.deletePaciente(id);

        return "El paciente fue eliminado correctamente";
    }

    // 4 - Editar paciente
    @PutMapping ("/pacientes/editar/{id_original}")
    public Paciente editPaciente (@PathVariable Long id_original,
                                    @RequestBody Paciente pacienteEditar) {
        pacienteServ.editPaciente(id_original, pacienteEditar);

        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);

        return pacienteEditado;
    }

    // 5 - Obtener un paciente particular
    @GetMapping ("/pacientes/traer/{id}")
    public Paciente traerPaciente (@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }
}
