package presentacion;

import colas.Cola;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */
public final class Clase {

    private final File miDir = new File(".");
    private String nPackage;
    private String c;
    private String nClase;
    private Cola cola;

    @SuppressWarnings("empty-statement")
    public Clase(String nPackage, String nClase, Cola cola) {
        try {
            c = miDir.getCanonicalPath() + "/src";
            this.nPackage = nPackage;
            this.nClase = nClase;
            this.cola = cola;
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void crearPackClass(boolean constructor, boolean getAndset, boolean toString) {
        CrearPaquete();
        CrearClase();
        Escribir(constructor,getAndset,toString);
    }

    private void CrearPaquete() {
        File directorio = new File(c + "/" + nPackage);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    private void CrearClase() {
        try {
            String nCpt = c + "/" + nPackage + "/" + nClase + ".java";
            File packag = new File(nCpt);
            packag.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void Escribir(boolean constructor, boolean getAndset, boolean toString) {
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(c + "/" + nPackage + "/" + nClase + ".java"));  //clears file every time
            if (!(nPackage.equals(""))) {
                output.append("\npackage " + nPackage + ";");
            }
            output.append("\n\npublic class " + nClase + "{\n\n");

            for (int i = 0; i < cola.tamanio(); i++) {
                output.append("   " + cola.buscar(i).getAlcance() + " " + cola.buscar(i).getTipo() + " " + cola.buscar(i).getNombre() + ";\n");
            }
            if (constructor) {
                output.append("\n   public " + nClase + "(");
                for (int i = 0; i < cola.tamanio() - 1; i++) {
                    output.append(cola.buscar(i).getTipo() + " " + cola.buscar(i).getNombre() + ", ");
                }
                output.append(cola.buscar(cola.tamanio() - 1).getTipo() + " " + cola.buscar(cola.tamanio() - 1).getNombre() + "){");

                for (int i = 0; i < cola.tamanio(); i++) {
                    output.append("\n       this." + cola.buscar(i).getNombre() + " = " + cola.buscar(i).getNombre() + ";");
                }
                output.append("\n   }\n");
            }

            if (getAndset) {
                for (int i = 0; i < cola.tamanio(); i++) {
                    output.append("\n   public void set" + cola.buscar(i).getNombre() + "(" + cola.buscar(i).getTipo() + " " + cola.buscar(i).getNombre() + "){\n       this." + cola.buscar(i).getNombre() + " = " + cola.buscar(i).getNombre() + ";\n   }");
                    output.append("\n   public " + cola.buscar(i).getTipo() + " get" + cola.buscar(i).getNombre() + "(){\n        return " + cola.buscar(i).getNombre() + ";\n   }\n\n");
                }
            }
            if (toString) {
                output.append("\n\n   @Override\n   public String toString() {\n       return ");
                output.append((char) 34 + nClase + "{ " + (char) 34 + " + ");
                for (int i = 0; i < cola.tamanio() - 1; i++) {
                    output.append((char) 34 + cola.buscar(i).getNombre() + "=" + (char) 34 + " + " + cola.buscar(i).getNombre() + " + ");
                }

                output.append((char) 34 + cola.buscar(cola.tamanio() - 1).getNombre() + "=" + (char) 34 + " + " + cola.buscar(cola.tamanio() - 1).getNombre() + ";\n  }\n\n");
            }
            output.append("\n\n" + "}");

            output.close();
        } catch (IOException ex) {
            System.out.println(ex);;
        }

    }

}
