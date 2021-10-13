package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception {

    public ExcepcionServiciosAlquiler(String m){
        super(m);
    }
    public ExcepcionServiciosAlquiler(String m, Exception ex){
        super(m, ex);
    }
}
