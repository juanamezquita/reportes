/*
 * Se crea un hilo que permite abrir varias ventanas al tiempo
 * con el fin de que el usuario tenga la opción de generar varios reportes
 * de forma simultanea 
 */
package reportes;

/**
 *
 * @author Juan Amezqutia
 */
public class ThreadVentanaReportes extends Thread  {
   Reportes  vent;

ThreadVentanaReportes(){
vent = new Reportes();
}


 public void run(){
  vent. setVisible(true);
  
 }    
}
