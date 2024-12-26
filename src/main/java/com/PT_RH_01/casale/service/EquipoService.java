package com.PT_RH_01.casale.service;

import com.PT_RH_01.casale.model.Equipo;
import com.PT_RH_01.casale.model.Liga;
import com.PT_RH_01.casale.model.Pais;
import com.PT_RH_01.casale.repository.EquipoRepository;

import com.PT_RH_01.casale.repository.LigaRepository;
import com.PT_RH_01.casale.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private LigaRepository ligaRepository;

    @Autowired
    private PaisRepository paisRepository;


    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public ResponseEntity<?> obtenerEquipoPorId(Integer id) {
        try {
            Equipo equipo = equipoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
            return ResponseEntity.ok(equipo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    public List<Equipo> buscarEquipoPorNombre(String nombre) {
        return equipoRepository.buscarEquipoPorNombre(nombre);
    }

    private Pais handlePais(Pais pais) {
        if (pais.getId() == null || !paisRepository.existsById(pais.getId())) {
            return paisRepository.save(pais);
        }
        return pais;
    }

    private Liga handleLiga(Liga liga) {
        if (liga.getPais() != null) {
            liga.setPais(handlePais(liga.getPais()));
        }
        if (liga.getId() == null || !ligaRepository.existsById(liga.getId())) {
            return ligaRepository.save(liga);
        }
        return liga;
    }

    public ResponseEntity<?> crearEquipo(Equipo equipo) {
        try {
            if (equipo.getLiga() != null) {
                equipo.setLiga(handleLiga(equipo.getLiga()));
            }
            Equipo equipoGuardado = equipoRepository.save(equipo);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La solicitud es invalida");
        }
    }


    public ResponseEntity<?> actualizarEquipo(Integer id, Equipo equipoDetalles) {
        try {
            Equipo equipo = equipoRepository.findById(id)
                    .orElseThrow(RuntimeException::new);
            equipo.setNombre(equipoDetalles.getNombre());
            if(equipoDetalles.getLiga() != null) {
                equipo.setLiga(equipoDetalles.getLiga());
                if (equipoDetalles.getLiga().getPais() != null)
                    equipo.getLiga().setPais(equipoDetalles.getLiga().getPais());
            }
            Equipo equipoGuardado = equipoRepository.save(equipo);
            return ResponseEntity.status(HttpStatus.OK).body(equipoGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipo no encontrado");
        }
}

    public ResponseEntity<?> eliminarEquipo(Integer id) {
        try {
            Equipo equipo = equipoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
            equipoRepository.delete(equipo);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
