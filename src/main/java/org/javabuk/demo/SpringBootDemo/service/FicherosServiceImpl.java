package org.javabuk.demo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FicherosServiceImpl implements FicherosService {


    private TratamientoTextoService tratamientoTextoService;

    @Autowired
    public FicherosServiceImpl(TratamientoTextoService tratamientoTextoService) {
        this.tratamientoTextoService = tratamientoTextoService;
    }

    @Override
    public void grabarFichero(String rutaFichero, String textoFichero, Charset encoding) {
        Path path = Paths.get(rutaFichero);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.append(tratamientoTextoService.convertirStringEncoding(textoFichero,encoding)).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
