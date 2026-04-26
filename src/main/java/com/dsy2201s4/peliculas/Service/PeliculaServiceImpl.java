package com.dsy2201s4.peliculas.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy2201s4.peliculas.Model.Peliculas;
import com.dsy2201s4.peliculas.Repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Peliculas> getAllPeliculas(){
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Peliculas> getPeliculasById(Long id){

        return peliculaRepository.findById(id);

    }

    // Logica para crear peliculas

    @Override
    public Peliculas createPeliculas(Peliculas peliculas){
        return peliculaRepository.save(peliculas);
    }

    // Logica para modificar peliculas
    @Override
    public Peliculas updatePeliculas(Long id, Peliculas peliculas){
        if(peliculaRepository.existsById(id)){
            peliculas.setId(id);
            return peliculaRepository.save(peliculas);
        }
        else{
            return null;
        }
    }

    // Logica para eliminar peliculas
    @Override
    public void deletePeliculas(Long id){
        peliculaRepository.deleteById(id);
    }
    
}
