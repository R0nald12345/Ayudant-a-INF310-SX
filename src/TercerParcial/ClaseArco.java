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
public class ClaseArco {
     public int valor;
    public ClaseArco prox;
    public Nodo pDest;

    public ClaseArco(Nodo pDest, int valor) {
        this.pDest = pDest;
        this.valor = valor;
        this.prox = null;
    }
}
