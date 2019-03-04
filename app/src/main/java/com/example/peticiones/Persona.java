package com.example.peticiones;

public class Persona {
    private String Nombre;
    private String Apellido;
    private int Edad;


    public Persona(String nombre, String apellido, int edad){
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public String getNombre(){
     return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public void setNombre(String nombre){
        Nombre = nombre;
    }

    public void setApellido(String apellido){
        Apellido = apellido;
    }

    public int getEdad(){
        return Edad;
    }

    public void setEdad(int edad){
        Edad = edad;
    }
}


