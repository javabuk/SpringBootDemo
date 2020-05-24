package org.javabuk.demo.SpringBootDemo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = {FicherosServiceImpl.class})
public class FicherosServiceTest {

    @Autowired
    FicherosService ficherosService;

    @Test
    @DisplayName("prueba generacion fichero")
    void pruebaGeneracionFichero() {
        ficherosService.grabarFichero("D:\\samplefile.txt",
                "Demagogía o demagogia",
                StandardCharsets.UTF_8);
        Path path = Paths.get("D:\\samplefile.txt");
        assertTrue(Files.exists(path));
    }

    @Test
    @DisplayName("pruebaGeneracionFicheroISO88591")
    void pruebaGeneracionFicheroIso88591() {
        String rutaFichero = "D:\\samplefileISO88591.txt";
        ficherosService.grabarFichero( rutaFichero,
                "panadería",
                StandardCharsets.ISO_8859_1);
        Path path = Paths.get(rutaFichero);
        assertTrue(Files.exists(path));
    }
}
