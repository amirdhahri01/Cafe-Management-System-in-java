package common;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class OpenPDF {
    
    public static void openPdfbyID(String billID){
        try{
            if((new File("D:\\" + billID + ".pdf").exists())){
                Process p = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler C:\\"+ billID + ".pdf");
            }else{
                JOptionPane.showMessageDialog(null, "File doesn't exists");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage() , "Message" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
