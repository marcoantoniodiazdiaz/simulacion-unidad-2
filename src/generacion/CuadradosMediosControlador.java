/*
 .----..----..---. .----..-. .---.  
{ {__-`} |__}} }}_}| |--'{ |/ {-. \ 
.-._} }} '__}| } \ | }-`}| }\ '-} / 
`----' `----'`-'-' `----'`-' `---'  
*/

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
 * @author sergioplascencia
 */
public class CuadradosMediosControlador {
    
    List<Double> list = new ArrayList<>();
    

    public void generar(Double numero) {
        
        for(int i = 0 ; i < 40 ; i ++) {
            numero = Math.pow(numero, 2);
            String sNumero = String.format("%.12f", numero);
            sNumero = sNumero.substring(2, 6);
            numero = Double.parseDouble(sNumero);
            numero = numero / 10000;
            list.add(numero);
            System.out.println(numero);
            numero = numero * 10000;
        }
        
        DefaultTableModel model = (DefaultTableModel) Main.tablaNumeros.getModel();
        model.setRowCount(0);
        Main.tablaNumeros.setModel(model);
        
        for (Double num : list) {
            String[] rows = new String[1];
            rows[0] = num.toString();
            model.addRow(rows);
        }
        
        Main.tablaNumeros.setModel(model);
        
        
    }

}
