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
public class Fleksibel {
    public double alfa(int pilih){
         double a[]={0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1}; 
        double alfa=a[pilih];
        return alfa;
         
    }
    public int iterasiLocalSearch(int pilih){
         int a[]={1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
         
        int jmh=a[pilih];
        return jmh;
         
    }
    public int iterasiProcedure(int pilih){
         int a[]={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
         
        int jmh=a[pilih];
        return jmh;
         
    }
    public String percobaan(int ke){
         String filename[]={"D:\\DataTA\\percobaan1",
             "D:\\DataTA\\percobaan2",
             "D:\\DataTA\\percobaan3", 
             "D:\\DataTA\\percobaan4",
              "D:\\DataTA\\percobaan5"};
         
         String s=filename[ke];
         return s;
    }
    public String tempatPenyimpananRoute(int pilih, int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario1\\subskenarioke-1\\route\\routes.txt",
       percobaan(percobaan)+"\\skenario1\\subskenarioke-2\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-3\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-4\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-5\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-6\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-7\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-8\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-9\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-10\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-11\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-12\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-13\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-14\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-15\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-16\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-17\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-18\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-19\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario1\\subskenarioke-20\\route\\routes.txt"};
        String name=filename[pilih];
        return name;
        
    }
    public String tempatPenyimpananRouteSkenario2(int pilih, int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario2\\subskenarioke-1\\route\\routes.txt",
       percobaan(percobaan)+"\\skenario2\\subskenarioke-2\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-3\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-4\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-5\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-6\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-7\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-8\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-9\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-10\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-11\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-12\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-13\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-14\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-15\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-16\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-17\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-18\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-19\\route\\routes.txt",
        percobaan(percobaan)+"\\skenario2\\subskenarioke-20\\route\\routes.txt"};
        String name=filename[pilih];
        return name;
        
    }
    public String tempatPenyimpananNilaiFitness(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario1\\subskenarioke-1\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-2\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-3\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-4\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-5\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-6\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-7\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-8\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-9\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-10\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-11\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-12\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-13\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-14\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-15\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-16\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-17\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-18\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-19\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-20\\nilai_fitness\\nilaiFitness.txt"};
        String name=filename[pilih];
        return name;
        
    }
    public String tempatPenyimpananNilaiFitnessSkenario2(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario2\\subskenarioke-1\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-2\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-3\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-4\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-5\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-6\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-7\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-8\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-9\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-10\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-11\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-12\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-13\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-14\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-15\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-16\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-17\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-18\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-19\\nilai_fitness\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-20\\nilai_fitness\\nilaiFitness.txt"};
        String name=filename[pilih];
        return name;
        
    }
     public String tempatPenyimpananNilaiFitnessPerIterasi(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario1\\subskenarioke-1\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-2\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-3\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-4\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-5\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-6\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-7\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-8\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-9\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-10\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-11\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-12\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-13\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-14\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-15\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-16\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-17\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-18\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-19\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-20\\nilai_fitness_periterasi\\nilaiFitness.txt"};
        String name=filename[pilih];
        return name;
        
    }
    public String tempatPenyimpananNilaiFitnessPerIterasiSkenario2(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario2\\subskenarioke-1\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-2\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-3\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-4\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-5\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-6\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-7\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-8\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-9\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-10\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-11\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-12\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-13\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-14\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-15\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-16\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-17\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-18\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-19\\nilai_fitness_periterasi\\nilaiFitness.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-20\\nilai_fitness_periterasi\\nilaiFitness.txt"};
        String name=filename[pilih];
        return name;
        
    }
    
    
     public String tempatPenyimpananJarak(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario1\\subskenarioke-1\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-2\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-3\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-4\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-5\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-6\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-7\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-8\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-9\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-10\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-11\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-12\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-13\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-14\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-15\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-16\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-17\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-18\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-19\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario1\\subskenarioke-20\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt"};
        String name=filename[pilih];
        return name;
        
    }
    public String tempatPenyimpananJarakSkenario2(int pilih,int percobaan){
        String filename[]={percobaan(percobaan)+"\\skenario1\\subskenarioke-1\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-2\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-3\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-4\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-5\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-6\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-7\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-8\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-9\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-10\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-11\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-12\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-13\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-14\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-15\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-16\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-17\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-18\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-19\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt",
            percobaan(percobaan)+"\\skenario2\\subskenarioke-20\\jarak_tempuh_perkendaraan\\jarak_tempuh_perkendaraan.txt"};
        String name=filename[pilih];
        return name;
        
    }
}
