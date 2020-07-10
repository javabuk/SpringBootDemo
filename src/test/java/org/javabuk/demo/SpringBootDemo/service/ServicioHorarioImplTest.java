package org.javabuk.demo.SpringBootDemo.service;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ServicioHorarioImplTest {

    @Test
    public void probarFechas(){



        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "04-07-2020 11:35:42";
        try {
            Date newdate = dateformat2.parse(strdate2);

            Calendar calendario = Calendar.getInstance();
            calendario.setTime(newdate);
            int i = calendario.get(Calendar.DAY_OF_WEEK);
            System.out.println(i);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void probarValidacionNoCumple(){
        ServicioHorarioImpl servicio = new ServicioHorarioImpl();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "04-07-2020 11:35:42";
        try {
            Date newdate = dateformat2.parse(strdate2);
            boolean resultado = servicio.cumpleCondiciones("L", newdate);
            assertTrue(resultado);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void probarValidacionCumple(){
        ServicioHorarioImpl servicio = new ServicioHorarioImpl();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "04-07-2020 11:35:42";
        try {
            Date newdate = dateformat2.parse(strdate2);
            boolean resultado = servicio.cumpleCondiciones("S", newdate);
            assertTrue(resultado);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public String getDay(String day, String month, String year) {
        return LocalDate.of(
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day)
        ).getDayOfWeek().toString();
    }

}