/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author admin
 */
public class MetodeGrasp {
    public int [][]procedureGrasp(double alfa,int iterasi_local, int iterasi_procedure, String file) throws IOException{
         int seed[][]=  faseKontruksi(alfa);
        FileWriter m = new FileWriter(file);
        int solusi[][]=new int[seed.length][seed[0].length];
        ObjectiveFunction of =new ObjectiveFunction();
        double ev=1000;
        for (int i = 0; i < iterasi_procedure; i++) {
         seed=  faseKontruksi(alfa);
         int[][]solusi1 = localSearch(seed, iterasi_local);
          double ev1=of.deviasi(jarak_perroute(solusi1));
          if(ev1<ev){
              for (int j = 0; j < solusi.length; j++) {
                  for (int k = 0; k < solusi[j].length; k++) {
                       solusi[j][k]=solusi1[j][k];
                  }
              }
             
              ev=ev1;
          }else{
              for (int j = 0; j < solusi1.length; j++) {
                  for (int k = 0; k < solusi1[j].length; k++) {
                       solusi1[j][k]=solusi[j][k];
                  }
              }
              ev1=ev;
          }
         //   System.out.println(i+ " :"+ ev); 
         m.write(Double.toString(ev));
            m.write("\n");
         
        }m.close();
        return solusi;
    }
        public int [][]procedureGraspSkenario2(double alfa,int iterasi_local, int iterasi_procedure, String file) throws IOException{
         int seed[][]=  faseKontruksiSkenario2(alfa);
        int solusi[][]=new int[seed.length][seed[0].length];
        FileWriter m = new FileWriter(file);
        ObjectiveFunction of =new ObjectiveFunction();
        double ev=1000;
        for (int i = 0; i < iterasi_procedure; i++) {
         seed=  faseKontruksiSkenario2(alfa);
         int[][]solusi1 = localSearchSkenario2(seed, iterasi_local);
          double ev1=of.deviasi(jarakperrouteSkenario2(solusi1));
          if(ev1<ev){
              for (int j = 0; j < solusi.length; j++) {
                  for (int k = 0; k < solusi[j].length; k++) {
                       solusi[j][k]=solusi1[j][k];
                  }
              }
             
              ev=ev1;
          }else{
              for (int j = 0; j < solusi1.length; j++) {
                  for (int k = 0; k < solusi1[j].length; k++) {
                       solusi1[j][k]=solusi[j][k];
                  }
              }
              ev1=ev;
          }
         //   System.out.println(i+ " :"+ ev); 
         m.write(Double.toString(ev));
         m.write("\n");
        }m.close();
        return solusi;
    }
    public int [][] localSearch(int [][]seed, int iterasi) throws IOException{
        int [][]solusi=new int[seed.length][seed[0].length];
          int [][]solusi_abs=new int[seed.length][seed[0].length];
          for (int i = 0; i < solusi.length; i++) {
              for (int j = 0; j < solusi[0].length; j++) {
                  solusi[i][j]=seed[i][j];
                  solusi_abs[i][j]=seed[i][j];
              }
        }
             ObjectiveFunction of=new ObjectiveFunction();
         
        Random r =new Random();
        Input in=new Input();
       int jmh_route_d=in.jmhRouteDumptruck();
        int temp=0;
        double ev =of.deviasi(jarak_perroute(solusi));
        double ev_abs=of.deviasi(jarak_perroute(solusi_abs));
        int v=0;
        for (int i = 0; i <iterasi; i++) {
            if(v==4)
                v=0;
              //amroll
              int rand_a_r1=jmh_route_d+r.nextInt(solusi_abs.length-jmh_route_d);
              int rand_a_r2=jmh_route_d+r.nextInt(solusi_abs.length-jmh_route_d);
              int rand_a_c1=r.nextInt(hitungIndex(solusi_abs[rand_a_r1]));
              int rand_a_c2=r.nextInt(hitungIndex(solusi_abs[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(hitungIndex(solusi_abs[rand_d_r1]));
              int rand_d_c11 = r.nextInt(hitungIndex(solusi_abs[rand_d_r1]));
              int rand_d_c2 = r.nextInt(hitungIndex(solusi_abs[rand_d_r2]));
              solusi_abs=pilihVariabelNeighbourhood(v, solusi_abs, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c11, rand_d_c2);  
              ev_abs=of.deviasi(jarak_perroute(solusi_abs));
              if(ev_abs<ev){
                    ev=ev_abs;
                    for (int k= 0; k < solusi.length; k++) {
                        for (int j = 0; j < solusi[0].length; j++) {
                            solusi[k][j]=solusi_abs[k][j];
                                  
                        }
                    }
                            
               }else{
                    ev_abs=ev;
                    for (int k= 0; k < solusi.length; k++) {
                        for (int j = 0; j < solusi[0].length; j++) {
                            solusi_abs[k][j]=solusi[k][j];
                                  
                        }
                    }
                    v++;
                }
                        
        
          // System.out.println(i+ " :"+ ev); 
        }
        
        return solusi; 
        
        
    }
    public int [][] localSearchSkenario2(int [][]seed, int iterasi) throws IOException{
        int [][]solusi=new int[seed.length][seed[0].length];
          int [][]solusi_abs=new int[seed.length][seed[0].length];
          for (int i = 0; i < solusi.length; i++) {
              for (int j = 0; j < solusi[0].length; j++) {
                  solusi[i][j]=seed[i][j];
                  solusi_abs[i][j]=seed[i][j];
              }
        }
             ObjectiveFunction of=new ObjectiveFunction();
         
        Random r =new Random();
        Input in=new Input();
       int jmh_route_d=in.jmhRouteDumptruck();
        double ev =of.deviasi(jarakperrouteSkenario2(solusi));
        double ev_abs=of.deviasi(jarakperrouteSkenario2(solusi_abs));
        int v=0;
        for (int i = 0; i <iterasi; i++) {
            if(v==2)
                v=0;
              //amroll
              int rand_a_r1=r.nextInt(solusi_abs.length);
              int rand_a_r2=r.nextInt(solusi_abs.length);
              int rand_a_c1=r.nextInt(hitungIndex(solusi_abs[rand_a_r1]));
              int rand_a_c2=r.nextInt(hitungIndex(solusi_abs[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(hitungIndex(solusi_abs[rand_d_r1]));
              int rand_d_c11 = r.nextInt(hitungIndex(solusi_abs[rand_d_r1]));
              int rand_d_c2 = r.nextInt(hitungIndex(solusi_abs[rand_d_r2]));
              solusi_abs=pilihVariabelNeighbourhood(v, solusi_abs, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c11, rand_d_c2);  
              ev_abs=of.deviasi(jarakperrouteSkenario2(solusi_abs));
              if(ev_abs<ev){
                    ev=ev_abs;
                    for (int k= 0; k < solusi.length; k++) {
                        for (int j = 0; j < solusi[0].length; j++) {
                            solusi[k][j]=solusi_abs[k][j];
                                  
                        }
                    }
                            
               }else{
                    ev_abs=ev;
                    for (int k= 0; k < solusi.length; k++) {
                        for (int j = 0; j < solusi[0].length; j++) {
                            solusi_abs[k][j]=solusi[k][j];
                                  
                        }
                    }
                    v++;
                }
                        
        
         // System.out.println(i+ " :"+ ev); 
        }
        
        return solusi; 
        
        
    }
    public int[][] pilihVariabelNeighbourhood(int v, int [][]solusi_abs, int rand_a_r1,int rand_a_r2,int rand_a_c1,int rand_a_c2, int rand_d_r1, int rand_d_r2, int rand_d_c1,  int rand_d_c11, int rand_d_c2){
       int temp=0;
        switch (v){
            case 0://amroll move antar route
                  temp=  solusi_abs[rand_a_r1][rand_a_c1];
                for (int j = rand_a_c1; j < solusi_abs[rand_a_r1].length-1; j++) {
                            solusi_abs[rand_a_r1][j]=solusi_abs[rand_a_r1][j+1];
                        }
                for (int j = 0; j < solusi_abs[rand_a_r2].length; j++) {
                    if(solusi_abs[rand_a_r2][j]==-1){
                        solusi_abs[rand_a_r2][j]=temp;
                        break;
                    }
                }
                break;
            case 1://amroll swap antar route
                temp=solusi_abs[rand_a_r1][rand_a_c1];
                solusi_abs[rand_a_r1][rand_a_c1]=solusi_abs[rand_a_r2][rand_a_c2];
                solusi_abs[rand_a_r2][rand_a_c2]=temp;              
                break;
            case 2://dumptruk swap dalam 1 route
                temp=solusi_abs[rand_d_r1][rand_d_c1];
                solusi_abs[rand_d_r1][rand_d_c1]=solusi_abs[rand_d_r1][rand_d_c11];
                solusi_abs[rand_d_r1][rand_d_c11]=temp; 	
                break;
            case 3://dumptruk swap antar route
                temp=solusi_abs[rand_d_r1][rand_d_c1];
                solusi_abs[rand_d_r1][rand_d_c1]=solusi_abs[rand_d_r2][rand_d_c2];
                solusi_abs[rand_d_r2][rand_d_c2]=temp;
                 
                break;
            
        }
        return solusi_abs;
    }
    
    public boolean isFeasible(int solusi[][]) throws IOException{
        Input in =new Input();
        double vol_d=8.0;
        double vol_r_d[]=in.volume_tps_d();
        boolean  cek_dump=true;
        int jmhroute_d=in.jmhRouteDumptruck();
        double vol_peroute_d[]=new double[in.jmhRouteDumptruck()];
        int jmh_tps_kontainer=in.vol_tps_d_l()+in.jmhSeluruhKontainer();
        boolean cek=false;
        int sum=0;
        for (int i=0; i<solusi.length; i++) {
            for (int j = 0; j < solusi[0].length; j++) {
                if (solusi[i][j] > -1) {
                    sum ++;
                    if(i<jmhroute_d){
                        vol_peroute_d[i]+=vol_r_d[solusi[i][j]];
                        
                    }
                    
                }
            }
        }
        for (int i = 0; i < jmhroute_d; i++) {
            if(i<jmhroute_d && vol_peroute_d[i]>vol_d){
                cek_dump=false;
                break;
            }
        }
        if(sum==jmh_tps_kontainer && cek_dump) {
        
            cek=true;
        }
        return cek;
    }
    public boolean isFeasibleSkenario2(int solusi[][]) throws IOException{
        Input in =new Input(); 
        int jmh_tps_kontainer=in.jmhSeluruhKontainer();
        boolean cek=false;
        int sum=0;
        for (int i=0; i<solusi.length; i++) {
            for (int j = 0; j < solusi[0].length; j++) {
                if (solusi[i][j] > -1) {
                    sum ++;
   
                }
            }
        }
        if(sum==jmh_tps_kontainer) {
        
            cek=true;
        }
        return cek;
    }
    
    
    
     public int [][] faseKontruksi ( double alfa ) throws IOException{
       int jmh_rcl=6; 
        Input in =new Input();
        int route_d=in.jmhRouteDumptruck();
        int route_a=11;
        int seed[][]=new int[route_a+route_d][30];
         for (int i = 0; i < seed.length; i++) {
             for (int j = 0; j < seed[i].length; j++) {
                 seed[i][j]=-1;
             }
         }
        //propertise dumptruck
        double []volTPSDumpTruck=in.volume_tps_d();
        double[][] jarak_d=in.jarak_d();
        //propertise amroll
        int [] jmhKontainer=in.jumlahKontainerPerTPS();
        double[]jarak_a=in.jarak_arm();
         //build rc
          double []jarakperroute=new double[seed.length];  
          double[] volperroute=new double[route_d];
             
          int index[]=new int [volTPSDumpTruck.length+jmhKontainer.length];
          for (int i = 0; i < index.length; i++) {
             if(i<volTPSDumpTruck.length){
                 index[i]=i;
             }else{
                 index[i]=i-volTPSDumpTruck.length;
             }
         }              
        int iterasi=0;
        int index_cmin_d=0;
        int cekpoin=0;
        int n=0; 
        double evaluasi[]=new double[index.length];
         while(!isEmpityContainer(jmhKontainer) || !isEmpityTPS(volTPSDumpTruck)){
              int routeTerpendek=indexMin1(jarakperroute);
            int panjang_rcl=0;
            int sisaKontainer=hitungkontainerberisi(jmhKontainer);
              int sisaTps_d =hitungtpsberisi(volTPSDumpTruck);
            if(sisaKontainer<jmh_rcl)
                panjang_rcl=sisaKontainer;
            else
                panjang_rcl=jmh_rcl;
            Random r =new Random();
            int rand=0;
            int []rcl =new int[panjang_rcl];
            int index_rand[]=new int[rcl.length];
            double cmin=1000.0;
            double cmax=0.0;
            int indexcmin=0;
            int rcl_a, rcl_d;
            if(sisaTps_d<3){
                rcl_a=panjang_rcl-sisaTps_d;
                rcl_d=sisaTps_d;
            }else{
                rcl_a=panjang_rcl/2;
                rcl_d=panjang_rcl/2;
            }
            int r_d=0;
            n++;
            if(n%2==0){
                r_d=0;
            }else{
                 r_d=1;
            }
            
             evaluasi= evaluasiKandidat(index, jarakperroute, routeTerpendek, r_d, cekpoin);
              for(int m=0; m<index.length; m++){
                    //mencari cmin
                        if(index[m] >0){
                            if(evaluasi[m]<cmin){
                                cmin=evaluasi[m];
                                indexcmin=m;
                            }
                             if(evaluasi[m]>cmax){
                                 cmax=evaluasi[m];
                            }
                        }
                }
                double syarat= cmin + (alfa*cmax);
                iterasi++;
                
            for (int i = 0; i < rcl.length; i++) {
              
                if(i<rcl_d){
                    rand=r.nextInt(sisaTps_d);
          
                      iterasi++;
                    if(evaluasi[rand]<syarat||iterasi==100){
                        if(iterasi==100){
                            if(indexcmin<6)
                            rand=indexcmin;
                             iterasi=0;  
                        }            
                        if(volTPSDumpTruck[index[rand]]>0){
                            rcl[i]=index[rand];
                            index_rand[i]=rand;

                        }
                    }else{
                        i--;   
                    }
                }else{
                    
                    rand=in.vol_tps_d_l()+r.nextInt(hitungIndex(index)-sisaTps_d);
                    iterasi++;
               if(evaluasi[rand]<syarat||iterasi==100){
                   if(iterasi==100){
                       if (indexcmin>=6) {
                           rand=indexcmin; 
                       }         
                        iterasi=0;
                   }
                       
                        
                    if(jmhKontainer[index[rand]]>0){
                        rcl[i]=index[rand];
                        index_rand[i]=rand;
                        
                    }
                }else
                        i--; 

                    }
               
                   
            }
             //amroll
             double kapasitasDumptruk=8.0;
         double[]   volTPSD=in.volume_tps_d();
            double [] volperroute_d =new double[route_d];
             if(rcl_d>0){
                int rand_rcl_d =r.nextInt(rcl_d);
                int rcl_terpilih_d=rcl[rand_rcl_d];
                int index_rand_terpilih=index_rand[rand_rcl_d];
                cekpoin=rcl_terpilih_d+1;
                 
                volTPSDumpTruck[rcl_terpilih_d]=0;
                if(volTPSDumpTruck[rcl_terpilih_d]<=0){
                   for (int j = index_rand_terpilih; j <volTPSDumpTruck.length; j++) {
                       if(j<volTPSDumpTruck.length-1)
                           index[j]=index[j+1];
                   }
                   index[volTPSDumpTruck.length-1]=-1;
                } 
                  if (volTPSD[rcl_terpilih_d]+volperroute_d[r_d]<kapasitasDumptruk) {
                       volperroute_d[r_d]+=volTPSD[rcl_terpilih_d];
                       jarakperroute[r_d]+=jarak_d[cekpoin][rcl_terpilih_d+1];
                      for (int i = 0; i < seed[r_d].length; i++) {
                        if(seed[r_d][i]==-1){
                         seed[r_d][i]=rcl_terpilih_d;
                         break;
                       }
                        }
                      
                
                    }
              
             }   
                  
            
             //amroll
             int rand_rcl_a =rcl_d+r.nextInt(rcl_a);
             int rcl_terpilih_a=rcl[rand_rcl_a];
             int index_rand_terpilih=index_rand[rand_rcl_a];
             jmhKontainer[rcl_terpilih_a]--;
       
             if(jmhKontainer[rcl_terpilih_a]<=0){
                for (int j = index_rand_terpilih; j <index.length; j++) {
                    if(j<index.length-1)
                        index[j]=index[j+1];      
                }
                index[index.length-1]=-1;
            }
            
               
                jarakperroute[routeTerpendek]+=2*jarak_a[rcl_terpilih_a];
                 for (int i = 0; i < seed[routeTerpendek].length; i++) {
                     if(seed[routeTerpendek][i]==-1){
                         seed[routeTerpendek][i]=rcl_terpilih_a;
                         break;
                     }
                }
                   
         }//tutup while
      
  return seed;
            
    }       
     
     public double[] evaluasiKandidat(int index[],double jarakPerroute[], int route_a,int route_d, int cekpoint) throws IOException{
         Input in =new Input();
         ObjectiveFunction of=new ObjectiveFunction();
         double jarak_a[]=in.jarak_arm();
         double jarak_d[][]=in.jarak_d();
         int indeks[]=new int [index.length];
        System.arraycopy(index, 0, indeks, 0, indeks.length);
         double evaluasi[] = new double[indeks.length];
   
         double j_p_route_plus[]=new double[jarakPerroute.length];
        System.arraycopy(jarakPerroute, 0, j_p_route_plus, 0, j_p_route_plus.length);
         for (int i = 0; i < evaluasi.length; i++) {
             if(indeks[i]>-1){
                 if(i<in.vol_tps_d_l()){
                     j_p_route_plus[route_d]+=jarak_d[cekpoint][i];
                 }else{            
                 j_p_route_plus[route_a]+=2*jarak_a[indeks[i]];
                 }
                 evaluasi[i]=of.deviasi(j_p_r_fix(j_p_route_plus));
                 if(i<in.vol_tps_d_l()){
                   j_p_route_plus[route_d]+=jarak_d[cekpoint][i];   
                 }else{            
                   j_p_route_plus[route_a]-=2*jarak_a[indeks[i]];
                   
                 }
                
                
             }else{
                 
                 evaluasi[i]=-1;
             }
             
         }
         return evaluasi;
     }
     public double [] j_p_r_fix(double j_p_route_plus[]){
         double jarak[]=new double[j_p_route_plus.length-1];
         for (int i = 0; i < jarak.length; i++) {
             if(i==0){
                 jarak[i]+=j_p_route_plus[i];
                 jarak[i]+=j_p_route_plus[i+1];
             }else{
                 jarak[i]=j_p_route_plus[i+1];
             }
         }
         return jarak;
     }
        //tutup build rcl
     public double[] evaluasiKandidatSkenario2(int indeks[],double jarakPerroute[], int routeTerpendek) throws IOException{
         Input in =new Input();
         ObjectiveFunction of=new ObjectiveFunction();
         double jarak_a[]=in.jarak_arm();
         double evaluasi[] = new double[indeks.length];
         double j_p_route_plus[]=new double[jarakPerroute.length];
        System.arraycopy(jarakPerroute, 0, j_p_route_plus, 0, j_p_route_plus.length);
         for (int i = 0; i < evaluasi.length; i++) {
             if(indeks[i]>-1){
                 j_p_route_plus[routeTerpendek]+=2*jarak_a[indeks[i]];
                 evaluasi[i]=of.deviasi(j_p_route_plus);
                   j_p_route_plus[routeTerpendek]-=2*jarak_a[indeks[i]];
             }else{
                 
                 evaluasi[i]=-1;
             }
             
         }
         return evaluasi;
     }
     public int [][] faseKontruksiSkenario2 ( double alfa ) throws IOException{
       int jmh_rcl=5; 
        Input in =new Input();
       
        //propertise amroll
        int [] jmhKontainer=in.jumlahKontainerPerTPS();
        double[]jarak_a=in.jarak_arm();
         //build rcl
          int seed[][]=new int[11][30];
          double []jarakperroute_a=new double[seed.length];
         
          for (int i = 0; i < seed.length; i++) {
              for (int j = 0; j < seed[i].length; j++) {
                  seed[i][j]=-1;
              }
         }
       
          int index_a[]=new int [jmhKontainer.length];
          for (int i = 0; i < index_a.length; i++) {
            index_a[i]=i;   
            }
          int iterasi=0;
        int index_cmin_a=0;
         while(!isEmpityContainer(jmhKontainer)){
            int panjang_rcl_a=0;
            int sisaKontainer=hitungkontainerberisi(jmhKontainer);
            if(sisaKontainer<jmh_rcl)
                panjang_rcl_a=sisaKontainer;
            else
                panjang_rcl_a=jmh_rcl;
            Random r =new Random();
            int rand=0;
            int []rcl_a =new int[panjang_rcl_a];
            int index_rand[]=new int[rcl_a.length];
            double cmin_a=1000.0;
            double cmax_a=0.0;
             int routeTerpendek=indexMin(jarakperroute_a);
            double evaluasiKandidat[]=evaluasiKandidatSkenario2(index_a, jarakperroute_a, routeTerpendek);
             for(int m=0; m<index_a.length; m++){
                    if(index_a[m] >0){
                        if(evaluasiKandidat[m]<cmin_a)
                            cmin_a=jarak_a[m];
                         if(evaluasiKandidat[m]>cmax_a)
                             cmax_a=jarak_a[m];
                    }
                }
                double syarat_a= cmin_a + (alfa*cmax_a);
            for (int i = 0; i < rcl_a.length; i++) {
                iterasi++;
                rand=r.nextInt(hitungIndex(index_a));
                if(evaluasiKandidat[rand]<syarat_a||iterasi==100){
                    iterasi=0;
                    rcl_a[i]=index_a[rand];
                    index_rand[i]=rand;
            }else
                    i--;    
            }
             int rand_rcl =r.nextInt(rcl_a.length);
             int rcl_terpilih=rcl_a[rand_rcl];
             int index_rand_terpilih=index_rand[rand_rcl];
             jmhKontainer[rcl_terpilih]--;
                    if(jmhKontainer[rcl_terpilih]<=0){
                        for (int j = index_rand_terpilih; j <index_a.length; j++) {
                            if(j<index_a.length-1)
                            index_a[j]=index_a[j+1];      
                        }
                        index_a[jmhKontainer.length-1]=-1;
                    }
                jarakperroute_a[routeTerpendek]+=2*jarak_a[rcl_terpilih];
                  for (int i = 0; i < seed[routeTerpendek].length; i++) {
                      if(seed[routeTerpendek][i]==-1){
                         seed[routeTerpendek][i]=rcl_terpilih;
                         break;
                      }         
                  }
        }//tutup while
       
       return seed;
            
    }       
     public int indexMin1(double jarak[]){
       double cmin=1000.0;
       int index=0;
          for (int i = 2; i < jarak.length; i++) {
           
               if (cmin>jarak[i]) {
                  cmin=jarak[i];
                  index=i;
              }
        }
      return index;
    }

    public int indexMin(double jarak[]){
       double cmin=1000.0;
       int index=0;
          for (int i = 0; i < jarak.length; i++) {
           
               if (cmin>jarak[i]) {
                  cmin=jarak[i];
                  index=i;
              }
        }
      return index;
    }
    public int indexMax(double jarak[]){
       double cmax=0.0;
       int index=0;
          for (int i = 0; i < jarak.length; i++) {
              if (cmax<jarak[i]) {
                  cmax=jarak[i];
                  index=i;
              }
        }
      return index;
    }
    public boolean isEmpityContainer(int kontainer[]){
        boolean  isEmpity=true;
        a: for (int i = 0; i < kontainer.length; i++) {
            if (kontainer[i]>0) {
                isEmpity=false;
                break a;
            }
           }
        return isEmpity;
    }
    public boolean isEmpityTPS(double tps[]){
        boolean  isEmpity=true;
        a: for (int i = 0; i < tps.length; i++) {
            if (tps  [i]>0) {
                isEmpity=false;
                break a;
            }
           }
        return isEmpity;
    }
   
    public int  hitungkontainerberisi(int []kontainer){
        int sum=0;
        for (int i = 0; i < kontainer.length; i++) {
            if(kontainer[i]>0)
                sum+=kontainer[i];
        }
        return sum;
    }
     public int  hitungtpsberisi(double []tps){
        int sum=0;
        for (int i = 0; i < tps.length; i++) {
            if(tps[i]>0)
                sum++;
        }
        return sum;
    }
     public int  hitungIndex(int []index){
        int sum=0;
        for (int i = 0; i < index.length; i++) {
            if(index[i]>-1)
                sum++;
        }
        return sum;
    }
    public int[][] routes(String []route){
        int [][] routes=new int[route.length][30];
        
        for (int i = 0; i < routes.length; i++) {

            String a[]=route[i].split(" ");
              int bb[]=new int[a.length];
            for (int j = 0; j < a.length; j++) {
               bb[j]=Integer.valueOf(a[j]);
                
            }
            for (int k = 0; k < routes[i].length; k++) {
                if (k<bb.length) {
                     routes[i][k]= bb[k];
                }else
                routes[i][k]= -1;
            }
         }
        return routes;
    }
    public double []jarak(int sol[][], int index) throws IOException{
        int a=hitungIndex(sol[index]);
            double jarak[]=new double[a];
           Input in =new Input();
           double jarak_a[]=in.jarak_arm();
           for (int i = 0; i < jarak.length; i++) {
            jarak[i]=jarak_a[sol[index][i]];
        }
                   
        return jarak;      
    }
   public int indexC(int m, int [] index){
       int indeks=0;
       for (int i = 0; i < index.length; i++) {
           if(m==index[i])
               indeks=i;
       }
       return indeks;
   }
   public String [][]routes(int [][]solusi) throws IOException{
       Input in=new Input();
       String namaTPS_a[]=in.daftarTPSArmroll();
       String namaTPS_d[]=in.daftarTPSDumptruck();
       String routes[][]=new String[solusi.length][solusi[0].length];
       for (int i = 0; i < routes.length; i++) {
           
           for (int j = 0; j < routes[i].length; j++) {
                   
               if(i<2){
                   
                   if(solusi[i][j]>-1)
                      
                    routes[i][j]=" ["+namaTPS_d[solusi[i][j]]+"] ";
                   else
                     routes[i][j]=" ";  
               }else{
                   
                   if(solusi[i][j]>-1)
                   routes[i][j]=" ["+namaTPS_a[solusi[i][j]]+"] ";
                   else
                     routes[i][j]=" "; 
               }
           }
       }
       return routes;
   }
   public String [][]routesSkenario2(int [][]solusi) throws IOException{
       Input in=new Input();
       String namaTPS_a[]=in.daftarTPSArmroll();
       String namaTPS_d[]=in.daftarTPSDumptruck();
       String routes[][]=new String[solusi.length][solusi[0].length];
       for (int i = 0; i < routes.length; i++) {
           
           for (int j = 0; j < routes[i].length; j++) {
                  if(solusi[i][j]>-1)
                   routes[i][j]=" ["+namaTPS_a[solusi[i][j]]+"] ";
                   else
                     routes[i][j]=" "; 
            }
          
       }
       return routes;
   }
   public double[] jarak_perroute(int [][]solusi) throws IOException{
        Input in =new Input();
        double [] jarak_a=in.jarak_arm();
        double [][] jarak_d=in.jarak_d();
        int jmh_r_d=in.jmhRouteDumptruck();
        double [] jarakperroute=new double[solusi.length-jmh_r_d+1];
        double []x=new double[jmh_r_d];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j <solusi[i].length ; j++) {
                if(solusi[i][j]!=-1){
                    x[i]++;
                }else{
                    break;
                }
            }
        }
        for (int i = 0; i < jarakperroute.length; i++) {
            if (i==0) {
                for (int k = 0; k < jmh_r_d; k++) {//2,3,1
                    for (int j = 0; j < x[k]; j++) {
                        
                            if(j<x[k]-1){
                               
                              jarakperroute[i]+=jarak_d[solusi[k][j]+1][solusi[k][j+1]+1];
                                
                                

                            }
                            else { 

                                 jarakperroute[i]+=jarak_d[solusi[k][j]+1][0];   
                               jarakperroute[i]+=jarak_d[0][solusi[k][0]+1];
        
                            }
                                  
                        
                } 
  
                    
                }
                
            }else{
                for (int j = 0; j < solusi[0].length; j++) {
                     if(solusi[i+jmh_r_d-1][j]>-1){
                         jarakperroute[i]+=2*jarak_a[solusi[i+jmh_r_d-1][j]];
                        
                         
                     }   
                }
            }
        }
        return jarakperroute;
    }
   public double[] jarak_perroute_s(int [][]solusi) throws IOException{
        Input in =new Input();
        double [] jarak_a=in.jarak_arm();
        double [][] jarak_d=in.jarak_d();
        int jmh_r_d=in.jmhRouteDumptruck();
        double [] jarakperroute=new double[solusi.length];
        double []x=new double[jmh_r_d];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j <solusi[i].length ; j++) {
                if(solusi[i][j]!=-1){
                    x[i]++;
                }else{
                    break;
                }
            }
        }
        for (int i = 0; i < jarakperroute.length; i++) {
            if (i<jmh_r_d) {//2,3,1
                    for (int j = 0; j < x[i]; j++) {
                            if(j<x[i]-1){  
                              jarakperroute[i]+=jarak_d[solusi[i][j]+1][solusi[i][j+1]+1];
                            }
                            else { 
                                 jarakperroute[i]+=jarak_d[solusi[i][j]+1][0];   
                               jarakperroute[i]+=jarak_d[0][solusi[i][0]+1];
                            }     
                }     
            }else{
                for (int j = 0; j < solusi[0].length; j++) {
                     if(solusi[i+jmh_r_d][j]>-1){
                         jarakperroute[i]+=2*jarak_a[solusi[i+jmh_r_d][j]];
                        
                         
                     }   
                }
            }
        }
        return jarakperroute;
    }
   public double[] jarakperrouteSkenario2(int [][]solusi) throws IOException{
        Input in =new Input();
        double [] jarak_a=in.jarak_arm();
        double [] jarakperroute=new double[solusi.length];
        for (int i = 0; i < jarakperroute.length; i++) {
                for (int j = 0; j < solusi[0].length; j++) {
                     if(solusi[i][j]>-1){
                         jarakperroute[i]+=2*jarak_a[solusi[i][j]];        
                     }   
                }   
        }
        return jarakperroute;
    }
}
