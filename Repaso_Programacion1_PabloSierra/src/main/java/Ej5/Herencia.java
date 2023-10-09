/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej5;
import java.util.Scanner;
/**
 *
 * @author P13si
 * 
 */
/**
Diseñar la clase Hora, que representa un instante de tiempo compuesto por la hora (de 0 a 23) y
los minutos. Dispone de los métodos:
 Hora (hora, minuto), que construye un objeto con los datos pasados como
parámetros.
 void inc(), que incrementa la hora en un minuto.
 boolean setMinutos (valor), que asigna un valor, si es válido, a los minutos.
Devuelve true o false según haya sido posible modificar los minutos o no.
 boolean setHora (valor), que asigna un valor, si está comprendido entre 0 y 23, a la
hora. Devuelve true o false según haya sido posible cambiar la hora o no.
 String toString(), que devuelve un String con la representación de la hora.
 */
public class Herencia {
     private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduzca una hora y posteriormente unos minutos : ");
        Hora hora = new Hora(sc.nextInt(),sc.nextInt());
        hora.incremento();
        System.out.println(hora);
        hora.setHora(13);
        System.out.println(hora);
        hora.setMinutos(34);
        System.out.println(hora);
    }
}
