
import java.util.Scanner;

public class Programa1 {

    public static void main(String[] args) {

        // Primero importamos la clase Scanner para trabajar
       
        Scanner sc = new Scanner(System.in); // La entrada de los datos

        // declaramos las variables
        String nombre = "Ximena";
        int edad = 20;
        double notas = 95.3;
        boolean aprobado = true;
        char curso = 'F';

        System.out.println("Sistema de ingreso de datos: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Seccion del curso: " + curso);
        System.out.println(" ");

        if (!aprobado) {
            System.out.println("El estudiante no está aprobado.");
            sc.close();
            return;
        }

        // La cantidad de numeros que el usuario ingresará
        int cantidad = 5;

        
        int[] datos = leerDatos(sc, cantidad, 1, 100);
        double promedio = procesarArreglo(datos);
        mostrarResultados(datos, promedio, curso, notas);

        sc.close();
    }

    // Metodo 1: Lectura de datos
    public static int[] leerDatos(Scanner sc, int cantidad, int min, int max) {
        int[] arreglo = new int[cantidad];
        System.out.println("Solicitar " + cantidad + " calificaciones entre " + min + " y " + max + ":");

        for (int i = 0; i < cantidad; i++) {
            arreglo[i] = pedirEntero(sc, "Ingrese el valor: ", min, max);
        }
        return arreglo;
    }

    /**
     * Metodo 2: Validacion de entrada por consola.
     * Maneja excepciones de tipo de dato y valida el rango.
     */
    public static int pedirEntero(Scanner sc, String mensaje, int min, int max) {
        int valor = 0;
        boolean esValido = false;

        do {
            System.out.print(mensaje + " ");
            String entrada = sc.nextLine().trim();

            try {  // permite que no se cierre por error
                valor = Integer.parseInt(entrada);

                // Validacion de rango
                if (valor >= min && valor <= max) {
                    esValido = true;
                } else {
                    System.out.println(" Error: Debe ingresar un número entre " + min + " y " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println(" Error: Entrada no valida");
            }

        } while (!esValido);

        return valor;
    }

    /**
     * Metodo 3: Procesar un arreglo
     */
    public static double procesarArreglo(int[] arreglo) {
        int suma = 0;
   
    for (int num : arreglo) {
        suma += num;
    }

    return (double) suma / arreglo.length;
}
    /**
     * Metodo 4: Mostrar los resultados
     */
    public static void mostrarResultados(int[] arreglo, double promedio, char seccion, double calificacion) {
        
        int maximo = arreglo[0]; //arreglo de una dimension 
        int minimo = arreglo[0];
        
    for (int num : arreglo) {

        if (num > maximo) {
            maximo = num;
        }

        if (num < minimo) {
            minimo = num;
        }
    }
        System.out.println(" ");
        System.out.println("Calificaciones ingresadas:");
        System.out.println(" ");
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Calificacion " + (i + 1) + ": " + arreglo[i]);
        }
        System.out.println(" ");
        System.out.println("Valor maximo: " + maximo);
        System.out.println("Valor minimo: " + minimo);
        System.out.println("Promedio obtenido: " + promedio);
        System.out.println(" ");
        
    }
}