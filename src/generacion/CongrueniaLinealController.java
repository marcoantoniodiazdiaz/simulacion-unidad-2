/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generacion;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import simulacion.Main;

/**
 *
 * @author marcodiaz
 */
public class CongrueniaLinealController {
    
    List<Double> list = new ArrayList<>();
    
    public void execute(Double x, Double a, Double c, Double m) {
        
        for (int i = 0; i < 40; i++) {
            Double r = a*x + c;
            r = r % m;
            
            r = Double.parseDouble(("" + r).substring(0, 6));
            // System.out.println(r);
            
            list.add(r);

            x = r;
        }
        
        
        DefaultTableModel model = (DefaultTableModel) Main.tablaNumeros.getModel();
        model.setRowCount(0);
        
        list.forEach((num) -> {
            String[] rows = new String[1];
            rows[0] = num.toString();
            model.addRow(rows);
        });
        
        Main.tablaNumeros.setModel(model);
    }
    
}
