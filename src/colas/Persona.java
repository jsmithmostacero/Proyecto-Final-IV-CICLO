
package colas;

public class Persona{

   private String nombre;
   public int edad;

   public Persona(String nombre, int edad){
       this.nombre = nombre;
       this.edad = edad;
   }

   public void setnombre(String nombre){
       this.nombre = nombre;
   }
   public String getnombre(){
        return nombre;
   }


   public void setedad(int edad){
       this.edad = edad;
   }
   public int getedad(){
        return edad;
   }



   @Override
   public String toString() {
       return "Persona{ " + "nombre=" + nombre + "edad=" + edad;
  }



}