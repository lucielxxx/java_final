package idat.com.biblioteca.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Fecha {
    // 1. 'final' evita que alguien cree subclases que cambien el comportamiento.
//    private static final DateTimeFormatter FechaFormateada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
    private Fecha(){
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no puede ser instanciada.");
    }
    public static  LocalDateTime crearFecha(){
        return LocalDateTime.now();
    }

//    public static String obtenerFechaFormateada(){
//        return crearFecha().format(FechaFormateada);
//    }
}
