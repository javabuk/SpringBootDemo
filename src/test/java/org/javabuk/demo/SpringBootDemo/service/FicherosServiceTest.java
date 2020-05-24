package org.javabuk.demo.SpringBootDemo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = {FicherosServiceImpl.class})
public class FicherosServiceTest {

    @Autowired
    FicherosService ficherosService;

    @MockBean
    TratamientoTextoService tratamientoTextoService;

    @Test
    @DisplayName("prueba generacion fichero")
    void pruebaGeneracionFichero() throws IOException {
        ficherosService.grabarFichero("D:\\samplefile.txt",
                "Demagogía o demagogia",
                StandardCharsets.UTF_8);
        Path path = Paths.get("D:\\samplefile.txt");
        assertTrue(Files.exists(path));
        String charset = getCharset("D:\\samplefile.txt");
        assertThat(charset).isEqualTo("UTF8");
    }

    @Test
    @DisplayName("pruebaGeneracionFicheroISO88591")
    void pruebaGeneracionFicheroIso88591() throws IOException {
        String rutaFichero = "D:\\samplefileISO88591.txt";
        ficherosService.grabarFichero( rutaFichero,
                "panadería",
                StandardCharsets.ISO_8859_1);
        Path path = Paths.get(rutaFichero);
        assertTrue(Files.exists(path));
        String charset = getCharset(rutaFichero);
        //assertThat(charset).withFailMessage("No coincide el encoding del fichero con el esperado").isEqualTo("ISO88591");
        assertThat(charset).isEqualTo("ISO88591");
    }

    private String getCharset(String rutaFichero) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        String s = null;

        try {
            // new input stream reader is created
            fis = new FileInputStream(rutaFichero);
            isr = new InputStreamReader(fis);

            // the name of the character encoding returned
            s = isr.getEncoding();
            System.out.print("Character Encoding: "+s);

        } catch (Exception e) {
            // print error
            System.out.print("The stream is already closed");
        } finally {
            // closes the stream and releases resources associated
            if(fis!=null)
                fis.close();
            if(isr!=null)
                isr.close();
        }
        return s;
    }
}
