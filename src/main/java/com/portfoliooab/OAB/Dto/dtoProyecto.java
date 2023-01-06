package com.portfoliooab.OAB.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    
    private String periodoP;
    
    private String linkP;
    
    private String imgP;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String periodoP, String linkP, String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.periodoP = periodoP;
        this.linkP = linkP;
        this.imgP = imgP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getPeriodoP() {
        return periodoP;
    }

    public void setPeriodoP(String periodoP) {
        this.periodoP = periodoP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

}