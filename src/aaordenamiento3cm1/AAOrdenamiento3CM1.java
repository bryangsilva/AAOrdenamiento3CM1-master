/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import algoritmos.Burbuja;
import algoritmos.BurbujaOptimizado;
import herramientas.Datos;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AAOrdenamiento3CM1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //double [] datos = new double[]{6,5,3,1,8,7,2,4};
        ArrayList<Double> tiempo =new ArrayList<>();
        ArrayList<Double> comparaciones =new ArrayList<>();
        ArrayList<Double> tiempo2 =new ArrayList<>();
        ArrayList<Double> comparaciones2 =new ArrayList<>();
        for(int i=5000;i<50000;i+=5000){
        double [] datos =herramientas.Datos.generarDatosAleatorios(i, 100);
        
       
        double [] datos3 = datos.clone();
        Burbuja b1 = new Burbuja();
        b1.ordenar(datos);
        BurbujaOptimizado b2 = new BurbujaOptimizado();
        b2.ordenar(datos3);
        tiempo.add(b1.getTiempo_total());
        tiempo2.add(b2.getTiempo_total());
        comparaciones.add(b1.getComparaciones());
        comparaciones2.add(b2.getTiempo_total());
        }
        Grafica grafica =new Grafica("La grafique","y","x");
        grafica.agregar(tiempo,comparaciones, Burbuja.class.getSimpleName());
        grafica.agregar(tiempo2,comparaciones2, BurbujaOptimizado.class.getSimpleName());
        
        grafica.creaYmuestraGrafica();
    }
   
}
