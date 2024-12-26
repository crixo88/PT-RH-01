package com.PT_RH_01.casale;

import com.PT_RH_01.casale.model.Equipo;
import com.PT_RH_01.casale.model.Liga;
import com.PT_RH_01.casale.model.Pais;
import com.PT_RH_01.casale.repository.EquipoRepository;
import com.PT_RH_01.casale.repository.LigaRepository;
import com.PT_RH_01.casale.repository.PaisRepository;
import com.PT_RH_01.casale.service.EquipoService;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @Mock
    private LigaRepository ligaRepository;

    @Mock
    private PaisRepository paisRepository;

    @InjectMocks
    private EquipoService equipoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerEquipoPorId_EquipoExiste() {
        // Arrange
        Equipo equipo = new Equipo();
        equipo.setId(1);
        equipo.setNombre("Equipo Prueba");

        when(equipoRepository.findById(1)).thenReturn(Optional.of(equipo));

        // Act
        ResponseEntity<?> response = equipoService.obtenerEquipoPorId(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Equipo);
        assertEquals("Equipo Prueba", ((Equipo) response.getBody()).getNombre());

        verify(equipoRepository, times(1)).findById(1);
    }

    @Test
    void obtenerEquipoPorId_EquipoNoExiste() {
        // Arrange
        when(equipoRepository.findById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> response = equipoService.obtenerEquipoPorId(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("Equipo no encontrado", response.getBody());

        verify(equipoRepository, times(1)).findById(1);
    }

    @Test
    void crearEquipo_Exito() {
        // Arrange
        Liga liga = new Liga();
        Pais pais = new Pais();
        pais.setId(1);
        liga.setPais(pais);

        Equipo equipo = new Equipo();
        equipo.setNombre("Nuevo Equipo");
        equipo.setLiga(liga);

        when(paisRepository.existsById(1)).thenReturn(true);
        when(equipoRepository.save(any(Equipo.class))).thenReturn(equipo);

        // Act
        ResponseEntity<?> response = equipoService.crearEquipo(equipo);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Equipo);
        assertEquals("Nuevo Equipo", ((Equipo) response.getBody()).getNombre());

        verify(paisRepository, times(1)).existsById(1);
        verify(equipoRepository, times(1)).save(equipo);
    }

    @Test
    void eliminarEquipo_Exito() {
        // Arrange
        Equipo equipo = new Equipo();
        equipo.setId(1);

        when(equipoRepository.findById(1)).thenReturn(Optional.of(equipo));

        // Act
        ResponseEntity<?> response = equipoService.eliminarEquipo(1);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(equipoRepository, times(1)).findById(1);
        verify(equipoRepository, times(1)).delete(equipo);
    }

    @Test
    void eliminarEquipo_NoExiste() {
        // Arrange
        when(equipoRepository.findById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> response = equipoService.eliminarEquipo(1);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("Equipo no encontrado", response.getBody());

        verify(equipoRepository, times(1)).findById(1);
    }
}
