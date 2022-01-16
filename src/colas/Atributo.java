/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

public class Atributo {
    
    private String nombre;
    private String tipo;
    private String alcance;

    public Atributo(String nombre, String tipo, String alcance) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.alcance = alcance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return "Atributo{" + "nombre=" + nombre + ", tipo=" + tipo + ", alcance=" + alcance + '}';
    }


    
    
}
