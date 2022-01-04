/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Cleo
 */
public class GerenteDeJanelas {
    private static JDesktopPane jDesktopPane;
    
    public GerenteDeJanelas(JDesktopPane jDesktopPane){
        GerenteDeJanelas.jDesktopPane = jDesktopPane;
    }
    
    //Método para abrir JInternalFrame faz a verificação
    //antes se existe uma janela já aberta
    public void abrirJanela(JInternalFrame jInternalFrame){
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            setPosicao(jDesktopPane ,jInternalFrame);
        }
    }
      
    //Metodo para centralizar o JInternalFrame
      public void setPosicao(JDesktopPane jDesktopPane,JInternalFrame jInternalFrame) {
        Dimension d = jDesktopPane.getSize();
        jInternalFrame.setLocation((d.width - jInternalFrame.getSize().width) / 2, (d.height - jInternalFrame.getSize().height) / 2);
    }

}
