/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej3;

/**
 *
 * @author P13si
 * 
 */
/**
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
import java.util.Scanner;
public class Numéricos {
    public static int getParteEntera(double numero) {
        return (int) numero;
    }

    public static int getParteDecimal(double numero) {
        double decimal = numero - (int) numero;
        int decimalMod = (int) (decimal * 100);
        return decimalMod;
    }

    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean system = true;
        System.out.println("Introduzca un numero:");
        double numero = sc.nextDouble();
        while (system) {
            System.out.println("""
                            Menu
                        1. Obtener parte entera
                        2. Obtener parte decimal
                        3. Salir 
                    """);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("La parte Entera es : " + getParteEntera(numero));
                    break;
                case 2:
                    System.out.println("La parte Decimal es : " + getParteDecimal(numero));
                    break;
                case 3:
                    system = false;
                    break;
            }
        }
    }
}
