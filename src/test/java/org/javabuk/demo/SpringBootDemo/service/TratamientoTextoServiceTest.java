package org.javabuk.demo.SpringBootDemo.service;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static org.assertj.core.api.Assertions.assertThat;

import static java.nio.charset.StandardCharsets.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = {TratamientoTextoServiceImpl.class})
class TratamientoTextoServiceTest {

    @Autowired
    private TratamientoTextoService tratamientoTextoService;

    @Test
    @DisplayName("prueba convertir texto a UTF-8")
    void pruebaConvertirTextoAUtf8() {
        String textoOriginal = "Demagogía o demagogia";
        String cadentaTextoEncoding = tratamientoTextoService.convertirStringEncoding(textoOriginal, UTF_8);
        boolean comprobarEncoding = tratamientoTextoService.comprobarEncoding(textoOriginal, cadentaTextoEncoding, UTF_8);

        assertThat(comprobarEncoding).isTrue();
    }

    @Test
    @DisplayName("prueba validacion Texto No Valida")
    void pruebaValidacionTextoNoValida() {
        String textoOriginal = "Demagogía o demagogia";
        String cadentaTextoEncoding = tratamientoTextoService.convertirStringEncoding(textoOriginal, ISO_8859_1);
        boolean comprobarEncoding = tratamientoTextoService.comprobarEncoding(textoOriginal, cadentaTextoEncoding, UTF_8);

        assertThat(comprobarEncoding).isFalse();
    }

    @Test
    @DisplayName("Prueba Recuperar Encoding")
    void pruebaRecuperarEncoding() throws IOException {
        String textoOriginal = "Demagogía o demagogia";
        String cadentaTextoEncodingUTF8 = tratamientoTextoService.convertirStringEncoding(textoOriginal, UTF_8);
        String cadentaTextoEncodingISO88591 = tratamientoTextoService.convertirStringEncoding(textoOriginal, ISO_8859_1);
        String charSetCadenaUTF8 = tratamientoTextoService.getCharset(cadentaTextoEncodingUTF8);
        String charSetCadenaISO88591 = tratamientoTextoService.getCharset(cadentaTextoEncodingISO88591);
        assertThat(charSetCadenaUTF8).isEqualTo("UTF8");
        assertThat(charSetCadenaISO88591).isEqualTo("ISO88591");
    }

}