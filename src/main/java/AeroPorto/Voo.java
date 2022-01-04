/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeroPorto;


/**
 *
 * @author suletonio
 */
public class Voo {
    protected String numVoo , data, hora, partida, destino;
    protected double preco;
    protected Assento[] assento = new Assento[100]; 

    public Voo(String numVoo, String data, String hora, String partida, String destino, double preco) {        
        this.numVoo = numVoo;
        this.data = data;
        this.hora = hora;
        this.partida = partida;
        this.destino = destino;
        this.preco = preco;
        gerarAssentos();
    }
        
    public final void gerarAssentos(){
        int num = 0;
        for (int fila = 0; fila < 4; fila++){
            for(int cadeira = 0; cadeira < 25; cadeira++){
                switch (fila) {
                    case 0 -> {
                        assento[num] = Assento.assento("A", cadeira, false);
                        num++;
                    }
                    case 1 -> {
                        assento[num] = Assento.assento("B", cadeira, false);
                        num++;
                    }
                    case 3 -> {
                        assento[num] = Assento.assento("C", cadeira, false);
                        num++;
                    }
                    default -> {
                            assento[num] = Assento.assento("D", cadeira, false);
                            num++;
                    }

                }
            }
        }
    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(String numVoo) {
        this.numVoo = numVoo;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setAssento(Assento[] assento) {
        this.assento = assento;
    }

    public Assento[] getAssento() {
        return assento;
    }

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNumero do voo ").append(numVoo);
        sb.append("\nData ").append(data);
        sb.append("\nHora ").append(hora);
        sb.append("\nPartida ").append(partida);
        sb.append("\nDestino ").append(destino);
        sb.append("\n");
        return sb.toString();
    }  

}
