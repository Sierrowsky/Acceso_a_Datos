/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.repaso_programacion1.EJ1;

/**
 *
 * @author P13si
 */
/**
 * 
 * Implementa una clase Trabajador con los siguientes atributos y métodos:
 Atributos privados: nombre, edad, categoría, antigüedad.

 Constantes static públicas. Determinan los diferentes tipos de categorías y antigüedad
de un empleado disponibles en el sistema:

o CAT_EMPLEADO. Valor 0

o CAT_ENCARGADO. Valor 1

o CAT_DIRECTIVO. Valor 2

o ANT_NOVATO. Valor 0

o ANT_MADURO. Valor 1

o ANT_EXPERTO. Valor

 Trabajador(String nombre, int edad, int categoria, int antigüedad). Constructor de la
clase que inicializa los atributos de la misma. Comprobará que la categoría y la
antigüedad sean correctos, si no lo son se lanzará la excepción
IllegalArgumentException. (0.75 puntos)

 Métodos públicos consulta/cambia (gets y sets) de cada uno de los atributos. Se debe
comprobar la validez de los atributos y lanzar la excepción correspondiente si hay algún
valor incorrecto. (0.5 puntos)

 public double calcularSueldo(). Devuelve el sueldo del empleado calculado a partir de
su antigüedad y categoría profesional. La forma de calcular el sueldo del empleado será
de acuerdo a la siguiente tabla (0.75 puntos):
 * 
 */
import java.util.Scanner;
public class MainTrabajador {

private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Introduzca un nombre");
        String nombre = sc.next();
        System.out.println("Introduzca edad");
        int edad = sc.nextInt();
        System.out.println("Introduzca categoria");
        int categoria = sc.nextInt();
        System.out.println("Introduzca antigüedad");
        int antigüedad = sc.nextInt();
        Trabajador T1 = new Trabajador(nombre,edad,categoria,antigüedad);
        System.out.println(T1.toString());

    }
}
