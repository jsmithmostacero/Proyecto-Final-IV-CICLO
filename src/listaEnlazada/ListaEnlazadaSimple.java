/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaEnlazada;

/**
 *
 * @author HP
 */
public class ListaEnlazadaSimple {

    private Nodo cabeza;
    private int cantidad;

    public ListaEnlazadaSimple() {
        cabeza = null;
        cantidad = 0;
    }

    //AGREGAR AL INICIO
    public void agregarStringInicio(String pReservada) {
        if (cabeza == null) {
            cabeza = new Nodo(pReservada);
        } else {
            Nodo nuevo = new Nodo(pReservada);
            nuevo.n = (cabeza);
            cabeza = nuevo;
        }
        cantidad++;
    }

    //AGREGAR AL FINAL
    public void agregarStringFinal(String pReservada) {
        if (cabeza == null) {
            cabeza = new Nodo(pReservada);
        } else {
            Nodo temp = cabeza;
            while (temp.n != null) {
                temp = temp.n;
            }
            Nodo nuevo = new Nodo(pReservada);
            temp.n = (nuevo);
        }
        cantidad++;
    }

    //AGREGAR EN UNA POSICION DADA
    public void agregarStringPos(int index, String pReservada) {
        Nodo nuevo = new Nodo(pReservada);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            if (index == 0) {
                agregarStringInicio(pReservada);
            } else {
                Nodo temp = cabeza;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.n;
                }
                nuevo.n = (temp.n);
                temp.n = (nuevo);
            }
        }
        cantidad++;
    }

    //ELIMINAR ARTICULO
    public void eliminarString(int pos) {
        if (pos == 0) {
            cabeza = cabeza.n;
        } else {
            int contador = 0;
            Nodo temp = cabeza;
            while (contador < pos - 1) {
                temp = temp.n;
                contador++;
            }
            temp.n = (temp.n.n);
        }
        cantidad--;
    }

    //MODIFICAR ARTICULO
    public void modificarNodo(String ant, String pos) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (cabeza.a.equals(ant)) {
                temp.a = (pos);
                break;
            }
            temp = temp.n;
        }
    }

    //MOSTRAR ARTICULOS
    public void mostrarStrings() {
        Nodo n = cabeza;
        while (n != null) {
            System.out.println(n.a);
            n = n.n;
        }
    }

    public int tamanio() {
        return cantidad;
    }

    //OBTENER DATOS DE UN ARTICULO CON UNA POSICION DADA
    public String obtenerString(int pos) {
        int contador = 0;
        Nodo temp = cabeza;

        while (contador < pos) {
            temp = temp.n;
            contador++;
        }
        return temp.a;
    }

}
