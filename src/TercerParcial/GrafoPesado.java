/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerParcial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */

public class GrafoPesado {

    public Nodo prim;
    public Nodo ult;
    public int cantNodos;

    public GrafoPesado() {
        prim = ult = null;
        this.cantNodos = 0;
    }

    public void insertarNodo(String name) {
        if (!seEncuentra(name)) {
            insertarUlt(name);
        }
    }

    public boolean seEncuentra(String name) {
        return buscar(name) != null;
    }

    public Nodo buscar(String name) {
        Nodo aux = prim;
        while (aux != null) {
            if (aux.name.equals(name)) {  // ==
                return aux;
            }
            aux = aux.prox;
        }
        return null;
    }

    public void insertarUlt(String name) {
        Nodo nuevoNodo = new Nodo(name, null);
        if (prim == null) { //en el caso de que nuestro lista de vertices Esta Vacio
            prim = nuevoNodo;
            ult = prim;
        } else {
            ult.prox = nuevoNodo;
            ult = nuevoNodo;
        }
        cantNodos++;
    }

    public void insertarArco(String name1, String name2, int valor) {
        
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        
        if(pOrigen == null){
            insertarNodo(name1);
            insertarArco(name1,name2, valor);
            return;
        }
        
        if(pDest == null){
            insertarNodo(name2);
            insertarArco(name1,name2, valor);
            return;
        }
        
        ClaseArco nuevoArco = new ClaseArco(pDest, valor);
        
        if(pOrigen.primArco == null){ //si estaba Vacio mi lista de Arcos
            pOrigen.primArco = nuevoArco;
            pOrigen.ultArco = nuevoArco;
        }else{
            pOrigen.ultArco.prox = nuevoArco;
            pOrigen.ultArco = nuevoArco;
        }
        pOrigen.cantArco++; 
    }

    public void mostrar(){
        Nodo auxVer = prim;
        while(auxVer != null){
            System.out.print(auxVer.name + ":");
            ClaseArco arcoAux = auxVer.primArco; 
            while(arcoAux != null){
                System.out.print( arcoAux.pDest.name + "(" + arcoAux.valor+")");
                arcoAux = arcoAux.prox;
            }
            System.out.println("");
            auxVer = auxVer.prox;
        }
    }
    
    //Obtener el Mayor Valor de un Arco
    public int mostrarMayorValorDelArco(){
        int valor = 0;
        Nodo auxVer = prim;
        while(auxVer != null){
            ClaseArco auxArco = auxVer.primArco;
            while(auxArco != null){
                if(auxArco.valor > valor){
                    valor = auxArco.valor;
                }
                auxArco = auxArco.prox;
            }
            auxVer = auxVer.prox;
        }
        return valor;
    }
    
    public int mostrarMenorValorDelArco(){
        int valor = 1000;
        Nodo auxVer = prim;
        while(auxVer != null){
            ClaseArco auxArco = auxVer.primArco;
            while(auxArco != null){
                if(auxArco.valor < valor){
                    valor = auxArco.valor;
                }
                auxArco = auxArco.prox;
            }
            auxVer = auxVer.prox;
        }
        return valor;
    }
    
    public int cantidadDeLlegadas(String name1){ //Name1 = B
        int contador = 0;
        Nodo auxVer = prim;
        while(auxVer != null){
            ClaseArco auxArco = auxVer.primArco;
             while(auxArco != null){
                 if(auxArco.pDest.name.equals(name1) ){
                     contador++;
                 }
                 auxArco = auxArco.prox;
             }
            auxVer = auxVer.prox;
        }
        return contador;
               
    }
    
    
    //Algoritmos de B A C K T R A C K I N G
    //MOstar la cantidad de Caminos(name1,name2);
    //Metodo que muestra todos los caminos posibles desde el nodo name1 hasta name2
    //Sugerencia ustiliazr una lista de caminos de recorridos
    // Método que muestra todos los caminos posibles desde el nodo name1 hasta name2
    public void mostrarCaminos(String name1, String name2) {
        // Busca el nodo de origen y el nodo de destino en el grafo
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);

