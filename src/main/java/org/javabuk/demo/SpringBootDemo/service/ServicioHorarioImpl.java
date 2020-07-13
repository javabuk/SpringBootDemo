package org.javabuk.demo.SpringBootDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServicioHorarioImpl implements  ServicioHorario{

    @Override
    public boolean cumpleCondiciones(String condicionDiaria, Date fecha) {
        // Comprobamos si viene más de una condición

        List<String> condicionesDiarias = obtenerCondiciones(condicionDiaria);

        String [] diasCondicion = null;
        boolean validacion = true;
        for (String condicion: condicionesDiarias) {
            // Validamos condición diaria

            validacion = condicion.matches("L|M|X|J|V|S|D|-");

            if(!validacion){
                // Si no cumple la condición salimos de las validaciones
                return false;
            }

            if(condicion.startsWith("-") || condicion.endsWith("-") ){
                validacion = false;
            }

            if(!validacion){
                // Si no cumple la condición salimos de las validaciones
                return false;
            }

            diasCondicion = condicion.split("-");

            validacion = validarCondiciones(diasCondicion, fecha);
            if(!validacion){
                // Si no cumple la condición salimos de las validaciones
                return false;
            }
        }

        return true;

        // Validamos el formato de la condicion
        /*
         Días semana sueltos: Empiezan por S=
         L - Lunes (2)
         M - Martes (3)
         X - Miercoles (4)
         J - Jueves (5)
         V - Viernes (6)
         S - Sabado (7)
         D - Domingo (1)
         Agrupación de días, con guion
         L-M : Lunes y martes
         M-X-V : Martes, miércoles y viernes

         Agrupación días seguidos
         L=V : De lunes a viernes
         V=D : De viernes a domingo

         Ejemplos
         S=L:V
         S=L-S-D
         Varios:
         S=L:V#S:X

        Días concretos en el año empiezan por D=
        Se indica el formato en  DD/MM
        Ejemplo:
        D=06/01   // El 6 de enero
        D=31/12   // El 31 de diciembre
        Varias condiciones
        D=06/02#D=10/03

        Días concretos del mes, empiezan por M=
        Ejemplo:
        M=01 - El día 1 de todos los meses
        M=15 - El día 15 de todos los meses

        Varias condiciones
        M=01#M=1

        Validar que las condiciones son correctas
        * Que se introducen las letras de los días correctos
        * que los días y meses son válidos (que no sean menores de 1, que los meses no sean mayores de 12 y que los días no sean mayores de 31

        */


        // Comprobamos si cumple la condición
        /*
        * Recuperar los datos de la fecha en cada caso:
        * Día de la semana
        * Día del més
        * Mes
        *
        * */


    }

    private List<String> obtenerCondiciones(String condicionDiaria) {
         /*
        Comprobar que viene el caracter #, es el que utilizamos en las condiciones para representar la operación OR
        * */
        List<String> condicionesDiarias = new ArrayList<>();
        if(condicionDiaria.contains("#")){
            String [] arrCondiciones = condicionDiaria.split("#");
            condicionesDiarias = Arrays.asList(arrCondiciones);
        }else{
            condicionesDiarias.add(condicionDiaria);
        }
        return condicionesDiarias;
    }


    private boolean validarCondiciones(String [] condiciones, Date fecha){
        boolean resultado = false;
        int diaSemana = 0;
        try {
            diaSemana = obtenerDiaSemana(fecha);
        } catch (ParseException e) {
            return false;
        }
        for (String condicion : condiciones) {
            //TODO: Comprobar si es nulo o no
            if(DiasSemanaEnum.getCorrelacion(condicion).getCodigo()==diaSemana){
                return true;
            }
        }
        return resultado;
    }

    private int obtenerDiaSemana(Date fecha) throws ParseException {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        return calendario.get(Calendar.DAY_OF_WEEK);
    }

}
