/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioCadena;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {

        ArbolBinarioCadena arbol = new ArbolBinarioCadena();

        try (FileReader fr = new FileReader("D:\\Archivos Auxiliar\\AyudantiaEd2_1-2024\\AyudantiaEd2-IngVargas\\src\\ArbolBinarioCadena\\ArbolStringFrecuencia.txt")) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {

                StringTokenizer tokens = new StringTokenizer(linea);
                while (tokens.hasMoreTokens()) {
//                    System.out.println(tokens.nextToken().toLowerCase());
                    String cadenaMinuscula = tokens.nextToken().toLowerCase();
                    arbol.insertar(cadenaMinuscula);
                }
            }
            
            arbol.RecorrridoInOrden();
            System.out.println("");
            
            arbol.encontrarPalabrasFrecuenciaEntreAyB(1, 2);
//            System.out.println("Muestra de Mayor a Menor");
//            arbol.RecorrridoMayorMenor();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
