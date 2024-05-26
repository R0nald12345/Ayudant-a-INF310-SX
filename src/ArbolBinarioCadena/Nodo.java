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
public class Nodo {
    public String dato;
    public int frec;
    public Nodo izq;
    public Nodo der;
    
    //Contructor
    public Nodo(String  nuevoDato){
        this.dato = nuevoDato; //aqui se inserta el 80
        this.frec = 1;
        this.izq = null;
        this.der = null;
    }
}
