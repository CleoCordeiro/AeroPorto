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
public class Passageiro {
    private String nome, cpf, endereço, telefone;

    public Passageiro(String nome, String cpf, String endereço, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passageiro ").append(nome);
        sb.append("\nCpf ").append(cpf);
        sb.append("\nEndereço ").append(endereço);
        sb.append("\nTelefone ").append(telefone);
        return sb.toString();
    }

    

    
}
