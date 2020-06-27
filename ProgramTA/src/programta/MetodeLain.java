/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programta;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author admin
 */
public class MetodeLain {
     public int [][] inisialSolusi() throws IOException{
        Input in =new Input();
        int jmh_kontainer_pertps_a[]=in.jumlahKontainerPerTPS();
        int jmh_seluruh_kontainer_a=in.jmhSeluruhKontainer();
        double vol_pertps_d[]=in.volume_tps_d();
        int s0_a[][]=new int [11][30];
        int s0_d[][]=new int[in.jmhRouteDumptruck()][30];
        int s0[][]=new int[s0_a.length+s0_d.length][30];
        int indeks_tps_a []=new int [jmh_seluruh_kontainer_a];
        int k=0;
        for (int i = 0; i < jmh_kontainer_pertps_a.length; i++) {
            for (int j = 0; j < jmh_kontainer_pertps_a[i]; j++) {
                indeks_tps_a[k]=i;
                k++;
            }
        }
        k=0;
         for (int i = 0; i < s0_a[0].length; i++) {

            for (int j = 0; j < s0_a.length; j++) {
               if (k<indeks_tps_a.length) {
                    s0_a[j][i]=indeks_tps_a[k];
                    k++;
                  
                }else{
                   s0_a[j][i]=-1;
               }
              
               
            }
           
        }
        //dumptruck
        k=0;
        double kapasias_dump=8.0;
        double vol_perroute[]=new double[s0_d.length];
        for (int i = 0; i < s0_d.length; i++) {
           for (int j = 0; j < s0_d[i].length; j++) {
                if(k<vol_pertps_d.length){
                    if(vol_perroute[i]+ vol_pertps_d[k]<kapasias_dump){
                        vol_perroute[i]+=vol_pertps_d[k];
                        s0_d[i][j]=k;
                        k++;
                    }else{
                        s0_d[i][j]=-1;
                    }
                }else{
                    s0_d[i][j]=-1;
                }
            }
        }
        
        for (int i = 0; i < s0.length; i++) {
            for (int j = 0; j < s0[i].length; j++) {
                if(i<s0_d.length){
                    s0[i][j]=s0_d[i][j];
                }else{
                     s0[i][j]=s0_a[i-2][j];
                }
            }
        }
        return s0;
    }
    public int [][] inisialSolusiSkenario2() throws IOException{
        Input in =new Input();
        int jmh_kontainer_pertps_a[]=in.jumlahKontainerPerTPS();
        int jmh_seluruh_kontainer_a=in.jmhSeluruhKontainer();
        int s0_a[][]=new int [11][30];
        int indeks_tps_a []=new int [jmh_seluruh_kontainer_a];
        int k=0;
        for (int i = 0; i < jmh_kontainer_pertps_a.length; i++) {
            for (int j = 0; j < jmh_kontainer_pertps_a[i]; j++) {
                indeks_tps_a[k]=i;
                k++;
            }
        }
        k=0;
         for (int i = 0; i < s0_a[0].length; i++) {

            for (int j = 0; j < s0_a.length; j++) {
               if (k<indeks_tps_a.length) {
                    s0_a[j][i]=indeks_tps_a[k];
                    k++;
                  
                }else{
                   s0_a[j][i]=-1;
               }
              
        
            }
           
        }
       
        return s0_a;
    }
     public int [][]hillClimbing(int maxIterasi) throws IOException{
         MetodeGrasp gr =new MetodeGrasp();
         Input in=new Input();
         int jmh_route_d=in.jmhRouteDumptruck();
         ObjectiveFunction of =new ObjectiveFunction();
         int solusi[][]=inisialSolusi();
         int s0[][]=new int[solusi.length][solusi[0].length];
          int s1[][]=new int[solusi.length][solusi[0].length];
         for (int i = 0; i < s0.length; i++) {
             for (int j = 0; j < s0[i].length; j++) {
                 s0[i][j]=solusi[i][j];
                 s1[i][j]=solusi[i][j];
             }
         }
         Random r =new Random();
         int v=0;
         double ev_s0=of.deviasi(gr.jarak_perroute(s0));
         double ev_s1=of.deviasi(gr.jarak_perroute(s1));
         for (int i = 0; i < maxIterasi; i++) {
              if(v==2)
                v=0;
              int rand_a_r1=jmh_route_d+r.nextInt(s1.length-jmh_route_d);
              int rand_a_r2=jmh_route_d+r.nextInt(s1.length-jmh_route_d);
              int rand_a_c1=r.nextInt(gr.hitungIndex(s1[rand_a_r1]));
              int rand_a_c2=r.nextInt(gr.hitungIndex(s1[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(gr.hitungIndex(s1[rand_d_r1]));
              int rand_d_c2 = r.nextInt(gr.hitungIndex(s1[rand_d_r2]));
              pilihVariabelNeighbourhood(v, s1, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c2);
              ev_s1=of.deviasi(gr.jarak_perroute(s1));
                  
               if(ev_s1<ev_s0){
                    ev_s0=ev_s1;
                    for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                            
               }else{
                    ev_s1=ev_s0;
                    for (int k= 0; k < s1.length; k++) {
                        for (int j = 0; j < s1[0].length; j++) {
                            s1[k][j]=s0[k][j];
                                  
                        }
                    }
                    v++;
                }       
                      
             System.out.println(ev_s0);
                      
        }
        return s0;
     }
     public int [][]hillClimbingSkenario2(int maxIterasi) throws IOException{
         MetodeGrasp gr =new MetodeGrasp();
         Input in=new Input();
         int jmh_route_d=in.jmhRouteDumptruck();
         ObjectiveFunction of =new ObjectiveFunction();
         int solusi[][]=inisialSolusiSkenario2();
         int s0[][]=new int[solusi.length][solusi[0].length];
          int s1[][]=new int[solusi.length][solusi[0].length];
         for (int i = 0; i < s0.length; i++) {
             for (int j = 0; j < s0[i].length; j++) {
                 s0[i][j]=solusi[i][j];
                 s1[i][j]=solusi[i][j];
             }
         }
         Random r =new Random();
         int v=0;
         double ev_s0=of.deviasi(gr.jarakperrouteSkenario2(s0));
         double ev_s1=of.deviasi(gr.jarakperrouteSkenario2(s1));
         for (int i = 0; i < maxIterasi; i++) {
              if(v==1)
                v=0;
              int rand_a_r1=r.nextInt(s1.length);
              int rand_a_r2=r.nextInt(s1.length);
              int rand_a_c1=r.nextInt(gr.hitungIndex(s1[rand_a_r1]));
              int rand_a_c2=r.nextInt(gr.hitungIndex(s1[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(gr.hitungIndex(s1[rand_d_r1]));
              int rand_d_c2 = r.nextInt(gr.hitungIndex(s1[rand_d_r2]));
              pilihVariabelNeighbourhood(v, s1, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c2);
              ev_s1=of.deviasi(gr.jarakperrouteSkenario2(s1));
               if(ev_s1<ev_s0){
                    ev_s0=ev_s1;
                    for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                            
               }else{
                    ev_s1=ev_s0;
                    for (int k= 0; k < s1.length; k++) {
                        for (int j = 0; j < s1[0].length; j++) {
                            s1[k][j]=s0[k][j];
                                  
                        }
                    }
                    v++;
                }       
                      
                      
            System.out.println(ev_s0);           
        }
        return s0;
     }
     
      public int[][] pilihVariabelNeighbourhood(int v, int [][]solusi_abs, int rand_a_r1,int rand_a_r2,int rand_a_c1,int rand_a_c2, int rand_d_r1, int rand_d_r2, int rand_d_c1, int rand_d_c2){
       int temp=0;
        switch (v){
            case 0://amroll swap antar route
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
            case 1://dumptruk swap antar route
                temp=solusi_abs[rand_d_r1][rand_d_c1];
                solusi_abs[rand_d_r1][rand_d_c1]=solusi_abs[rand_d_r2][rand_d_c2];
                solusi_abs[rand_d_r2][rand_d_c2]=temp;         
                break;
            
        }
        return solusi_abs;
    }
     
    public int [][]latedAnealing(int maxIterasi) throws IOException{
         MetodeGrasp gr =new MetodeGrasp();
         Input in=new Input();
         int jmh_route_d=in.jmhRouteDumptruck();
         ObjectiveFunction of =new ObjectiveFunction();
         int solusi[][]=inisialSolusi();
         int s0[][]=new int[solusi.length][solusi[0].length];
          int s1[][]=new int[solusi.length][solusi[0].length];
         for (int i = 0; i < s0.length; i++) {
             for (int j = 0; j < s0[i].length; j++) {
                 s0[i][j]=solusi[i][j];
                 s1[i][j]=solusi[i][j];
             }
         }
         Random r =new Random();
         int v=0;
         double t=0.99999;
         double ev_s0=of.deviasi(gr.jarak_perroute(s0));
         double ev_s1=of.deviasi(gr.jarak_perroute(s1));
         for (int i = 0; i < maxIterasi; i++) {
             double rd = r.nextDouble();
             t=t-0.0009;
             double p;
              if(v==2)
                v=0;
              int rand_a_r1=jmh_route_d+r.nextInt(s1.length-jmh_route_d);
              int rand_a_r2=jmh_route_d+r.nextInt(s1.length-jmh_route_d);
              int rand_a_c1=r.nextInt(gr.hitungIndex(s1[rand_a_r1]));
              int rand_a_c2=r.nextInt(gr.hitungIndex(s1[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(gr.hitungIndex(s1[rand_d_r1]));
              int rand_d_c2 = r.nextInt(gr.hitungIndex(s1[rand_d_r2]));
              s1=pilihVariabelNeighbourhood(v, s1, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c2);
              ev_s1=of.deviasi(gr.jarak_perroute(s1));
              double c=ev_s0-ev_s1;
              double cabs=Math.abs(c);
              p=Math.exp(-(cabs)/t);
               if(c<ev_s0){
                    ev_s0=ev_s1;
                    for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                            
               }else{
                   if(p<rd){
                        ev_s0=ev_s1;
                        for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                   }else{
                        ev_s1=ev_s0;
                        for (int k= 0; k < s1.length; k++) {
                            for (int j = 0; j < s1[0].length; j++) {
                                s1[k][j]=s0[k][j];

                            }
                        }
                        v++;
                   }
                }       
                      
                      
                      
        }
        return s0;
     }
    public int [][]SimulatedAnealingSkenario2(int maxIterasi) throws IOException{
         MetodeGrasp gr =new MetodeGrasp();
         Input in=new Input();
         ObjectiveFunction of =new ObjectiveFunction();
         int jmh_route_d=in.jmhRouteDumptruck();
         int solusi[][]=inisialSolusiSkenario2();
         int s0[][]=new int[solusi.length][solusi[0].length];
          int s1[][]=new int[solusi.length][solusi[0].length];
         for (int i = 0; i < s0.length; i++) {
             for (int j = 0; j < s0[i].length; j++) {
                 s0[i][j]=solusi[i][j];
                 s1[i][j]=solusi[i][j];
             }
         }
         Random r =new Random();
         int v=0;
         double t=0.99999;
         double ev_s0=of.deviasi(gr.jarakperrouteSkenario2(s0));
         double ev_s1=of.deviasi(gr.jarakperrouteSkenario2(s1));
         for (int i = 0; i < maxIterasi; i++) {
             double rd = r.nextDouble();
             t=t-0.009;
             double p;
              if(v==1)
                v=0;
              int rand_a_r1=r.nextInt(s1.length);
              int rand_a_r2=r.nextInt(s1.length);
              int rand_a_c1=r.nextInt(gr.hitungIndex(s1[rand_a_r1]));
              int rand_a_c2=r.nextInt(gr.hitungIndex(s1[rand_a_r2]));
              //dumptruck
              int rand_d_r1=r.nextInt(jmh_route_d);
              int rand_d_r2=r.nextInt(jmh_route_d);
              int rand_d_c1 = r.nextInt(gr.hitungIndex(s1[rand_d_r1]));
              int rand_d_c2 = r.nextInt(gr.hitungIndex(s1[rand_d_r2]));
              pilihVariabelNeighbourhood(v, s1, rand_a_r1, rand_a_r2, rand_a_c1, rand_a_c2, rand_d_r1, rand_d_r2, rand_d_c1, rand_d_c2);
              ev_s1=of.deviasi(gr.jarakperrouteSkenario2(s1));
              double c=ev_s0-ev_s1;
              double cabs=Math.abs(c);
              p=Math.exp(-(cabs)/t);
               if(c<ev_s0){
                    ev_s0=ev_s1;
                    for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                            
               }else{
                   if(p<rd){
                        ev_s0=ev_s1;
                        for (int k= 0; k < s0.length; k++) {
                        for (int j = 0; j < s0[0].length; j++) {
                            s0[k][j]=s1[k][j];
                                  
                        }
                    }
                   }else{
                        ev_s1=ev_s0;
                        for (int k= 0; k < s1.length; k++) {
                            for (int j = 0; j < s1[0].length; j++) {
                                s1[k][j]=s0[k][j];

                            }
                        }
                        v++;
                   }
                }       
                      
                      
                      
        }
        return s0;
     }
}
