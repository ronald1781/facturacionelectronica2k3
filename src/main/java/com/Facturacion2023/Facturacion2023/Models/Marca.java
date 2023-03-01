package com.Facturacion2023.Facturacion2023.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer idmarca;
    @NotNull
    private String nombre;

    @OneToMany(mappedBy ="marca",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos = new LinkedHashSet<>();

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<Producto> getProductos(){

        return productos;
    }
    public void setProductos(Set<Producto> productos){
    this.productos=productos;
    for ( Producto prod : productos){

        prod.setMarca(this);
    }

    }

}
