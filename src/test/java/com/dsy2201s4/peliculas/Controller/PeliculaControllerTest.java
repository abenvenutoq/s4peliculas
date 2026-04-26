package com.dsy2201s4.peliculas.Controller;

import com.dsy2201s4.peliculas.Model.Peliculas;
import com.dsy2201s4.peliculas.Service.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PeliculaService peliculaService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Peliculas peliculaMock;

    @BeforeEach
    void setUp() {
        peliculaMock = new Peliculas();
        peliculaMock.setId(1L);
        peliculaMock.setTitulo("El Padrino");
        peliculaMock.setAño(1972);
        peliculaMock.setDirector("Francis Ford Coppola");
        peliculaMock.setGenero("Drama");
        peliculaMock.setSinopsis("La historia de la familia Corleone.");
    }

    @Test
    void testGetAllPeliculas() throws Exception {
        when(peliculaService.getAllPeliculas()).thenReturn(Arrays.asList(peliculaMock));

        mockMvc.perform(get("/peliculas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].titulo").value("El Padrino"));
    }

    @Test
    void testGetPeliculasById() throws Exception {
        when(peliculaService.getPeliculasById(1L)).thenReturn(Optional.of(peliculaMock));

        mockMvc.perform(get("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El Padrino"))
                .andExpect(jsonPath("$.director").value("Francis Ford Coppola"));
    }

    @Test
    void testCreatePeliculas() throws Exception {
        when(peliculaService.createPeliculas(any(Peliculas.class))).thenReturn(peliculaMock);

        mockMvc.perform(post("/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculaMock)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.titulo").value("El Padrino"));
    }

    @Test
    void testUpdatePeliculas() throws Exception {
        when(peliculaService.updatePeliculas(eq(1L), any(Peliculas.class))).thenReturn(peliculaMock);

        mockMvc.perform(put("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculaMock)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El Padrino"));
    }

    @Test
    void testDeletePeliculas() throws Exception {
        doNothing().when(peliculaService).deletePeliculas(1L);

        mockMvc.perform(delete("/peliculas/1"))
                .andExpect(status().isOk());
    }
}