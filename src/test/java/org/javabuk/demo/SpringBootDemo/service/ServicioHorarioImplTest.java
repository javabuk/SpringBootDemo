package org.javabuk.demo.SpringBootDemo.service;

import org.assertj.core.api.BooleanArrayAssert;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            assertTrue(!resultado);
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

    @Test
    public void probarValidacionCompuestaCumple(){
        ServicioHorarioImpl servicio = new ServicioHorarioImpl();
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strdate2 = "04-07-2020 11:35:42";
        try {
            Date newdate = dateformat2.parse(strdate2);
            boolean resultado = servicio.cumpleCondiciones("S#L-S#X-S-V", newdate);
            assertTrue(resultado);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void pruebaMatch(){
        String condicion = "L-X";
        Pattern pattern = Pattern.compile("L|M|-");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(condicion);

        boolean busqueda = matcher.find();
        boolean resultado = matcher.matches();
        assertTrue(resultado);
        assertTrue(busqueda);

    }


    public String getDay(String day, String month, String year) {
        return LocalDate.of(
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day)
        ).getDayOfWeek().toString();
    }

}