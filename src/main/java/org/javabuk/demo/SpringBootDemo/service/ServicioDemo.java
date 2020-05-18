package org.javabuk.demo.SpringBootDemo.service;

/**
 * Interaface que define las funcionalidades del Servicio Demo
 */
public interface ServicioDemo {

    /**
     * Método que transforma un nombre en mayúsulas
     * @param nombreOriginal
     * @return Cadena de texto transformada en mayúsculas
     */
    String getNombreModificado(String nombreOriginal);

}
