/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeroPorto;

import java.text.DecimalFormat;

/**
 *
 * @author suletonio
 */
public class Passagem {
    protected Voo voo;
    protected Passageiro passageiro;
    protected Assento assento;
    protected double preco;
    protected String pagamento;
    
    DecimalFormat df = new DecimalFormat("###,##0.00"); 

    public Passagem(Voo voo, Passageiro passageiro, Assento assento, double preco, String pagamento) {
        this.voo = voo;
        this.passageiro = passageiro;
        this.assento = assento;
        this.preco = preco;
        this.pagamento = pagamento;
    }
    




    public Voo getVoo() {
        return voo;
    }


    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(passageiro);
        sb.append(voo);
        sb.append(assento);
        sb.append("\nPreço ").append(df.format(preco));
        sb.append("\nForma de Pagemento ").append(pagamento);
        return sb.toString();
    }
    
    
}
