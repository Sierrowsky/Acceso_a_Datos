package E2;

import java.util.Scanner;

/*
Implemente una función que sirva para cifrar un texto con el conocido método de César. El
criptosistema consiste en el desplazamiento de 3 caracteres en la posición del carácter a cifrar,
es decir, la A se sustituye por la D, la B por la E, ..., la X por la A, la Y por la B y la Z por la C.
Por simplicidad, supondremos que el texto a cifrar solo contiene caracteres alfabéticos. Por
tanto el ejercicio consiste en implementar la siguiente función:
    public String cifradoCesar (String cadenaACifrar)
La función recibe como parámetro la cadena a cifrar y devuelve un objeto String con la cadena
cifrada mediante el sistema de Cesar.

 */
public class Cifrado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una palabra");
        String palabra = sc.next();
        System.out.println(Encriptacion(palabra));
    }

    public static String  Encriptacion(String palabra) {
        StringBuilder encriptado = new StringBuilder();
        int desp = 3;
        for(int x = 0; x < palabra.length(); x++){
            char letra =palabra.charAt(x);
            if (letra >='A' && letra <='Z'){
                encriptado.append((char) ((letra - 'a' + desp) % 26 + 'A'));
            }else if (letra>='a' && letra <= 'z'){
                encriptado.append((char) ((letra - 'a' + desp) % 26 + 'a'));
            }else encriptado.append(letra);
        }
                return encriptado.toString();
    }
}
