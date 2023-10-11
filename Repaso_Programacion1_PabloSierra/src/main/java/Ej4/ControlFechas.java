/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej4;

/**
 *
 * @author P13si
 * 
 */
/**
 Haz un programa que pida el nombre y la fecha de nacimiento de dos personas. El nombre en
una línea y la fecha en la siguiente. La fecha se escribirá en el formato dd/mm/aaaa, siendo dd
un entero que representa al día, mm un entero que representa al mes (entre 1 y 12) y aaaa el
año.
Finalmente, el programa dirá quién es menor, y qué edad tienen en el momento de la ejecución.
No hay ningún método del API que calcule esto directamente.
Ejemplo
Introduce primer nombre: Paquito
Introduce primera fecha de nacimiento [dd/mm/aaaa]: 12/5/1990
Introduce segundo nombre: Juanita
Introduce segunda fecha de nacimiento [dd/mm/aaaa]: 14/9/1995
Juanita es menor
Paquito tiene XX años y Juanita tiene YY años.

 */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class ControlFechas {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Escriba el nombre de la primera persona: ");
        String Persona1 = sc.nextLine();
        System.out.println("Introduzca la primera fecha de nacimiento(dd/MM/YYYY): ");
        String FN1 = sc.nextLine();
        LocalDate Nacimiento1 = LocalDate.parse(FN1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(Persona1 + " " + Nacimiento1);
        System.out.println("Escriba el nombre de la primera persona: ");
        String Persona2 = sc.nextLine();
        System.out.println("Introduzca la primera fecha de nacimiento(dd/MM/YYYY): ");
        String FN2 = sc.nextLine();
        LocalDate Nacimiento2 = LocalDate.parse(FN2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(Persona2 + " " + Nacimiento2);
        Period P1 = Period.between(Nacimiento1, LocalDate.now());
        Period P2 = Period.between(Nacimiento2, LocalDate.now());
        if (Nacimiento1.isBefore(Nacimiento2)){
            System.out.println(Persona1+ " es menor");
            System.out.println(Persona1+ " tiene " + P1.getYears()+ " años y "+ Persona2 +" tiene " + P2.getYears() + " años"  );
        } else if (Nacimiento2.isBefore(Nacimiento1)) {
            System.out.println(Persona2+ " es menor");
            System.out.println(Persona2+ " tiene " + P2.getYears()+ " años y "+ Persona1 +" tiene " + P1.getYears() + " años"  );
        }
    }
}
