
import java.util.Scanner;


public class Programa1 {

   
    public static void main(String[] args) {
       
        //Primero importamos la clase Scanner para trabajar
        
        Scanner sc = new Scanner(System.in); //La entrada de los datos
        
        //Declaracion de variables 
        
        String nombre = "Ximena";
        int edad = 20;
        double salarioDiario = 523.5;
        boolean aprobado = true;
        char edificio = 'B';
        
        /*
   Esta sección solicita los datos al usuario
   y verifica que sean validos antes de
   continuar con el programa.
*/
        
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine();
        
        System.out.println("Ingrese su edad");
        edad = sc.nextInt();
        
        System.out.println("Ingrese su salario diario: Q ");
        salarioDiario = sc.nextDouble();
        
        System.out.println("Fue aprobado al puesto? ");
        aprobado = sc.nextBoolean();
        
        System.out.println("El edificio donde estara: ");
        edificio = sc.next().charAt(0);
        
    }
    
}