        // Si alguno de los nodos no se encuentra en el grafo, no se hace nada
        if (pOrigen == null || pDest == null) {
            return;
        }

        // Lista para almacenar el camino actual
        LinkedList<Nodo> caminoActual = new LinkedList<>();

        // Añadir el nodo de origen al camino actual
        caminoActual.add(pOrigen);

        // Llamar al método recursivo para encontrar todos los caminos
        caminos(caminoActual, pOrigen, pDest);
    }

// Método recursivo para encontrar y mostrar todos los caminos desde pOrigen hasta pDest
    private void caminos(LinkedList<Nodo> caminoActual, Nodo pOrigen, Nodo pDest) {
        // Si el nodo de origen es igual al nodo de destino, se ha encontrado un camino completo
        if (pOrigen.equals(pDest)) {
            mostrarCamino(caminoActual); // Mostrar el camino encontrado
            return; // Terminar la recursión para esta rama
        }

        // Explorar todos los arcos salientes del nodo de origen
        ClaseArco arcoActual = pOrigen.primArco;
        while (arcoActual != null) {
            // Si el nodo destino del arco actual no está ya en el camino actual (para evitar ciclos)
            if (!caminoActual.contains(arcoActual.pDest)) {
                // Añadir el nodo destino del arco al camino actual
                caminoActual.add(arcoActual.pDest);

                // Llamar recursivamente para continuar buscando desde el nuevo nodo añadido
                caminos(caminoActual, arcoActual.pDest, pDest);

                // Después de la recursión, eliminar el último nodo añadido para volver a explorar otros caminos
                caminoActual.removeLast();
            }

            // Pasar al siguiente arco en la lista de arcos del nodo de origen
            arcoActual = arcoActual.prox;
        }
    }

// Método para mostrar un camino almacenado en una lista
    private void mostrarCamino(LinkedList<Nodo> camino) {
        // Recorrer todos los nodos en la lista y mostrar sus nombres
        for (Nodo nodo : camino) {
            System.out.print(nodo.name + " ");
        }
        System.out.println(); // Nueva línea al final del camino
    }

//**************
// Método que devuelve la cantidad de caminos que existen desde el nodo name1 hasta name2
    public int cantidadCaminos(String name1, String name2) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null || pDest == null) {
            return 0;
        }
        return contarCaminos(new LinkedList<>(), pOrigen, pDest);
    }

    private int contarCaminos(LinkedList<Nodo> caminoActual, Nodo pOrigen, Nodo pDest) {
        if (pOrigen.equals(pDest)) {
            return 1; // Se ha encontrado un camino
        }

        int count = 0;
        ClaseArco arcoActual = pOrigen.primArco;
        while (arcoActual != null) {
            if (!caminoActual.contains(arcoActual.pDest)) {
                caminoActual.add(arcoActual.pDest);
                count += contarCaminos(caminoActual, arcoActual.pDest, pDest);
                caminoActual.removeLast(); // Retroceder
            }
            arcoActual = arcoActual.prox;
        }
        return count;
    }

//******************
// Método que muestra todos los caminos desde name1 a name2 con su costos totales
    public void mostrarTotalCamino(String name1, String name2) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null || pDest == null) {
            return;
        }
        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(pOrigen);
        mostrarCaminosConCosto(caminoActual, pOrigen, pDest, 0);
    }

    private void mostrarCaminosConCosto(LinkedList<Nodo> caminoActual, Nodo pOrigen, Nodo pDest, int costo) {
        if (pOrigen.equals(pDest)) {
            mostrarCaminoConCosto(caminoActual, costo);
            return;
        }

        ClaseArco arcoActual = pOrigen.primArco;
        while (arcoActual != null) {
            if (!caminoActual.contains(arcoActual.pDest)) {
                caminoActual.add(arcoActual.pDest);
                mostrarCaminosConCosto(caminoActual, arcoActual.pDest, pDest, costo + arcoActual.valor);
                caminoActual.removeLast(); // Retroceder
            }
            arcoActual = arcoActual.prox;
        }
    }

    private void mostrarCaminoConCosto(LinkedList<Nodo> camino, int costo) {
        for (Nodo nodo : camino) {
            System.out.print(nodo.name + " ");
        }
        System.out.println("Costo: " + costo);
    }

