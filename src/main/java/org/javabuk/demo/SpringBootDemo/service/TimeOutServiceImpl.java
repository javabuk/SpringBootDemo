package org.javabuk.demo.SpringBootDemo.service;

import org.javabuk.demo.SpringBootDemo.aspects.TimeOut;
import org.springframework.stereotype.Service;

@Service
public class TimeOutServiceImpl implements  TimeOutService {

    @Override
    @TimeOut
    public String metodoPrueba(String cadenaTexto) {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cadenaTexto.toUpperCase();
    }
}
