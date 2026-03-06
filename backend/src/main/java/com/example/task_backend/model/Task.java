package com.example.task_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. Indica que esta clase es una tabla en la BD
public class Task {

    @Id // 2. Define este campo como la Clave Primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Autoincrementa el ID
    private Long id;
    
    private String title;
    private Boolean completed;

    // Tus getters y setters actuales son correctos, solo asegúrate de 
    // cambiar el tipo de dato de 'int' a 'Long' para el id.
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }
}