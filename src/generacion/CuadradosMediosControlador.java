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

import javax.swing.table.DefaultTableModel;
import simulacion.Main;

/**
 *
 * @author sergioplascencia
 */
public class CuadradosMediosControlador {

    public void generar(Double numero) {
        
        Main.lista.removeAll(Main.lista);
        
        for(int i = 0 ; i < Main.numDatos ; i ++) {
            numero = Math.pow(numero, 2);
            String sNumero = String.format("%.12f", numero);
            sNumero = sNumero.substring(2, 6);
            numero = Double.parseDouble(sNumero);
            numero = numero / 10000;
            Main.lista.add("" + numero);
            numero = numero * 10000;
        }
        
        DefaultTableModel model = (DefaultTableModel) Main.tablaNumeros.getModel();
        model.setRowCount(0);
        
        Main.lista.forEach((num) -> {
            String[] rows = new String[1];
            rows[0] = num;
            model.addRow(rows);
        });
        
        Main.tablaNumeros.setModel(model);
        
        
    }

}
