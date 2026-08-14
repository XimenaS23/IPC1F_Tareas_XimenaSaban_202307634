import java.util.Scanner;

public class Programa1 {

    public static void main(String[] args) {

        // Primero importamos la clase Scanner para trabajar
        Scanner sc = new Scanner(System.in);

        // Declaramos las variables
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
            System.out.println("El estudiante no esta aprobado");
            sc.close();
            return;
        }

        // La cantidad de numeros que el usuario ingresara
        int cantidad = 5;

        // Arreglo de una dimension
        int[] datos = leerDatos(sc, cantidad, 1, 100);
        double promedio = procesarArreglo(datos);
        mostrarResultados(datos, promedio, curso, notas);

        // Matriz de dos dimensiones
        int filas = 2;
        int columnas = 2;

        int[][] matriz = llenarMatriz(sc, filas, columnas);
        mostrarMatriz(matriz);

        sc.close();
    }

    // Metodo 1: lectura de datos
    public static int[] leerDatos(Scanner sc, int cantidad, int min, int max) {

        int[] arreglo = new int[cantidad];

        System.out.println("Solicitar " + cantidad
                + " calificaciones entre " + min + " y " + max + ":");

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

            try {
                valor = Integer.parseInt(entrada);

                // Validacion de rango
                if (valor >= min && valor <= max) {
                    esValido = true;
                } else {
                    System.out.println(
                            "Error: Debe ingresar un número entre "
                            + min + " y " + max);
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no valida");
            }

        } while (!esValido);

        return valor;
    }

    // Metodo 3: Procesar un arreglo de una dimension
    public static double procesarArreglo(int[] arreglo) {

        int suma = 0;

        for (int num : arreglo) {
            suma += num;
        }

        return (double) suma / arreglo.length;
    }

    // Metodo 4: Mostrar los resultados del arreglo
    public static void mostrarResultados(
            int[] arreglo,
            double promedio,
            char seccion,
            double calificacion) {

        int maximo = arreglo[0];
        int minimo = arreglo[0];

        // Recorrer el arreglo para encontrar maximo y minimo
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
            System.out.println(
                    "Calificacion " + (i + 1) + ": " + arreglo[i]);
        }

        System.out.println(" ");
        System.out.println("Valor maximo: " + maximo);
        System.out.println("Valor minimo: " + minimo);
        System.out.println("Promedio obtenido: " + promedio);
        System.out.println(" ");
    }

    // Metodo 5: Llenar una matriz (arreglo de dos dimensiones)
    public static int[][] llenarMatriz(
            Scanner sc,
            int filas,
            int columnas) {

        int[][] matriz = new int[filas][columnas];

        System.out.println(" ");
        System.out.println("Ingrese los datos para la matriz:");
        System.out.println(" ");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                matriz[i][j] = pedirEnteroMatriz(
                        sc,
                        "Ingrese el valor para ["
                        + i + "][" + j + "]: ");
            }
        }

        return matriz;
    }

    // Metodo 6: Validar los datos de la matriz
    public static int pedirEnteroMatriz(
            Scanner sc,
            String mensaje) {

        int valor = 0;
        boolean esValido = false;

        do {

            System.out.print(mensaje);

            String entrada = sc.nextLine().trim();

            try {

                valor = Integer.parseInt(entrada);
                esValido = true;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: Debe ingresar un numero entero");
            }

        } while (!esValido);

        return valor;
    }

    // Metodo 7: Mostrar la matriz y calcular la suma
    public static void mostrarMatriz(int[][] matriz) {

        int suma = 0;

        System.out.println(" ");
        System.out.println("Matriz ingresada:");

        for (int i = 0; i < matriz.length; i++) {

            System.out.print("Fila " + (i + 1) + ": ");

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + "\t");

                suma += matriz[i][j];
            }

            System.out.println();
        }

        System.out.println(" ");
        System.out.println(
                "Suma de todos los elementos: " + suma);
        System.out.println(" ");
    }
}