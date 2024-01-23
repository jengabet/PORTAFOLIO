package com.example.store_gb;


import java.io.Serializable;

public class Productos implements Serializable {


    String idproducto;
    String nomproducto;
    String desproducto;
    double precioproducto;

    public Productos(String idproducto, String nomproducto, String desproducto, double precioproducto) {
        this.idproducto = idproducto;
        this.nomproducto = nomproducto;
        this.desproducto = desproducto;
        this.precioproducto = precioproducto;
    }


    public String getIdproducto() {

        return idproducto;
    }

    public void setIdproducto(String idproducto) {

        this.idproducto = idproducto;
    }

    public String getNomproducto() {

        return nomproducto;
    }

    public void setNomproducto(String nomproducto) {

        this.nomproducto = nomproducto;

    }

    public String getDesproducto() {

        return desproducto;
    }

    public void setDesproducto(String desproducto) {

        this.desproducto = desproducto;
    }


    public double getPrecioproducto() {

        return precioproducto;
    }

    public void setPrecioproducto(double precioproducto) {

        this.precioproducto = precioproducto;
    }

}
