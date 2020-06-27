/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programta;

/**
 *
 * @author admin
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Output {
    public void outputRute(String route[][], String file)throws IOException{
        FileWriter m = new FileWriter(file);
        Input in =new Input();
        String kendaraan[]=in.kendaraan();
            for(int x=0; x<route.length; x++){
                if(x==0){
                    m.write(kendaraan[x]+" :");
                     m.write("\n");
                }else {
                    
                    m.write(kendaraan[x-1]+" :");
                     m.write("\n");
                }
                for(int y=0; y<route[x].length; y++){
                 m.write(route[x][y]);
                }
                m.write("\n");
            }
             m.close();
    }
    public void outputRuteSkenario2(String route[][], String file)throws IOException{
        FileWriter m = new FileWriter(file);
        Input in =new Input();
        String kendaraan[]=in.kendaraan();
            for(int x=0; x<route.length; x++){
                     m.write(kendaraan[x+1]+" :");
                     m.write("\n");
                
                for(int y=0; y<route[x].length; y++){
                 m.write(route[x][y]);
                }
                m.write("\n");
            }
             m.close();
    }
    public void jarakPerRoute(double jarak[], String file)throws IOException{
               PrintStream fileStream = new PrintStream(new File(file));
                for(int y=0; y<jarak.length; y++){
                    fileStream.println(Double.toString(jarak[y]));
                    
                }
    }
    public void penalti(double ev, String file) throws IOException{
        FileWriter m = new FileWriter(file);
          m.write(Double.toString(ev));
           m.close();
        
    }
}