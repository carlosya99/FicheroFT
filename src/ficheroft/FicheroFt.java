/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroft;
import java.io.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 *
 * @author Carlos Zea
 */
public class FicheroFt {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("¿Desea leer ?: \n");
            String respuesta1 = sc.nextLine();
            if(respuesta1 == "si"){
                System.out.println("Introduzca el fichero a leer: \n");
                String fichero = sc.nextLine();
                leerDatos(fichero);
            }
            
            System.out.println("¿Desea dar de alta un cliente ?: \n");
            String respuesta2 = sc.nextLine();
            if(respuesta1 == "si"){
                System.out.println("Introduzca el fichero a cambiar: \n");
                String fichero = sc.nextLine();
                añadirDatos(fichero);
            }
            
            System.out.println("¿Desea dar de baja un cliente ?: \n");
            String respuesta3 = sc.nextLine();
            if(respuesta1 == "si"){
                System.out.println("Introduzca el fichero a cambiar: \n");
                String fichero = sc.nextLine();
                eliminarDatos(fichero);
            }
        } catch (Exception e) {
            System.out.println("");

        }
        
    }

    
    public static void leerDatos(String archivo) {
        String texto = new String();
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader(fr);
               //Metodo caracter a caracter
            int contador = 0;
            char c;
            int caracter = entrada.read();
            while(caracter != -1){
                c= (char) caracter;
                System.out.print(c);
                contador = contador + 1;
                caracter = entrada.read();
            }
            System.out.println("\n Tamaño del fichero: " + contador);
            
            entrada.close();
            
        }
        catch(java.io.FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado" + fnfex);
        }
        catch(java.io.IOException ioex){}
    }
    
    public static void añadirDatos(String archivo) throws IOException {
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader entrada = new BufferedReader(fr);
               //Metodo caracter a caracter
            int contador = 0;
            char c;
            int caracter = entrada.read();
            while(caracter != -1){
                c= (char) caracter;
                System.out.print(c);
                contador = contador + 1;
                caracter = entrada.read();
            }
            System.out.println("\n Tamaño del fichero: " + contador);
            
            entrada.close();   
        }
        catch(java.io.FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado" + fnfex);
        }
        
        try{
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter entrada = new BufferedWriter(fw);
            .seek( archivo.length() );      
        }
        catch(java.io.FileNotFoundException fnfex){
            System.out.println("Archivo no encontrado" + fnfex);
        }
        
        
        catch(java.io.IOException ioex){}
    }
}
