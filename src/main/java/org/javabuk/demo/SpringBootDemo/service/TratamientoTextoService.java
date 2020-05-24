package org.javabuk.demo.SpringBootDemo.service;

import java.io.IOException;
import java.nio.charset.Charset;

public interface TratamientoTextoService {

    /**
     * Método que convierte una cadena de texto con un encoding determinado.
     * @param cadenaTexto
     * @param encoding UTF-8, ISO-8859-1,,,
     * @return La cadena de texto con el formato escogido.
     */
    String convertirStringEncoding(String cadenaTexto, Charset encoding);

    /**
     * Método que comprueba si la cadena texto tiene un encoding concreto.
     * @param cadenaTextoOriginal
     * @param cadenatextoEncoding
     * @param encodingEsperado
     * @return
     */
    boolean comprobarEncoding(String cadenaTextoOriginal, String cadenatextoEncoding, Charset encodingEsperado);

    /**
     * Método que recupera el encoding de una cadena de texto
     * @param rutaFichero
     * @return
     * @throws IOException
     */
    String getCharset(String rutaFichero) throws IOException;

}
