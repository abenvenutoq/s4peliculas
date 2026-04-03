package com.dsy2201s4.peliculas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsy2201s4.peliculas.Model.Peliculas;

public interface PeliculaRepository extends JpaRepository<Peliculas, Long>{
    
}
