/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartPanel;
import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class Grafica {
    // grafica
    private JFreeChart grafica;
    // coleccion de series
    private XYSeriesCollection series;
    private String nombre,tituloEjeX,tituloEjeY;

    public Grafica(String nombre,String ty,String tx) {
     this.grafica = null;
     this.series = new XYSeriesCollection();
     this.nombre = nombre;
     this.tituloEjeX = tx;
     this.tituloEjeY = ty;
    
    }
    
    public void agregar (ArrayList<Double> tiempo,ArrayList<Double> comparaciones, String nombreSerie){
       // instanciamos la serie
        XYSeries serie = new XYSeries(nombreSerie);
        // recorrer los datos para agregarlos a la serie
        for (int x = 0 ; x < tiempo.size();x++){
         serie.add(comparaciones.get(x),tiempo.get(x));
      }
     // agregamos al serie a la coleccion de series
     this.series.addSeries(serie);
    }
    
    public void creaYmuestraGrafica(){
    
        this.grafica = ChartFactory.createXYLineChart(nombre, tituloEjeX, tituloEjeY, series);
        // utilizar un panel especial dentro de jfreechart
        ChartFrame panel = new ChartFrame("grafica",grafica);
        panel.pack();
        panel.setVisible(true);
        
        
    }
}
