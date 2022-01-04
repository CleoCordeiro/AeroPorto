/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import AeroPorto.Passagem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cleo
 */
public class Output {
    public static void imprimir(Passagem passagem){
        String path = System.getProperty("user.dir");
        
        File Dir = new File(path+"/Passagens");
        if (!Dir.exists()){
            Dir.mkdirs();
        }
        
        File arq = new java.io.File(Dir, passagem.getPassageiro().getNome()+".txt"); //colocar o num do asssento
        try {
            arq.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {  
            FileWriter fileWriter = new FileWriter(arq, false);
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter printWriter = new PrintWriter(arq)) {
            printWriter.println(passagem);          
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
