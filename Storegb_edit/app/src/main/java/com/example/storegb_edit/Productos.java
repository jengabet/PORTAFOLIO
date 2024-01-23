package com.example.storegb_edit;

import java.io.Serializable;

public class Productos implements Serializable {

    String ropa;
    String descri;
    double precioproducto;


    public Productos(String ropa, String descri, double precioproducto) {
        this.ropa = ropa;
        this.descri = descri;
        this.precioproducto = precioproducto;
    }

    public String getRopa(){

        return ropa;
    }

    public void setRopa(String ropa){

        this.ropa = ropa;
    }

    public String getDescri(){

        return descri;
    }

    public void setDescri(){

        this.descri = descri;
    }

    public double getPrecioproducto() {

        return precioproducto;
    }

    public void setPrecioproducto(double precioproducto) {

        this.precioproducto = precioproducto;
    }

}
