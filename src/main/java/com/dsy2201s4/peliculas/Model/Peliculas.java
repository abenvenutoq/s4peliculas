package com.dsy2201s4.peliculas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "titulo", "año", "director", "genero", "sinopsis"})

@Entity
@Table(name = "Peliculas")
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    @Column(name = "titulo")
    private String titulo;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    @Max(value = 2900, message = "El año debe ser menor o igual a 2900")
    @Column(name = "año")
    private Integer año;

    @NotNull(message = "El director es obligatorio")
    @Size(max = 50, message = "El director no puede tener más de 50 caracteres")
    @Column(name = "director")
    private String director;

    @NotNull(message = "El género es obligatorio")
    @Size(max = 30, message = "El género no puede tener más de 30 caracteres")
    @Column(name = "genero")
    private String genero;

    @NotNull(message = "La sinopsis es obligatoria")
    @Size(max = 500, message = "La sinopsis no puede tener más de 500 caracteres")
    @Column(name = "sinopsis")
    private String sinopsis;


    //GETTERS

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public Integer getAño(){
        return año;
    }

    public String getDirector(){
        return director;
    }

    public String getGenero(){
        return genero;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    // SETTER

    public void setId(Long id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAño(Integer año){
        this.año = año;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setSinopsis(String sinopsis){
        this.sinopsis = sinopsis;
    }



    
}
