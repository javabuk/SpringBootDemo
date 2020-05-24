package org.javabuk.demo.SpringBootDemo.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FicherosServiceImpl implements FicherosService {

    @Override
    public void grabarFichero(String rutaFichero, String textoFichero, Charset encoding) {

        Path path = Paths.get(rutaFichero);
        //Creating a BufferedWriter object
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            //Appending the UTF-8 String to the file
            writer.append(textoFichero);
            //Flushing data to the file
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
