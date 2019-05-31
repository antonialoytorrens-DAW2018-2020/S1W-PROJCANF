
package com.canf.utilitats;


public abstract class Validacions {
    
    public static boolean validaCadena(String cadena) {
        return cadena != null && !"".equals(cadena.trim());
    }

    public static boolean validaInt(Integer i) {
		return (i != null && i > 0);
    }
    
    public static boolean validaDouble(double d) {
		return (d > 0);
    }
    
}
