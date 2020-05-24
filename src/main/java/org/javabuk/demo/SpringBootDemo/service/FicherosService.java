package org.javabuk.demo.SpringBootDemo.service;

import java.nio.charset.Charset;

public interface FicherosService {

    void grabarFichero(String rutaFichero, String textoFichero, Charset encoding);
}
