package com.dsy2201s4.peliculas.Service;

import com.dsy2201s4.peliculas.Model.Peliculas;
import com.dsy2201s4.peliculas.Repository.PeliculaRepository; // Asegúrate de que esta ruta sea la correcta
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceImplTest {

    @Mock
    private PeliculaRepository peliculaRepository; 

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private Peliculas peliculaMock;

    @BeforeEach
    void setUp() {
        peliculaMock = new Peliculas();
        peliculaMock.setId(1L);
        peliculaMock.setTitulo("Matrix");
        peliculaMock.setAño(1999);
        peliculaMock.setDirector("Lana Wachowski, Lilly Wachowski");
        peliculaMock.setGenero("Sci-Fi");
        peliculaMock.setSinopsis("Un hacker descubre la verdadera naturaleza de su realidad.");
    }

    @Test
    void testGetAllPeliculas() {
        
        when(peliculaRepository.findAll()).thenReturn(Arrays.asList(peliculaMock));

        List<Peliculas> resultado = peliculaService.getAllPeliculas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Matrix", resultado.get(0).getTitulo());
        verify(peliculaRepository, times(1)).findAll();
    }

    @Test
    void testGetPeliculasById() {

        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(peliculaMock));

        Optional<Peliculas> resultado = peliculaService.getPeliculasById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Matrix", resultado.get().getTitulo());
        verify(peliculaRepository, times(1)).findById(1L);
    }

    @Test
    void testCreatePeliculas() {

        when(peliculaRepository.save(any(Peliculas.class))).thenReturn(peliculaMock);

        Peliculas guardada = peliculaService.createPeliculas(peliculaMock);

        assertNotNull(guardada);
        assertEquals("Matrix", guardada.getTitulo());
        verify(peliculaRepository, times(1)).save(any(Peliculas.class));
    }

    @Test
    void testUpdatePeliculas() {

        when(peliculaRepository.existsById(1L)).thenReturn(true);
        when(peliculaRepository.save(any(Peliculas.class))).thenReturn(peliculaMock);

        Peliculas datosNuevos = new Peliculas();
        datosNuevos.setTitulo("Matrix Reloaded");
        datosNuevos.setAño(2003);
        datosNuevos.setDirector("Wachowskis");
        datosNuevos.setGenero("Sci-Fi");
        datosNuevos.setSinopsis("Neo controla la Matrix.");

        Peliculas actualizada = peliculaService.updatePeliculas(1L, datosNuevos);

        assertNotNull(actualizada);
        verify(peliculaRepository, times(1)).existsById(1L);
        verify(peliculaRepository, times(1)).save(any(Peliculas.class));
    }

    @Test
    void testDeletePeliculas() {

        doNothing().when(peliculaRepository).deleteById(1L);

        peliculaService.deletePeliculas(1L);

        verify(peliculaRepository, times(1)).deleteById(1L);
    }
}