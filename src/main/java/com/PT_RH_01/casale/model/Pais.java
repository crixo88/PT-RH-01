package com.PT_RH_01.casale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_seq_gen")
    @SequenceGenerator(name = "pais_seq_gen", sequenceName = "PAIS_SEQ", allocationSize = 1)
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "pais", orphanRemoval = true)  // Se configura correctamente la relación con la Liga
    @JsonIgnore
    private List<Liga> ligas;

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

    public List<Liga> getLigas() {
        return ligas;
    }

    public void setLigas(List<Liga> ligas) {
        this.ligas = ligas;
    }

    public Pais(Integer id, String nombre, List<Liga> ligas) {
        this.id = id;
        this.nombre = nombre;
        this.ligas = ligas;
    }

    public Pais() {
    }
}
