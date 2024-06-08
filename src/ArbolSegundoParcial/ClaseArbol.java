/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolSegundoParcial;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ClaseArbol {

    public NodoBinario raiz;

    //Constructor
    public ClaseArbol() {
        this.raiz = null;
    }

    //insertar un dato x en el Arbol
    public void insertar(int x) {
        raiz = insertarRecursivo(raiz, x);
    }

    private NodoBinario insertarRecursivo(NodoBinario nuevoRaiz, int x) {
        if (nuevoRaiz == null) {
//            NodoBinario nuevo = new NodoBinario(x);
//            nuevoRaiz = nuevo;
//            return nuevoRaiz;
            return new NodoBinario(x);
        }
        //caso General
        if (x < nuevoRaiz.dato) {
            nuevoRaiz.izq = insertarRecursivo(nuevoRaiz.izq, x); //entra lado izquierdo
        } else {
            nuevoRaiz.der = insertarRecursivo(nuevoRaiz.der, x);
        }
        return nuevoRaiz;
    }

    public void RecorrridoInOrden() {
        RecorridoInOrdenRecursivo(raiz);
    }

    private void RecorridoInOrdenRecursivo(NodoBinario raizAuxiliar) {
        //Caso Base| Que pasa si mi arbol es Vacio
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        RecorridoInOrdenRecursivo(raizAuxiliar.izq);
        System.out.print(raizAuxiliar.dato + " ");
        RecorridoInOrdenRecursivo(raizAuxiliar.der);
    }

    public boolean isHijo(NodoBinario r) {
        return r.izq == null && r.der == null;
    }

    //Contar la cantidad de Nodos
    public int contarLaCantidadNodos() {
        return contarLaCantidadNodosRecursivo(raiz);
    }

    private int contarLaCantidadNodosRecursivo(NodoBinario raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }
        //Si mi arbol tiene 1 NOdo
        if (isHijo(raizAuxiliar)) {
            return 1;
        }
        //Caso General
        int hi = contarLaCantidadNodosRecursivo(raizAuxiliar.izq);
        int hd = contarLaCantidadNodosRecursivo(raizAuxiliar.der);
        return hi + hd + 1;
    }

    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }

    private int contarHojasRecursivo(NodoBinario raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }

        if (isHijo(raizAuxiliar)) {
            return 1;
        }
        int hi = contarHojasRecursivo(raizAuxiliar.izq);
        int hd = contarHojasRecursivo(raizAuxiliar.der);
        return hi + hd;
    }

    public int contarCantidadNodoIncompletos() {
        return contarCantidadNodoIncompletosRecursivo(raiz);
    }

    private int contarCantidadNodoIncompletosRecursivo(NodoBinario raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }
        if (isHijo(raizAuxiliar)) {
            return 0;
        }

        int hi = contarCantidadNodoIncompletosRecursivo(raizAuxiliar.izq);
        int hd = contarCantidadNodoIncompletosRecursivo(raizAuxiliar.der);
        if (raizAuxiliar.izq != null && raizAuxiliar.der == null || raizAuxiliar.izq == null && raizAuxiliar.der != null) {
            return hi + hd + 1;
        } else {
            return hi + hd;
        }

    }

    public int sumar() {
        return sumarRecursivo(raiz);
    }

    private int sumarRecursivo(NodoBinario raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }
        if (isHijo(raizAuxiliar)) {
            return raizAuxiliar.dato;
        }
        int hi = sumarRecursivo(raizAuxiliar.izq);
        int hd = sumarRecursivo(raizAuxiliar.der);
        return hi + hd + raizAuxiliar.dato;
    }

