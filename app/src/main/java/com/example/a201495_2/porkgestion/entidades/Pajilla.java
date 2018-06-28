package com.example.a201495_2.porkgestion.entidades;

import java.io.Serializable;

public class Pajilla implements Serializable {
    private Integer idpajilla;
    private String fechacomprapajilla;
    private String razapajilla;
    private String nomprovepajilla;
    private String obserpajilla;

    public Pajilla(Integer idpajilla, String fechacomprapajilla, String razapajilla, String nomprovepajilla, String obserpajilla) {
        this.idpajilla = idpajilla;
        this.fechacomprapajilla = fechacomprapajilla;
        this.razapajilla = razapajilla;
        this.nomprovepajilla = nomprovepajilla;
        this.obserpajilla = obserpajilla;
    }

    public Integer getIdpajilla() {
        return idpajilla;
    }

    public void setIdpajilla(Integer idpajilla) {
        this.idpajilla = idpajilla;
    }

    public String getFechacomprapajilla() {
        return fechacomprapajilla;
    }

    public void setFechacomprapajilla(String fechacomprapajilla) {
        this.fechacomprapajilla = fechacomprapajilla;
    }

    public String getRazapajilla() {
        return razapajilla;
    }

    public void setRazapajilla(String razapajilla) {
        this.razapajilla = razapajilla;
    }

    public String getNomprovepajilla() {
        return nomprovepajilla;
    }

    public void setNomprovepajilla(String nomprovepajilla) {
        this.nomprovepajilla = nomprovepajilla;
    }

    public String getObserpajilla() {
        return obserpajilla;
    }

    public void setObserpajilla(String obserpajilla) {
        this.obserpajilla = obserpajilla;
    }
}
