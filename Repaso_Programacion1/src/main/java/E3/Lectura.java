package E3;

import java.util.Scanner;

/*
Implementa dos funciones para obtener, la parte entera y la parte decimal de un número en
punto flotante (double). La definición de las funciones es como sigue:

int getParteEntera(double numero) (0.75 puntos)

int getParteDecimal(double numero) (0.75 puntos)

Internamente, estas dos funciones convierten el número double a cadena de caracteres para
obtener la parte correspondiente.

Una vez obtenido el valor buscado, la cadena se convertirá al tipo de retorno indicado.

Además el programa principal (main) pedirá al usuario que introduzca un número por teclado y
posteriormente mostrará un menú por pantalla en el que se pregunte si desea obtener la parte
entera o decimal del número introducido.
El programa principal main se ejecutará hasta que el usuario introduzca la opción adecuada
para salir (0.5 puntos).
 */
public class Lectura {
    public static double num;
    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean system = true;
        while(system == true){
            System.out.println("""
                        Menu
                    1. Introduzca un número por teclado
                    2. Obtener parte entera o decimal?
                    3. Salir 
                """);
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    numero(num);
                    break;
                case 2:
                    fragmentos();
                    break;
                case 3:
                    system=false;
                    break;
            }
        }
    }
    public static double numero(double num){
        sc= new Scanner(System.in);
        System.out.println("Introduzca un número por teclado");
        num = sc.nextDouble();
        return num;
    }
    public static void fragmentos(){

        String nums = String.valueOf(num);
        System.out.println(nums);

    }
}
