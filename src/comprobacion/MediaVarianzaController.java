/*
    █████╗ ██╗ █████╗ ███████╗
    ██╔══██╗██║██╔══██╗╚══███╔╝
    ██║  ██║██║███████║  ███╔╝ 
    ██║  ██║██║██╔══██║ ███╔╝  
    ██████╔╝██║██║  ██║███████╗
    ╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝
*/

package comprobacion;

import simulacion.Main;

/**
 *
 * @author marcodiaz
 */
public class MediaVarianzaController {
    
    public Double calcularMedia() {
        
        Double suma = 0.0;
        
        for (String n : Main.lista ) {
            suma += Double.parseDouble(n);
        }
        
        return suma / Main.numDatos;
    }
    
    // ∑(xi-xm)²/(n-1)
    
    public Double calcularVarianza() {
        Double suma = 0.0;
        Double xM = calcularMedia();
        
        int n = Main.numDatos;
        
        for (String s : Main.lista) {
            suma += (Math.pow(Double.parseDouble(s) - xM, 2));
        }
        
        return suma / (n - 1);
       
    }
    
}
