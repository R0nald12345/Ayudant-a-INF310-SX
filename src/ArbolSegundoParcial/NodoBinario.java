/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolSegundoParcial;

public class NodoBinario {
    public int dato;
    public NodoBinario izq;
    public NodoBinario der;
    
    //Contructor
    public NodoBinario(int  nuevoDato){
        this.dato = nuevoDato; //aqui se inserta el 80
        this.izq = null;
        this.der = null;
    }
    
    public int cantHijo(){
        if(izq != null || der != null){
            return 1;
        }
        if(izq == null && der == null){
            return 0;
        }
        return 2;
    }
}
