package co.jmurillo.encuentratuvuelo.list;

import co.jmurillo.encuentratuvuelo.models.SistemaVuelos;
import co.jmurillo.encuentratuvuelo.models.Vuelo;

public class VuelosCargados {
    public static void main(String[] args) {
        SistemaVuelos sistema = new SistemaVuelos();
        sistema.cargarVuelos();

        // Imprimir los vuelos cargados
        System.out.println("Vuelos Cargados:");
        for (Vuelo vuelo: sistema.getVuelos()){
            System.out.println(vuelo);
        }

        System.out.println("===============");

        // Ordenar y mostrar los vuelos
        //System.out.println("Vuelos ordenados por fecha de llegada:");
        //sistema.ordenarVuelosPorllegada();
        //for (Vuelo vuelo: sistema.getVuelos()){
        //    System.out.printf("%s - %s\\n",
        //            vuelo.getNombre(),
        //            sistema.formatoFecha.format(vuelo.getFechaLlegada())); formatoFecha es privado por eso no lo puedo implementar en el main.
        //            lo podemos poner publico pero nuestra app pierde seguridad
        //}
        sistema.ordenarMostrar(); // Otra forma de hacerlo.

        // Mostrar resultados finales
        sistema.mostrarResultados();
    }
}
