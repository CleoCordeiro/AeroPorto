/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import AeroPorto.Voo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cleo
 */
public class FormUtils {

    //Validação da data
    public static boolean validaData(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data); 
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    //Validação da  hora
    public static boolean validaHora(String hora){
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            sdf.setLenient(false);
            try{
                sdf.parse(hora);
            }catch(ParseException e){
                return false;
            }
            return true;
    }
    
    //Checa se os campos estão vázios
    public static String validarCampos(JFormattedTextField dados, String campo){
        String limpo = dados.getText().replaceAll("[\\Q(|)|-| |.\\E]", "");
        if(limpo.isEmpty()){
            return "O Campo "+ campo +" está vazio!!!\n";
        }
        return "";
    }
    
    //Checa se os campos estão vázios
    public static String validarCampos(JTextField dados, String campo){
        if(dados.getText().isEmpty()){
        return "O Campo "+ campo +" está vazio!!!\n";
        }
        return "";
    }

    //Preeche a tabela
    public static void preencherTabela(JTable table, ArrayList<Voo> voo){
        String[] colunas = new String [] {"CÓD VOO", "DATA", "HORA", "PARTIDA", "DESTINO", "PREÇO"};
    
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setEnabled(false);
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        for (int i = 0; i < voo.size(); i++){
           String codVoo = voo.get(i).getNumVoo();
           String data = voo.get(i).getData();
           String hora = voo.get(i).getHora();
           String partida = voo.get(i).getPartida();
           String destino = voo.get(i).getDestino();
           double preco = voo.get(i).getPreco();

           Object[] dadosVoo = {codVoo, data, hora, partida, destino, preco};
           tableModel.addRow(dadosVoo);
        }
        table.setModel(tableModel);
    }

}