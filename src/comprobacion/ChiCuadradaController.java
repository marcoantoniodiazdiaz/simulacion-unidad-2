/*
    █████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package comprobacion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simulacion.Main;

/**
 *
 * @author marcodiaz
 */
public class ChiCuadradaController {
    
    public void ejecutarComprobacion() {
        
        Double N = (double) Main.numDatos;
        
        Double M = Math.sqrt(N);
        Double Ei = N / M;
        
        Double amplitud = M / N;
        
        BigDecimal bigM = new BigDecimal(M);
        int intervalos = bigM.setScale(0, RoundingMode.UP).intValue();
        
        System.out.println(intervalos);
        
        Double intervalDown = 0.0;
        Double intervalUp = intervalDown + amplitud;
        
        DefaultTableModel model = (DefaultTableModel) ChiCuadrada.tablaChiCuadrada.getModel();
        String[] row = new String[5];
        model.setRowCount(0);
        
        Double suma = 0.0;
        
        for (int i = 0; i < intervalos; i++) {
            row[0] = intervalDown.toString();
            row[1] = intervalUp.toString();
            
            int Oi = 0;
            
            for (String s : Main.lista) {
                Double num = Double.parseDouble(s);
                
                if (num >= intervalDown && num <= intervalUp) {
                    Oi ++;
                }
            }
            
            intervalDown = intervalUp;
            intervalUp += amplitud;
            
            row[2] = "" + Oi;
            row[3] = Ei.toString();
            Double calculo = Math.pow(Ei - Oi, 2) / Ei;
            row[4] = "" + calculo;
            
            suma += calculo;
            
            model.addRow(row);
        }
        
        if (suma < 12.59) {
            JOptionPane.showMessageDialog(null, "Paso la prueba", "Chi Cuadrada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No paso la prueba", "Chi Cuadrada", JOptionPane.WARNING_MESSAGE);
        }
        
        ChiCuadrada.tablaChiCuadrada.setModel(model);
    }

}
