package com.PT_RH_01.casale.controller;

import com.PT_RH_01.casale.model.Equipo;
import com.PT_RH_01.casale.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Equipo>> obtenerEquipos() {
        List<Equipo> equipos = equipoService.obtenerTodosLosEquipos();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEquipoById(@PathVariable Integer id) {
        return equipoService.obtenerEquipoPorId(id);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Equipo>> obtenerEquipoByName(@RequestParam String nombre) {
        List<Equipo> equipos = equipoService.buscarEquipoPorNombre(nombre.toLowerCase());
        return ResponseEntity.ok(equipos);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEquipo(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return equipoService.actualizarEquipo(id, equipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEquipo(@PathVariable Integer id) {
        return equipoService.eliminarEquipo(id);
    }
}
