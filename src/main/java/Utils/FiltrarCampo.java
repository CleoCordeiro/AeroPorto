/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Toolkit;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Cleo
 */

//Método para a filtragem de campos imput aonde só aceita o ragex informado
public class FiltrarCampo extends PlainDocument{
    String tipo, regex;
    public FiltrarCampo(String tipo){
        this.tipo = tipo;
        if("Int".equals(tipo)){
            this.regex = "[^0-9|^.]";
        }
        else if("Str".equals(tipo)){
            this.regex = "[^A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ|^ ]";
        }
    }
    
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{

        if(str.matches(regex)) {
                Toolkit.getDefaultToolkit().beep();
            }
            super.insertString(offset, str.replaceAll(regex, ""), attr);
        }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        if(str.matches(regex)) {
                Toolkit.getDefaultToolkit().beep();
            }
            super.insertString(offset, str.replaceAll(regex, ""), attr);
    }
}
