/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolSegundoParcial;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ListaArbolBinario {
    
    ClaseArbol arbol;
    ArrayList<ClaseArbol> listaArbol;
    
    //Constructor
    public ListaArbolBinario(int cantidad){
        listaArbol = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            listaArbol.add(new ClaseArbol());
        }
    }
    
    public void insertarDato(int posLista, int x){
        listaArbol.get(posLista).insertar(x);
    }
    
    public void RecorridoInORden(int posLista){
        listaArbol.get(posLista).RecorrridoInOrden();
    }
    
    public int cantidadNodosPosLista(int posLista){
        return listaArbol.get(posLista).contarLaCantidadNodos();
    }
    
    public int cantidadNodosIncompletos(int posLista){
        return listaArbol.get(posLista).contarCantidadNodoIncompletos();
    }
    
    public int sumarLaCantidadNodos(int posLista){
        return listaArbol.get(posLista).sumar();
    }
    
    public void mostrarRecorridoPorNiveles(int posLista){
        listaArbol.get(posLista).mostrarNivel();
    }

    public void eliminarElMayorNodo(int posLista){
        listaArbol.get( posLista).eliminarMayorNodo();
    }
    
    public static void main(String[] args) {
//        estoy indicando que mi arrayList tendra un espacio de 3 casillas 
//        osea insertare un arbol en cada casilla  de mi arbol
        ListaArbolBinario l1 = new ListaArbolBinario(3);
        //ejercicio 1
        //De las 3 casillas de mi arrayList, estoy agregando unicamente en mi posicion 0
        //los datos para mi arbol 
        l1.insertarDato(0, 100);
        l1.insertarDato(0, 80);
        l1.insertarDato(0, 90);
        
        //si quiero agregaar datos en mi arbol en la casilla 1 de mi arrayList 
//        l1.insertarDato(1, 90);
//        l1.insertarDato(1, 70);
//        l1.insertarDato(1, 60);

         //si quiero agregaar datos en mi arbol en la casilla 2 de mi arrayList 
//        l1.insertarDato(2, 90);
//        l1.insertarDato(2, 70);
//        l1.insertarDato(2, 60);
        
        //A partir de aqui unciamente esty trabando sobre la casillas pos = 0 de mi array list
        //ya que anterrioremente eh agregado en posicion 0
        
        //Ejercicio 2 Cantidad de Nodos de mi arbol es POsicion 0 de mi arrayList
        System.out.println(l1.cantidadNodosPosLista(0));
        //Ejercicio 3 Cantidad de Nodos incompletos
        System.out.println(l1.cantidadNodosIncompletos(0) );
        //Ejercicio 4 mostrar Recoriddo por niveles de posicoin '0 del ArrayList
       l1.mostrarRecorridoPorNiveles(0);
       //Eliminar el mayor de la posicion 0 de mi arrayList
       l1.eliminarElMayorNodo(0);
       
       l1.RecorridoInORden(0);
    }
}
