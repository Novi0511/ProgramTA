/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Input {
    public String[] readLines(String filename) throws IOException 
    {
        FileReader fileReader = new FileReader(filename);
         
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
         
        while ((line = bufferedReader.readLine()) != null) 
        {
            lines.add(line);
        }
         
        bufferedReader.close();
         
        return lines.toArray(new String[lines.size()]);
    }   
    public String [] daftarTPSDumptruck() throws IOException{
        String tps[]= readLines("D:\\DataTA\\tps_dumptruck.txt");        
        return tps;
    }
     public String [] daftarTPSArmroll() throws IOException{
        String tps[]= readLines("D:\\DataTA\\tps_armroll.txt");        
        return tps;
    }
     public double [] volume_tps_a() throws IOException{
        String volume_tps[]= readLines("D:\\DataTA\\vol_tps_armroll.txt");
        double [] volumeTPS = new double[volume_tps.length];
        
         for (int i = 0; i < volumeTPS.length; i++) {
             volumeTPS[i]=Double.parseDouble(volume_tps[i]);
         }
        return volumeTPS;
    }
      public double [] volume_tps_d() throws IOException{
        String volume_tps[]= readLines("D:\\DataTA\\vol_tps_dumptruck.txt");
        double [] volumeTPS = new double[volume_tps.length];
        
         for (int i = 0; i < volumeTPS.length; i++) {
             volumeTPS[i]=Double.parseDouble(volume_tps[i]);
         }
        return volumeTPS;
    }
        public double [] jarak_arm() throws IOException{
        String jarak_tps[]= readLines("D:\\DataTA\\distance_armroll.txt");
        double [] jarakTPS = new double[jarak_tps.length];
        
         for (int i = 0; i < jarakTPS.length; i++) {
             jarakTPS[i]=Double.parseDouble(jarak_tps[i]);
         }
        return jarakTPS;
    }
         
         public double[][] jarak_d() throws IOException{
         
        String jarak_tps[]= readLines("D:\\DataTA\\distance_dumptruck.txt");
         double [][]jarak=new double[jarak_tps.length][jarak_tps.length];
         String [][] jaraks= new String [jarak_tps.length][jarak_tps.length];
         for (int i = 0; i < jarak_tps.length; i++) {
             String a[]=jarak_tps[i].split(" ");
             for (int j = 0; j < a.length; j++) {
                 jaraks[i][j]=a[j];
             }
        }
         
          for (int k = 0; k < jarak.length; k++) {
              for (int l = 0; l < jarak[k].length; l++) {
                
                 jarak[k][l]=Double.parseDouble(jaraks[k][l]);
                  
              }
              
          }
        return jarak;
    }
         
         public int[] jumlahKontainerPerTPS() throws IOException{
        double volume []=volume_tps_a();
        int jmhKontainer[]=new int [volume.length];
        for (int i = 0; i < volume.length; i++) {
            double volP=volume[i]/6;
            jmhKontainer[i]=(int) Math.ceil(volP);
        }
        return jmhKontainer;
        
    }
    public int jmhRouteDumptruck() throws IOException{
        double vol[]=volume_tps_d();
        double sum=0;
        for (int i = 0; i < vol.length; i++) {
            sum+=vol[i];
        }
        int x=(int) Math.ceil(sum/8);
        return x;
        
    }
    public int jmhSeluruhKontainer() throws IOException{
             int sum=0;
             int jmh_kontainer_pertps[]=jumlahKontainerPerTPS();
             for (int i = 0; i < jmh_kontainer_pertps.length;i++) {
                 sum+=jmh_kontainer_pertps[i];
                 
             }
             return sum;
         }
     public int vol_tps_d_l() throws IOException{
         int a=volume_tps_d().length;
         return a;
     }
      public String [] kendaraan() throws IOException{
        String kendaraan[]= readLines("D:\\DataTA\\kendaraan.txt");        
        return kendaraan;
    }
                 
}
