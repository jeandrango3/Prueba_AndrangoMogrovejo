//UserApplication

package com.example.RegistroUsuariosApplication.Users;

import jakarta.persistence.*;

@Entity
@Table
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String descripcion;
    private String precio;
    private String stock;

    public Products() {
    }

    public Products(Long id, String name, String descripcion , String precio, String stock) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }




}