package org.javabuk.demo.SpringBootDemo.controller;

import org.javabuk.demo.SpringBootDemo.service.ServicioDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ControllerDemo {

    @Autowired
    ServicioDemo servicio;

    @GetMapping("mayusculas/{cadena}")
    public String ponerEnMayuscula(@PathVariable String cadena){
        return servicio.getNombreModificado(cadena);
    }
}
