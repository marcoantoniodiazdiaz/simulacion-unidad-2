/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generacion;

import javax.swing.table.DefaultTableModel;
import simulacion.Main;

/**
 *
 * @author marcodiaz
 */
public class CongrueniaLinealController {
    
    public void execute(Double x, Double a, Double c, Double m) {
        
        Main.lista.removeAll(Main.lista);
        
        for (int i = 0; i < Main.numDatos; i++) {
            Double r = a*x + c;
            r = r % m;
            
            r = Double.parseDouble(("" + r).substring(0, 6));
            
            Main.lista.add("" + r);

            x = r;
        }
        
        
        DefaultTableModel model = (DefaultTableModel) Main.tablaNumeros.getModel();
        model.setRowCount(0);
        
        Main.lista.forEach((num) -> {
            String[] rows = new String[1];
            rows[0] = num.toString();
            model.addRow(rows);
        });
        
        Main.tablaNumeros.setModel(model);
    }
    
}
