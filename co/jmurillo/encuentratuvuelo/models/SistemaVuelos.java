package co.jmurillo.encuentratuvuelo.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SistemaVuelos {
    private List<Vuelo> vuelos;
    private SimpleDateFormat formatoFecha;

    public SistemaVuelos() {
        vuelos = new ArrayList<>();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    public void cargarVuelos() {
        try {
            // Cargamos los vuelos según la tabla
            vuelos.add(new Vuelo("AAL 933", "New York", "Santiago",
                    formatoFecha.parse("29/08/2021 05:39"), 62));
            vuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago",
                    formatoFecha.parse("31/08/2021 04:45"), 47));
            vuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago",
                    formatoFecha.parse("30/08/2021 16:00"), 52));
            vuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago",
                    formatoFecha.parse("29/08/2021 13:22"), 59));
            vuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago",
                    formatoFecha.parse("31/08/2021 14:05"), 25));
            vuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago",
                    formatoFecha.parse("31/08/2021 05:20"), 29));
            vuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago",
                    formatoFecha.parse("30/08/2021 08:45"), 55));
            vuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago",
                    formatoFecha.parse("29/08/2021 07:41"), 51));
            vuelos.add(new Vuelo("SKU 803", "Lima", "Santiago",
                    formatoFecha.parse("30/08/2021 10:35"), 48));
            vuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago",
                    formatoFecha.parse("29/08/2021 09:14"), 59));
            vuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago",
                    formatoFecha.parse("31/08/2021 08:33"), 31));
            vuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago",
                    formatoFecha.parse("31/10/2024 15:15"), 29));
            vuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago",
                    formatoFecha.parse("30/08/2021 08:14"), 47));
            vuelos.add(new Vuelo("AAL 957", "Miami", "Santiago",
                    formatoFecha.parse("29/08/2021 22:53"), 60));
            vuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago",
                    formatoFecha.parse("31/08/2021 09:57"), 32));

        } catch (ParseException e){
            System.out.println("Error al parsear la fecha: " + e.getMessage());
        }
    }
    // Método para obtener la lista de vuelos
    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    // Método para ordenar vuelos por fecha de llegada (ascendente)
    public void ordenarVuelosPorllegada() {
        Collections.sort(vuelos, new Comparator<Vuelo>() {
            @Override
            public int compare(Vuelo v1, Vuelo v2){
                return v1.getFechaLlegada().compareTo(v2.getFechaLlegada());
            }
        });
        // Alternativa usando lambda (Java 8+)
        // vuelos.sort((v1, v2) -> v1.getFechaLlegada().compareTo(v2.getFechaLlegada()));
    }

    // Método para obtener el último vuelo en llegar
    public Vuelo obtenerUltimoVuelo() {
        return Collections.max(vuelos, Comparator.comparing(Vuelo::getFechaLlegada));
    }

    // Método para obtener el vuelo con menor número de pasajeros
    public Vuelo obtenerVueloMenosPasajeros() {
        return Collections.min(vuelos, Comparator.comparing(Vuelo::getCantidadPasajeros));
    }

    // Ordenar y mostrar los vuelos
    public void ordenarMostrar() {
        System.out.println("\nVuelos ordenados por fecha de llegada:");
        vuelos.stream()
                .sorted(Comparator.comparing(Vuelo::getFechaLlegada))
                .forEach(vuelo -> System.out.printf("%s - %s\n",
                        vuelo.getNombre(),
                        formatoFecha.format(vuelo.getFechaLlegada())));
    }

    // Método para mostrar la información en el formato requerido
    public void mostrarResultados(){
        System.out.println("\nÚltimo vuelo en llegar:");
        Vuelo ultimo = obtenerUltimoVuelo();
        System.out.printf("El último vuelo en llegar es %s, aterriza el %s\\n",
                ultimo.getNombre(),
                formatoFecha.format(ultimo.getFechaLlegada()));

        System.out.println("\nVuelo con menos pasajeros:");
        Vuelo menosPasajeros = obtenerVueloMenosPasajeros();
        System.out.printf("El vuelo con menor número de pasajeros es %s con %d pasajeros\\n",
                menosPasajeros.getNombre(),
                menosPasajeros.getCantidadPasajeros());
    }

}
