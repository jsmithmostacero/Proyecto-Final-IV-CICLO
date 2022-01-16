/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

public class Cola {
    private Nodo cabeza;
    private Nodo ultimo;
    private int cantidad;

    public Cola() {
        this.cabeza = null;
        this.ultimo = null;
        this.cantidad = 0;
    }
    
    public void encolar(Atributo obj){
        Nodo nuevo = new Nodo(obj);
        
        if(cabeza==null){
            cabeza = nuevo;
            ultimo = nuevo;
        }else{
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        cantidad++;
    }
    
    public void desencolar(){
        Nodo temp = cabeza;
        cabeza = cabeza.siguiente;
        temp = null;
        cantidad--;
    }
    
    public void mostrar(){
        Nodo tem = cabeza;
        if(tem!=null){
            while (tem!=null) {                
                System.out.println(tem.atb.getNombre().toString());
                tem = tem.siguiente;
            }
        }
    }
    
    
    public Atributo buscar(int i){
        Nodo temp = cabeza;
        if(temp!=null){
            int cont=0;
            while (temp!=null) {
                if(i==cont){
                    return temp.atb;
                }
                cont++;
                temp = temp.siguiente;
            }
        } 
        return null;
    }
    
    public int tamanio(){
        return cantidad;
    }
    
    public void desencolarTotal(){
        for (int i = 0; i < tamanio(); i++) {
            desencolar();
        }
    }
    
    
}
