package org.javabuk.demo.SpringBootDemo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = {ServicioDemoImpl.class})
class ServicioDemoTest {

    @Autowired
    ServicioDemo servicio;

    @Test
    @DisplayName("Metodo de prueba Nombre Modificado")
    void metodoDePruebaNombreModificado() {

    }

}