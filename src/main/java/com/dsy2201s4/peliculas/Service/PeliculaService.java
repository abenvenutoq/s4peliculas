package com.dsy2201s4.peliculas.Service;

import com.dsy2201s4.peliculas.Model.Peliculas;
import java.util.List;
import java.util.Optional;


public interface PeliculaService{

    List<Peliculas> getAllPeliculas();
    Optional<Peliculas> getPeliculasById(Long id);

    // Metodo para Crear

    Peliculas createPeliculas(Peliculas peliculas);

    // Metodo para modificar

    Peliculas updatePeliculas(Long id, Peliculas peliculas);

    // Metodo para eliminar

    void deletePeliculas(Long id);

}

