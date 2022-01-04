package AeroPorto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cleo
 */
public class Assento {
    protected String fila;
    protected int numero;
    protected boolean ocupado;

    public Assento(String fila, int numero, boolean ocupado) {
        this.fila = fila;
        this.numero = numero;
        this.ocupado = ocupado;
    }
    
    
    public static Assento assento(String fila, int numero, boolean ocupado){
        return new Assento(fila, numero, ocupado);
    }
    
    public String getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }


    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Assento ");
        sb.append(fila);
        sb.append(numero);
        return sb.toString();
    }
    
}
