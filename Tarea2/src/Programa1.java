
import java.util.Scanner;


public class Programa1 {
     
    //Primero importamos la clase Scanner para trabajar
        
    static Scanner sc = new Scanner(System.in); //La entrada de los datos
    
    public static void main(String[] args) {
       
        //Declaracion de variables 
        
        String nombre = "Ximena";
        int edad = 20;
        double notas = 95.3;
        boolean aprobado = true;
        char curso = 'F';

        System.out.println("Sistema de ingreso de datos: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Seccion del curso: " + curso);
        
        if (!aprobado) {
            System.out.println("El estudiante no esta aprobado");
            sc.close();
            return;
        }
        //la cantidad de numeros que el usuario ingresara
        int cantidad = 5;
        
        int[] datos = leerDatos(cantidad, 1 , 100);
        double promedio = procesarArreglo(datos);
        mostrarResultados(datos,promedio,curso,notas);
    }
    
    
    //Metodo 1 : Lectura de datos
    
        public static int[] leerDatos(int cantidad, int min, int max) {
        int[] arreglo = new int[cantidad];
        System.out.println(" ");
        System.out.println("Solicitar " + cantidad + " calificaciones entre 1 y 100: ");

        for (int i = 0; i < cantidad; i++) {
            arreglo[i] = pedirEntero("Ingrese el valor: ", min, max);
        }
        return arreglo;
    }
       
    /**
     * Metodo 2: Validacion de entrada por consola.
     * Maneja excepciones de tipo de dato y valida el rango.
     */
    public static int pedirEntero(String mensaje, int min, int max) {
        int valor = 0;
        boolean esValido = false;

        do {
            System.out.print(mensaje + " ");
            String entrada = sc.nextLine().trim();

            try {
                valor = Integer.parseInt(entrada);

                // Validacion de rango
                if (valor >= min && valor <= max) {
                    esValido = true;
                } else {
                    System.out.println("Error: Debe ingresar un numero entre " + min + " y " + max + " ");
                }

            } catch (NumberFormatException e) {
                System.out.println(" Error: Entrada no valida");
            }

        } while (!esValido);

        return valor;
    }

    /**
     * Metodo 3: procesar un arreglo.
     */
    public static double procesarArreglo(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return (double) suma / arreglo.length;
    }

    /**
     * Metodo 4: mostrar los resultados
     */
    public static void mostrarResultados(int[] arreglo, double promedio, char seccion, double calificacion) {
       
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Resumen de resultados obtenidos: ");

        System.out.println("Seccion: " + seccion);
        System.out.println("Calificacion inicial: " + calificacion);
        
        System.out.println(" ");

        System.out.println("Calificaciones ingresadas:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(
                    "Valor " + (i + 1) + ": " + arreglo[i]
            );
        }

        System.out.println("\n Promedio obtenido: " + promedio);
     
    }
} 
       
