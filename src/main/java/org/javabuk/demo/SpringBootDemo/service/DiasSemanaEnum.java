package org.javabuk.demo.SpringBootDemo.service;

public enum DiasSemanaEnum {

    LUNES(2, "L"),
    MARTES(3, "M"),
    MIERCOLES(4, "X"),
    JUEVES(5, "J"),
    VIERNES(6, "V"),
    SABADO(7, "S"),
    DOMINGO(8, "D");


    private final int codigo;
    private final String dia;

    DiasSemanaEnum(int codigo, String dia){
        this.codigo=codigo;
        this.dia=dia;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getDia(){
        return this.dia;
    }

    public static DiasSemanaEnum getCorrelacion(String dia){
        for(DiasSemanaEnum diasSemana : values()){
            if(diasSemana.dia.equalsIgnoreCase(dia)){
                return diasSemana;
            }
        }
        return null;
    }
}
