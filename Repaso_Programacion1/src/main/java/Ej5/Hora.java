/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej5;

/**
 *
 * @author P13si
 */
public class Hora {
        private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        if (hora >= 0 && hora<= 23);{
            this.hora=hora;
        }
        if (minuto>=0 && minuto <=59){
            this.minuto = minuto;
        }
    }
    public void incremento(){
        this.minuto++;
        if (this.minuto>59){
            this.minuto=0;
            this.hora++;
            if (this.hora>23){
                this.hora=0;

            }
        }
    }
    public boolean setMinutos(int valor){
        if (valor >=0 && valor <= 59){
            minuto= valor;
            return true;
        }else
            return false;
    }
    public boolean setHora(int valor){
        if (valor >=0 && valor <=23){
            hora=valor;
            return true;
        }else
            return false;
    }

    @Override
    public String toString() {
        return  hora + ":" + minuto;
    }
}
