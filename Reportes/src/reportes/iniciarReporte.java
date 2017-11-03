/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;
import javax.servlet.ServletOutputStream;



/**
 *
 * @author juank
 */
public class iniciarReporte {
static Connection conn=null;
String []selreporte= new String [50];

iniciarReporte(){
//selreporte[0]="C:/Users/ASUS/Documents/NetBeansProjects/Reportes/src/formularios/Consumo.jasper";
selreporte[0]="C:/Reportes/src/reportes/Consumo.jasper";

 try{Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(Reportes.Basedatos);
                }catch(Exception ex){ex.printStackTrace();}
    }


public void informe(String Fechaini,String Fechafin, String variable){
  try{
        
System.out.println(Fechaini+" "+Fechafin+" "+ variable);
String  archivo =selreporte[0];
JasperReport masterReport=null;
try{
      masterReport=(JasperReport)JRLoader.loadObjectFromFile(archivo);}
catch(JRException e){System.out.println("ERROR CARGANDO EL REPORTE MAESTRO "+e.getMessage());
System.exit(3);}
Map parametro = new HashMap();

parametro.put("Fechainicial",Fechaini);
parametro.put("Fechafinal",Fechafin);
parametro.put("tipovariable",variable);
JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport,parametro ,conn);
JasperViewer jviewer= new JasperViewer(jasperPrint,false);
//jviewer.setTitle("INFORME NIVEL DE GASES");
jviewer.setVisible(true);}catch(JRException e){System.out.println("ERROR CARGANDO EL REPORTE MAESTRO "+e.getMessage());
System.exit(3);}

   // }catch(Exception j){System.out.println("MENSAJE DE ERROR"+j.getMessage());}
}

public void grafico(String Fechaini,String Fechafin,String Horaini,String Horafin, String variable){
  try{
        
      //  System.out.println(Fechaini+" "+Fechafin+" "+Horaini+" "+Horafin+" "+reactor+" "+ gas);
String  archivo =selreporte[1];
JasperReport masterReport=null;
try{
      masterReport=(JasperReport)JRLoader.loadObjectFromFile(archivo);}
catch(JRException e){System.out.println("ERROR CARGANDO EL REPORTE MAESTRO "+e.getMessage());
System.exit(3);}
Map parametro = new HashMap();

parametro.put("Fechainicial",Fechaini);
parametro.put("Fechafinal",Fechafin);
parametro.put("HoraIni",Horaini);
parametro.put("HoraFin",Horafin);
parametro.put("tipovariable",variable);
JasperPrint jasperPrint=JasperFillManager.fillReport(masterReport,parametro ,conn);
JasperViewer jviewer= new JasperViewer(jasperPrint,false);
jviewer.setTitle("INFORME NIVEL DE GASES");
jviewer.setVisible(true);}catch(JRException e){System.out.println("ERROR CARGANDO EL REPORTE MAESTRO "+e.getMessage());
System.exit(3);}

   // }catch(Exception j){System.out.println("MENSAJE DE ERROR"+j.getMessage());}
}



public void cerrar(){
try{conn.close();}
catch(SQLException ex){ex.printStackTrace();}

}


}
