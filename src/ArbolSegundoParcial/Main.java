/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolSegundoParcial;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        ListaArbolBinario la = new ListaArbolBinario(5);
        la.insertarDato(0, 100);
        la.insertarDato(0, 80);
        la.insertarDato(0, 120);
        
        la.insertarDato(3, 50);
        la.insertarDato(3, 90);
        la.insertarDato(3, 20);
        
        System.out.println(la.cantidadNodosPosLista(0) );    
        
        la.mostrarRecorridoPorNiveles(3); 
        
        
        
        
    }
}
