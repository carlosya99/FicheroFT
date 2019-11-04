/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroft;

/**
 *
 * @author Carlos Zea
 */
public class Clientes {

    public static void main(String[] args) {
        try {
            java.io.File ff = new java.io.File("ficheroAleatorio.txt");
            java.io.RandomAccessFile aa = new java.io.RandomAccessFile(ff, "rw");

            char nombre[] = new char[25]; //nos creamos el array de nombre
            nombre[0] = 'j'; //damos valores al array
            nombre[1] = 'e';
            nombre[2] = 's';
            nombre[3] = 'u';
            nombre[4] = 's';
            /*el resto de valores del array (del 5 al 24) estarán vacíos*/

            //nos creamos un objeto registro nuevo y le damos valores
            Registro reg = new Registro(nombre, 5.0f, 4.0f, 4.0f, 9.25f);

            //llamamos a los procedimientos y finalizamos el programa.
            Registro.grabarRegistro(aa, reg, ff);
            Registro.leerDatos(aa, ff);

        } catch (java.io.IOException ioex) {
        }
    }
//definimos la clase Registro con la estructura que va a tener el fichero.En nuestro caso , el nombre del alumno y 4 notas.

    public class Registro {

        protected char nombre[];
        protected float parcial1, parcial2, talleres, proyecto;
        protected int tam; 
//esta variable nos va a servir para
//almacenar el tamaño del registro.
        


        public Registro() {
        } 
//primera manera de crearnos el registro,
//sin meter ningún parámetro
        //segunda manera de crearnos el registro, metiendo todos los
//campos posibles

        public Registro(String nombre, float nota1, float nota2, float nota3, float nota4) {
            this.nombre = new char[25];
            this.nombre = nombre;
            parcial1 = nota1;
            parcial2 = nota2;
            talleres = nota3;
            proyecto = nota4;
            /*El tamaño total del registro será de 66 bytes:
(25*2)+(4*4)
(25 char que forman el nombre * 2 bytes que ocupa cada char ) + (4
notas de tipo float * 4 bytes, ya que los datos de tipo float ocupan 4
bytes) */
//Ejemplo de escritura. Recibimos el objeto RandomAccessFile, el objeto Registro y el objeto File
        

        

        
public static void grabarRegistro(RandomAccessFile aa, Registro estudiante File fal) throws IOException {
// desplazarse al final del archivo
int longitud = (int) fal.length();
            aa.seek(longitud);
// escribir datos del registro en el archivo aleatorio
            for (int i = 0; i < (estudiante.nombre).length; i++) {
                aa.writeChar(estudiante.nombre[i]);
            }
            aa.writeFloat(estudiante.parcial1);
            aa.writeFloat(estudiante.parcial2);
            aa.writeFloat(estudiante.talleres);
            aa.writeFloat(estudiante.proyecto);
//mostramos el tamaño del fichero una vez escrito en el fichero
            longitud = (int) fal.length();
            System.out.println("length file: " + longitud);
        }

        /*Declaramos el procedimiento que primero calcula cuántos registros
hay en el fichero, luego llama a una función que se encarga de leer
todos los registros del fichero, y por último, mostramos por pantalla
dichos registros.*/
//Recibimos el objeto RandomAccessFile y el objeto File.
        public static void leerDatos(RandomAccessFile aa, File fal) throws
                IOException {
            int pos = 0;
            int longitud = (int) fal.length();/*con la función length nos
decielve lo que ocupa el fichero. Lo convertimos a un valor de tipo
int y lo almacenamos en la variable longitud.*/
            int lreg = 66; //lo que ocupa un registro.
            int regs = longitud / lreg; //número de registros en el fichero
            System.out.println("Número total de registros en el fichero: "
                    + regs);
            System.out.println("Cada registro ocupa: " + lreg);
            /*Si hay algún registro en el fichero, vamos a ir leyendo cada
registro del fichero. Para leer un registro llamamos a la función
leerRegistro, que nos devuelve un objeto de la clase registro. Dicho
objeto lo vamos a ir almacenando en un array que va a contener datos
de tipo registro. De esa manera, cuando lleguemos al final del
fichero, tendremos en ese array todos los registros que había en el
fichero.*/
            if (regs > 0) {
                Registro vector[] = leerRegistro(aa, regs, lreg);
                for (int i = 0; i < regs; i++) {
                    /*Hacemos tantas pasadas en el
bucle como registros haya. Recordar que quien me indica el número de
registros es la variable regs.*/

//convertimos el array[] del campo nombre a string, y mostramos por pantalla el alumno y sus notas
                    
 String nom = new String(vector[i].nombre);
                    System.out.println(nom + " " + vector[i].parcial1 +
                
                    {
                        ""+vector[i].parcial2+" "+vector[i].talleres+""+vector[i].proyecto);

                    }
                }
                else
System.out.println("Archivo vacio !!!");
            }
        }
        /* Definimos la función que va a leer los registros que hay en el
fichero y va a devolver como resultado un array de registro con todos
los registros del fichero.
public static Registro[] leerRegistro(RandomAccessFile aa, int regs,
int lreg)throws IOException{
/* Nos creamos un array de tipo registro que es lo que va a
devolver la función, indicando con la variable regs el número de
registros que va a tener.*/
        Registro vector[] = new Registro[regs];
        aa.seek(0);
for (int i = 0;
        i< regs ;
        i

        
            ++){ /*Hacemos tantas pasadas como
registros haya en el fichero.*/
char nombre[] = new char[25];
            for (int k = 0; k < nombre.length; k++) /*leemos el nombre
carácter a carácter a través de un bucle. Hacemos tantas pasadas como
longitud tenga el nombre. Recordad que el nombre está almacenado en un
array char de 25 posiciones.*/ {
                nombre[k] = aa.readChar();
            }
// Almacenamos el nombre leído en una variable String.
            String aux = new String(nombre);
            float nota1 = aa.readFloat(); //leemos las 4 notas.
            float nota2 = aa.readFloat();
            float nota3 = aa.readFloat();
            float nota4 = aa.readFloat();
            /*una vez leído el primer registro, almacenamos los campos
de dicho registro en una variable de tipo registro*/
            Registro datos = new Registro(aux, nota1, nota2, nota3,
                    nota4);
            /* Por último metemos dicho registro en la siguiente
posición vacía del array de registros.*/
            vector[i] = datos;
        }
// Devolvemos el array con todos los registros del fichero.
        return vector ;
    }
} //se cierra la clase registro
