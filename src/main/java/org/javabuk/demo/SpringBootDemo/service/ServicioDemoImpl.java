package org.javabuk.demo.SpringBootDemo.service;

import org.springframework.stereotype.Service;

@Service
public class ServicioDemoImpl implements ServicioDemo{

    @Override
    public String getNombreModificado(String nombreOriginal) {
        return nombreOriginal.toUpperCase();
    }
}
