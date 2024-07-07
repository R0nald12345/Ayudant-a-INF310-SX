/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerParcial;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        GrafoPesado G1 = new GrafoPesado();
        
        //Estamos insertando los vertices
        G1.insertarNodo("A");
        G1.insertarNodo("B");
        G1.insertarNodo("C");
        G1.insertarNodo("D");
        G1.insertarNodo("E");
        
        G1.insertarArco("A", "B", 2);
        G1.insertarArco("B", "C", 5);
        G1.insertarArco("B", "E", 3);
        G1.insertarArco("B", "D", 4);
        G1.insertarArco("C", "D", 6);
        G1.insertarArco("D", "E", 1);
//        
        G1.mostrar();
        System.out.println("El mayor valor de Arco es: "+ G1.mostrarMayorValorDelArco());
        System.out.println("El menor valor de Arco es: "+ G1.mostrarMenorValorDelArco());
        System.out.println("La cantidad de Flechas que llegan a D: " + G1.cantidadDeLlegadas("D"));
    }
}
