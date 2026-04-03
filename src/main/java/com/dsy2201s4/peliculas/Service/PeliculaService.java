package com.dsy2201s4.peliculas.Service;

import com.dsy2201s4.peliculas.Model.Peliculas;
import java.util.List;
import java.util.Optional;


public interface PeliculaService{

    List<Peliculas> getAllPeliculas();
    Optional<Peliculas> getPeliculasById(Long id);

}

