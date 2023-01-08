package com.portfoliooab.OAB.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombreEd;
    @NotNull
    private String descripcionEd;
    private String periodoEd;
    private String linkEd;
    private String imgEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String descripcionEd, String periodoEd, String linkEd, String imgEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.periodoEd = periodoEd;
        this.linkEd = linkEd;
        this.imgEd = imgEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

    public String getPeriodoEd() {
        return periodoEd;
    }

    public void setPeriodoEd(String periodoEd) {
        this.periodoEd = periodoEd;
    }

    public String getLinkEd() {
        return linkEd;
    }

    public void setLinkEd(String linkEd) {
        this.linkEd = linkEd;
    }

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }

}
