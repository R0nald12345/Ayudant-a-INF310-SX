/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioCadena;

/**
 *
 * @author USER
 */
public class ArbolBinarioCadena {

    public Nodo raiz;

    //Constructor
    public ArbolBinarioCadena() {
        this.raiz = null;
    }

    //insertar un dato x en el Arbol
    public void insertar(String x) {
        raiz = insertarRecursivo(raiz, x);
    }

    //Maton 
    private Nodo insertarRecursivo(Nodo nuevoRaiz, String x) {
        //caso Base
        if (nuevoRaiz == null) {
            Nodo nuevo = new Nodo(x);
            nuevoRaiz = nuevo;
            return nuevoRaiz;
//            return new NodoBinario(x);
        }

        //en el caso que nueva palabra x es identico al nodo
        if (nuevoRaiz.dato.equals(x)) {
            nuevoRaiz.frec++;
        } else {
            if (x.length() >= nuevoRaiz.dato.length()) {
                nuevoRaiz.der = insertarRecursivo(nuevoRaiz.der, x);
            } else {
                nuevoRaiz.izq = insertarRecursivo(nuevoRaiz.izq, x); // entra lado izquierdo
            }
        }// Caso General
        return nuevoRaiz;
    }

    public void RecorrridoInOrden() {
        RecorridoInOrdenRecursivo(raiz);
    }

    private void RecorridoInOrdenRecursivo(Nodo raizAuxiliar) {
        //Caso Base| Que pasa si mi arbol
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        RecorridoInOrdenRecursivo(raizAuxiliar.izq);
        System.out.println("[" + raizAuxiliar.dato + " -- " + "Frec:" + raizAuxiliar.frec + "]");
        RecorridoInOrdenRecursivo(raizAuxiliar.der);
    }
    
     public void RecorrridoMayorMenor() {
        RecorridoInOrdenRecursivo(raiz);
    }

    private void RecorridoMayorMenorRecursivo(Nodo raizAuxiliar) {
        //Caso Base| Que pasa si mi arbol
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        RecorridoInOrdenRecursivo(raizAuxiliar.der);
        System.out.println("[" + raizAuxiliar.dato + " -- " + "Frec:" + raizAuxiliar.frec + "]");
        RecorridoInOrdenRecursivo(raizAuxiliar.izq);
    }
    
    
    //Encontrar las palabras que tienen una frecuencia entre a y b inclusive.
    // 1 - 2
     public void encontrarPalabrasFrecuenciaEntreAyB(int a, int b) {
        encontrarPalabrasFrecuenciaEntreAyBRecursivo(raiz, a, b);
    }

    private void encontrarPalabrasFrecuenciaEntreAyBRecursivo(Nodo raizAuxiliar,int a,int b) {
        //Caso Base| Que pasa si mi arbol
        if (raizAuxiliar == null) {
            return;
        }
        //Caso General
        encontrarPalabrasFrecuenciaEntreAyBRecursivo(raizAuxiliar.izq,a,b);
        if(a>= raizAuxiliar.frec || raizAuxiliar.frec <=b ){
            System.out.println("[" + raizAuxiliar.dato + " -- " + "Frec:" + raizAuxiliar.frec + "]");
            
        }
        encontrarPalabrasFrecuenciaEntreAyBRecursivo(raizAuxiliar.der,a,b);
    }
}
