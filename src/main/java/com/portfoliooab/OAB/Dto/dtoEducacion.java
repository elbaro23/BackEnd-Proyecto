package com.portfoliooab.OAB.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;

    private String periodoEd;

    private String linkEd;

    private String imgEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String descripcionEd, String periodoEd, String linkEd, String imgEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.periodoEd = periodoEd;
        this.linkEd = linkEd;
        this.imgEd = imgEd;
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
