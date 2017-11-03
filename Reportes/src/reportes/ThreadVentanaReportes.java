/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author Margarita
 */
public class ThreadVentanaReportes extends Thread  {
   Reportes  vent;

ThreadVentanaReportes(){
vent = new Reportes();
}


 public void run(){
  vent. setVisible(true);
  //while(vent.continuar<1){
      
    //    }
 }    
}