//   
//16.A1.niveles(L1) : Método que encuentra en la lista L1, el recorrido por niveles de los elementos del árbol A1.
//
//17.A1.mostrarNivel(): Método que muestra los elementos del árbol y el nivel en el que se encuentran. 
    //(Recorrer el árbol en cualquier orden)
    public void mostrarNivel() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }
        LinkedList<NodoBinario> colaLista = new LinkedList<>();
        colaLista.add(raiz);
        while (!colaLista.isEmpty()) {
            NodoBinario nodoAux = colaLista.removeFirst();
            System.out.print(nodoAux.dato + " ");
            if (nodoAux.izq != null) {
                colaLista.add(nodoAux.izq);
            }
            
            if (nodoAux.der != null) {
                colaLista.add(nodoAux.der);
            }
        }
    }

    //Eliminar NOdo de un Arbol
    //A1.eliminar(x) : Método que elimina el elemento x, del árbol A1.
    public void eliminar(int x) {
        raiz = eliminar(raiz, x);
    }

    public NodoBinario eliminar(NodoBinario p, int x) { //eliminar el 100
        if (p == null) { //si mi arbol esta vacio
            return null;
        }
        if (x == p.dato) { // si mi arbol tiene Un Dato 
            return eliminarNodo(p);
        }
        if (x < p.dato) {
            p.izq = eliminar(p.izq, x);
        } else {
            p.der = eliminar(p.der, x);
        }
        return p;
    }

    public NodoBinario eliminarNodo(NodoBinario p) {
        if (p.izq == null && p.der == null) { //Caso 0
            return null;
        }
        //Caso 1
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        //Caso 2
        int y = inmediatoSuperior(p.der);
        p.dato = y;
        p.der = eliminar(p.der, y);
        return p;
    }

    public int inmediatoSuperior(NodoBinario p) {
        if (p.izq == null) {
            return p.dato;
        } else {
            return inmediatoSuperior(p.izq);
        }
    }
    
    public NodoBinario obtenerMenorNodo(){
        NodoBinario aux = this.raiz;
        while(aux.izq != null){
            aux = aux.izq;
        }
        return aux;
    }
    
    
    public NodoBinario obtenerMayorNodo(){
        NodoBinario aux = this.raiz;
        while(aux.der != null){
            aux = aux.der;
        }
        return aux; 
    }
    
    public void eliminarMenorNodo(){
        NodoBinario menor = obtenerMenorNodo();
        eliminarNodo(menor);
    }
    
    public void eliminarMayorNodo(){
        NodoBinario mayor = obtenerMayorNodo();
        eliminarNodo(mayor);
    }
    
    public void eliminarDeUnaLista(ArrayList<Integer> a){
        eliminarDeUnaListaRecursivo(raiz, a);
    }
    
    
    private NodoBinario eliminarDeUnaListaRecursivo(NodoBinario raizAux,ArrayList<Integer> a){
        //SI mi arcbol es Vacio
        if(raizAux == null){
            return null;
        }
        
        //Si mi arbol tiene un NOdo
        if(isHijo(raizAux )){
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i) == raizAux.dato ){
                    eliminar(a.get(i));
                }
            }
        }
       return raizAux; 
    }
    
//    public void void
    

    public static void main(String[] args) {
        ClaseArbol a1 = new ClaseArbol();

        a1.insertar(20);
        a1.insertar(15);
        a1.insertar(40);
        a1.insertar(6);
        a1.insertar(35);
//        a1.insertar(85);

        a1.RecorrridoInOrden();
        System.out.println("");
        System.out.println("Contar Nodos: " + a1.contarLaCantidadNodos());
        System.out.println("Contar Hojas: " + a1.contarHojas());
        System.out.println("Contar la cantidad de Nodo Imcpletos: " + a1.contarCantidadNodoIncompletos());
        System.out.println("Suma de Datos de Nodos: " + a1.sumar());
        System.out.println("--------------");
        a1.mostrarNivel();
        System.out.println("");

        a1.RecorrridoInOrden();
//        a1.eliminar(eliminar);
        System.out.println("");
        a1.RecorrridoInOrden();
    }

}
