package com.PT_RH_01.casale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "liga")
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liga_seq_gen")
    @SequenceGenerator(name = "liga_seq_gen", sequenceName = "LIGA_SEQ", allocationSize = 1)
    private Integer id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.DETACH)  // Cambiado a DETACH para que no cree el país
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "liga", cascade = CascadeType.MERGE, orphanRemoval = true)  // Solo merge, no persist
    @JsonIgnore
    private List<Equipo> equipos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Liga(Integer id, String nombre, Pais pais, List<Equipo> equipos) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.equipos = equipos;
    }

    public Liga() {
    }
}
