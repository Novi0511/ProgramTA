/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programta;

import java.io.IOException;

/**
 *
 * @author admin
 */
public class ObjectiveFunction {
    public  double deviasi(double jarak_perroute[]) throws IOException{
    double[]x=jarak_perroute;
    double mean = rata(x);
        
    double squareSum = 0;
    for (int i=0; i<x.length; i++){
      //  System.err.println(x[i]);
      squareSum += Math.pow(x[i] - mean, 2);
    }
   
    double akar =(squareSum)/(x.length);
     
     double stdev=Math.sqrt(akar);
    return stdev;
  }
   
    public  double rata(double[] x){
    double sum = 0;
    for (int i=0; i<x.length; i++) {
        
          sum += x[i];
      }
    return sum/x.length;
  }
    public double[] jarakperroute(int [][]solusi) throws IOException{
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
}
