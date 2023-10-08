package E1;

import java.util.Scanner;

public class Trabajador {
    public static Scanner sc;
    private String nombre;
    private int edad;
    private int categoria;
    private int antigüedad;

    public static final int CAT_EMPLEADO = 0;
    public static final int CAT_ENCARGADO = 1;
    public static final int CAT_DIRECTIVO = 2;
    public static final int ANT_NOVATO = 0;
    public static final int ANT_MADURO = 1;
    public static final int ANT_EXPERTO = 2;
    public Trabajador(String nombre, int edad, int categoria, int antigüedad) {
        if (categoria < CAT_EMPLEADO || categoria > CAT_DIRECTIVO) {
            throw new IllegalArgumentException("Introduzca una categoria adecuada");
        }
        if ( antigüedad < ANT_NOVATO || antigüedad > ANT_EXPERTO){
            throw new IllegalArgumentException("Introduzca una antiguedad adecuada");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
        this.antigüedad = antigüedad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        if (categoria < CAT_EMPLEADO || categoria > CAT_DIRECTIVO) {
            throw new IllegalArgumentException("Introduzca una categoria adecuada");
        }
        this.categoria = categoria;
    }

    public int getAntigüedad() {
        return antigüedad;
    }

    public void setAntigüedad(int antigüedad) {
        if (antigüedad < ANT_NOVATO || antigüedad > ANT_EXPERTO){
            throw new IllegalArgumentException("Introduzca una antiguedad adecuada");
        }
        this.antigüedad = antigüedad;
    }
    public void cambio(){
        sc = new Scanner(System.in);
        if(sc.next()=="cambio" && sc.next()==getNombre()){
            System.out.println("Introduzca el parametro a cambiar. nombre , edad, categoria o antigüedad.");
            String param=sc.next();
            switch (param){
                case "nombre":
                    System.out.println("introduzca el nombre cambiado");
                    String CNombre= sc.next();
                    setNombre(CNombre);
            }

        }

    }
    public void consulta(){
        sc = new Scanner(System.in);
        if(getNombre()==sc.next()) {
            System.out.println(nombre + " " + edad + " " + categoria + " " + antigüedad);
            }else throw new IllegalArgumentException();
    }
    public double calcularSueldo(){
        double sueldobase= 607;
        double novato= 150;
        double maduro=300;
        double experto=600;
        double sueldototal=0;
        switch (getCategoria()) {
            case 1:
                System.out.println("Empleado");
                if (getAntigüedad()==0){
                    sueldototal=(sueldobase*1.15)+novato;
                }else if (getAntigüedad()==1) {
                    sueldototal=(sueldobase*1.15)+maduro;
                }else if (getAntigüedad()==2){
                    sueldototal=(sueldobase*1.15)+experto;
                }
                break;
            case 2:
                System.out.println("Encargado");
                if (getAntigüedad()==0){
                    sueldototal=(sueldobase*1.35)+novato;
                }else if (getAntigüedad()==1) {
                    sueldototal=(sueldobase*1.35)+maduro;
                }else if (getAntigüedad()==2) {
                    sueldototal = (sueldobase * 1.35) + experto;
                }
                break;
            case 3:
                System.out.println("Directivo");
                if (getAntigüedad()==0){
                    sueldototal=(sueldobase*1.60)+novato;
                }else if (getAntigüedad()==1) {
                    sueldototal=(sueldobase*1.60)+maduro;
                }else if (getAntigüedad()==2) {
                    sueldototal = (sueldobase * 1.60) + experto;
                }
                break;
        }
        return sueldototal;
    }

    @Override
    public String toString() {
        return "Trabajador : " +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", categoria=" + categoria +
                ", antigüedad=" + antigüedad +", Sueldo :" + calcularSueldo();
    }
}
