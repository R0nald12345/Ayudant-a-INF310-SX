/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerParcial;

public class Nodo {
    public String name;
    public Nodo prox;
    public ClaseArco primArco;
    public ClaseArco ultArco;
    public int cantArco;
    
    public Nodo(String name, Nodo prox){
        this.name = name;
        this.prox = prox;
        primArco = ultArco = null;
        cantArco = 0;
    }
}
