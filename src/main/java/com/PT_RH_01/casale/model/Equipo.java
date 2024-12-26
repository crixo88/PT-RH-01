package com.PT_RH_01.casale.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipo_seq_gen")
    @SequenceGenerator(name = "equipo_seq_gen", sequenceName = "EQUIPO_SEQ", allocationSize = 1)
    private Integer id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.DETACH)  // Se detalla el tipo de cascada
    @JoinColumn(name = "liga_id")
    private Liga liga;

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

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Equipo(Integer id, String nombre, Liga liga) {
        this.id = id;
        this.nombre = nombre;
        this.liga = liga;
    }

    public Equipo() {
    }
}