//**
// Método que muestra los caminos de menor cantidad de arcos desde name1 a name2
    public void menorArcos(String name1, String name2) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null || pDest == null) {
            return;
        }
        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(pOrigen);
        List<LinkedList<Nodo>> todosLosCaminos = new ArrayList<>();
        buscarTodosLosCaminos(caminoActual, pOrigen, pDest, todosLosCaminos);

        // Encontrar el menor número de arcos
        int menorArcos = Integer.MAX_VALUE;
        for (LinkedList<Nodo> camino : todosLosCaminos) {
            menorArcos = Math.min(menorArcos, camino.size());
        }

        // Mostrar todos los caminos con el menor número de arcos
        for (LinkedList<Nodo> camino : todosLosCaminos) {
            if (camino.size() == menorArcos) {
                mostrarCamino(camino);
            }
        }
    }

    private void buscarTodosLosCaminos(LinkedList<Nodo> caminoActual, Nodo pOrigen, Nodo pDest, List<LinkedList<Nodo>> todosLosCaminos) {
        if (pOrigen.equals(pDest)) {
            todosLosCaminos.add(new LinkedList<>(caminoActual));
            return;
        }

        ClaseArco arcoActual = pOrigen.primArco;
        while (arcoActual != null) {
            if (!caminoActual.contains(arcoActual.pDest)) {
                caminoActual.add(arcoActual.pDest);
                buscarTodosLosCaminos(caminoActual, arcoActual.pDest, pDest, todosLosCaminos);
                caminoActual.removeLast(); // Retroceder
            }
            arcoActual = arcoActual.prox;
        }
    }

// Método que muestra los caminos de menor costo desde name1 a name2
    public void menorCosto(String name1, String name2) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null || pDest == null) {
            return;
        }
        LinkedList<Nodo> caminoActual = new LinkedList<>();
        caminoActual.add(pOrigen);
        List<LinkedList<Nodo>> todosLosCaminos = new ArrayList<>();
        List<Integer> costos = new ArrayList<>();
        buscarTodosLosCaminosConCosto(caminoActual, pOrigen, pDest, todosLosCaminos, costos, 0);

        // Encontrar el menor costo
        int menorCosto = Integer.MAX_VALUE;
        for (int costo : costos) {
            menorCosto = Math.min(menorCosto, costo);
        }

        // Mostrar todos los caminos con el menor costo
        for (int i = 0; i < todosLosCaminos.size(); i++) {
            if (costos.get(i) == menorCosto) {
                mostrarCaminoConCosto(todosLosCaminos.get(i), costos.get(i));
            }
        }
    }

    private void buscarTodosLosCaminosConCosto(LinkedList<Nodo> caminoActual, Nodo pOrigen, Nodo pDest, List<LinkedList<Nodo>> todosLosCaminos, List<Integer> costos, int costoActual) {
        if (pOrigen.equals(pDest)) {
            todosLosCaminos.add(new LinkedList<>(caminoActual));
            costos.add(costoActual);
            return;
        }

        ClaseArco arcoActual = pOrigen.primArco;
        while (arcoActual != null) {
            if (!caminoActual.contains(arcoActual.pDest)) {
                caminoActual.add(arcoActual.pDest);
                buscarTodosLosCaminosConCosto(caminoActual, arcoActual.pDest, pDest, todosLosCaminos, costos, costoActual + arcoActual.valor);
                caminoActual.removeLast(); // Retroceder
            }
            arcoActual = arcoActual.prox;
        }
    }
    
}
