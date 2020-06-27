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
public class Driver {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)  throws IOException {//J
        // GRASP
        ObjectiveFunction of=new ObjectiveFunction();
        Output op=new Output();
      MetodeGrasp gr =new MetodeGrasp();
        Fleksibel f=new Fleksibel();
        Random r =new Random();
      
        
       for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
               int s[][]=gr.procedureGrasp(f.alfa(j), f.iterasiLocalSearch(j), f.iterasiProcedure(j), f.tempatPenyimpananNilaiFitnessPerIterasi(j, i));
                int s2[][]=gr.procedureGraspSkenario2(f.alfa(j), f.iterasiLocalSearch(j), f.iterasiProcedure(j), f.tempatPenyimpananNilaiFitnessPerIterasiSkenario2(j, i));
                op.outputRute(gr.routes(s), f.tempatPenyimpananRoute(j, i));
                op.outputRuteSkenario2(gr.routesSkenario2(s2), f.tempatPenyimpananRouteSkenario2(j, i));
               op.jarakPerRoute(gr.jarak_perroute(s), f.tempatPenyimpananJarak(j, i));
                op.jarakPerRoute(gr.jarakperrouteSkenario2(s2), f.tempatPenyimpananJarakSkenario2(j, i));
               op.penalti(of.deviasi(gr.jarak_perroute(s)), f.tempatPenyimpananNilaiFitness(j, i));
                op.penalti(of.deviasi(gr.jarakperrouteSkenario2(s2)), f.tempatPenyimpananNilaiFitnessSkenario2(j, i));
            }
            
        }
      
     //Metode lain
    /* ObjectiveFunction of=new ObjectiveFunction();
     MetodeGrasp gr =new MetodeGrasp();
     MetodeLain a=new MetodeLain();
     int s[][]=a.hillClimbingSkenario2(100000);
        System.out.println(of.deviasi(gr.jarakperrouteSkenario2(s)));
      */  
        
    }
}
