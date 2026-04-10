package com.dsy2201s4.peliculas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsy2201s4.peliculas.Model.Peliculas;
import com.dsy2201s4.peliculas.Service.PeliculaService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Peliculas> getAllPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Peliculas> getPelicuasById(@PathVariable Long id) {
        return peliculaService.getPeliculasById(id);
    }

    // Controlador para el crear peliculas
    @PostMapping()
    public Peliculas creatPeliculas(@RequestBody Peliculas peliculas) {
        return peliculaService.createPeliculas(peliculas);
    }

    // Controlador para actualizar peliculas
    @PutMapping("/{id}")
    public Peliculas updatePeliculas(@PathVariable Long id, @RequestBody Peliculas peliculas){
        return peliculaService.updatePeliculas(id, peliculas);
    }

    // Controlador para borrar peliculas
    @DeleteMapping("/{id}")
    public void deletePeliculas(@PathVariable Long id){
        peliculaService.deletePeliculas(id);
    }
}
