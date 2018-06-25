package com.example.a201495_2.porkgestion.entidades;

import java.io.Serializable;

public class Usuario implements  Serializable{


    private Integer id;
    private String nombre;
    private String fechanace;
    private Integer pesonace;
    private String sexo;
    private String raza;
    private String nombremadre;
    private String nombrepadre;
    private String nuevaraza;
    private Integer idnuevaraza;
    private Integer idanimalventa;
    private String nombreventa;
    private String fechaventa;
    private Integer pesoventa;
    private Integer precioventa;
    private Integer idanimonta;
    private String nombremonta;
    private Integer edadmonta;
    private Integer pesomonta;
    private String fecha1celo;
    private String fecha2celo;
    private String tipoprenez;
    private String nomverraco;
    private Integer numpajilla;
    private String fechaeco;



    public Usuario(Integer id, String nombre, String fechanace, Integer pesonace, String sexo, String raza,
                   String nombremadre, String nombrepadre, String nuevaraza, Integer idnuevaraza,Integer idanimalventa,
                   String nombreventa, String fechaventa, Integer pesoventa, Integer precioventa,
                   Integer idanimonta, String nombremonta, Integer edadmonta, Integer pesomonta, String fecha1celo, String fecha2celo,
                   String tipoprenez, String nomverraco, Integer numpajilla, String fechaeco) {
        this.id = id;
        this.nombre = nombre;
        this.fechanace = fechanace;
        this.pesonace = pesonace;
        this.sexo = sexo;
        this.raza = raza;
        this.nombremadre = nombremadre;
        this.nombrepadre = nombrepadre;
        this.nuevaraza = nuevaraza;
        this.idnuevaraza = idnuevaraza;
        this.idanimalventa = idanimalventa;
        this.nombreventa = nombreventa;
        this.fechaventa = fechaventa;
        this.pesoventa = pesoventa;
        this.precioventa = precioventa;
        this.idanimonta = idanimonta;
        this.nombremonta = nombremonta;
        this.edadmonta = edadmonta;
        this.pesomonta = pesomonta;
        this.fecha1celo = fecha1celo;
        this.fecha2celo = fecha2celo;
        this.tipoprenez = tipoprenez;
        this.nomverraco = nomverraco;
        this.numpajilla = numpajilla;
        this.fechaeco = fechaeco;


    }

    public Usuario(){

        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanace() {
        return fechanace;
    }

    public void setFechanace(String fechanace) {
        this.fechanace = fechanace;
    }

    public Integer getPesonace() {
        return pesonace;
    }

    public void setPesonace(Integer pesonace) {
        this.pesonace = pesonace;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombremadre() {
        return nombremadre;
    }

    public void setNombremadre(String nombremadre) {
        this.nombremadre = nombremadre;
    }

    public String getNombrepadre() {
        return nombrepadre;
    }

    public void setNombrepadre(String nombrepadre) {
        this.nombrepadre = nombrepadre;
    }

    public String getNuevaraza() {
        return nuevaraza;
    }

    public void setNuevaraza(String nuevaraza) {
        this.nuevaraza = nuevaraza;
    }

    public Integer getIdnuevaraza() {
        return idnuevaraza;
    }

    public void setIdnuevaraza(Integer idnuevaraza) {
        this.idnuevaraza = idnuevaraza;
    }

    public Integer getIdanimalventa() {
        return idanimalventa;
    }

    public void setIdanimalventa(Integer idanimalventa) {
        this.idanimalventa = idanimalventa;
    }

    public String getNombreventa() {
        return nombreventa;
    }

    public void setNombreventa(String nombreventa) {
        this.nombreventa = nombreventa;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Integer getPesoventa() {
        return pesoventa;
    }

    public void setPesoventa(Integer pesoventa) {
        this.pesoventa = pesoventa;
    }

    public Integer getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Integer precioventa) {
        this.precioventa = precioventa;
    }

    public Integer getIdanimonta() {
        return idanimonta;
    }

    public void setIdanimonta(Integer idanimonta) {
        this.idanimonta = idanimonta;
    }

    public String getNombremonta() {
        return nombremonta;
    }

    public void setNombremonta(String nombremonta) {
        this.nombremonta = nombremonta;
    }

    public Integer getEdadmonta() {
        return edadmonta;
    }

    public void setEdadmonta(Integer edadmonta) {
        this.edadmonta = edadmonta;
    }

    public Integer getPesomonta() {
        return pesomonta;
    }

    public void setPesomonta(Integer pesomonta) {
        this.pesomonta = pesomonta;
    }

    public String getFecha1celo() {
        return fecha1celo;
    }

    public void setFecha1celo(String fecha1celo) {
        this.fecha1celo = fecha1celo;
    }

    public String getFecha2celo() {
        return fecha2celo;
    }

    public void setFecha2celo(String fecha2celo) {
        this.fecha2celo = fecha2celo;
    }

    public String getTipoprenez() {
        return tipoprenez;
    }

    public void setTipoprenez(String tipoprenez) {
        this.tipoprenez = tipoprenez;
    }

    public String getNomverraco() {
        return nomverraco;
    }

    public void setNomverraco(String nomverraco) {
        this.nomverraco = nomverraco;
    }

    public Integer getNumpajilla() {
        return numpajilla;
    }

    public void setNumpajilla(Integer numpajilla) {
        this.numpajilla = numpajilla;
    }

    public String getFechaeco() {
        return fechaeco;
    }

    public void setFechaeco(String fechaeco) {
        this.fechaeco = fechaeco;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanace() {
        return fechanace;
    }

    public void setFechanace(String fechanace) {
        this.fechanace = fechanace;
    }

    public Integer getPesonace() {
        return pesonace;
    }

    public void setPesonace(Integer pesonace) {
        this.pesonace = pesonace;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombremadre() {
        return nombremadre;
    }

    public void setNombremadre(String nombremadre) {
        this.nombremadre = nombremadre;
    }

    public String getNombrepadre() {
        return nombrepadre;
    }

    public void setNombrepadre(String nombrepadre) {
        this.nombrepadre = nombrepadre;
    }

    public String getNuevaraza() {
        return nuevaraza;
    }

    public void setNuevaraza(String nuevaraza) {
        this.nuevaraza = nuevaraza;
    }

    public Integer getIdnuevaraza() {
        return idnuevaraza;
    }

    public void setIdnuevaraza(Integer idnuevaraza) {
        this.idnuevaraza = idnuevaraza;
    }

    public Integer getIdanimalventa() {
        return idanimalventa;
    }

    public void setIdanimalventa(Integer idanimalventa) {
        this.idanimalventa = idanimalventa;
    }

    public String getNombreventa() {
        return nombreventa;
    }

    public void setNombreventa(String nombreventa) {
        this.nombreventa = nombreventa;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Integer getPesoventa() {
        return pesoventa;
    }

    public void setPesoventa(Integer pesoventa) {
        this.pesoventa = pesoventa;
    }

    public Integer getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Integer precioventa) {
        this.precioventa = precioventa;
    }

    public Integer getIdanimonta() {
        return idanimonta;
    }

    public void setIdanimonta(Integer idanimonta) {
        this.idanimonta = idanimonta;
    }

    public String getNombremonta() {
        return nombremonta;
    }

    public void setNombremonta(String nombremonta) {
        this.nombremonta = nombremonta;
    }

    public Integer getEdadmonta() {
        return edadmonta;
    }

    public void setEdadmonta(Integer edadmonta) {
        this.edadmonta = edadmonta;
    }

    public String getFecha1celo() {
        return fecha1celo;
    }

    public void setFecha1celo(String fecha1celo) {
        this.fecha1celo = fecha1celo;
    }

    public String getFecha2celo() {
        return fecha2celo;
    }

    public void setFecha2celo(String fecha2celo) {
        this.fecha2celo = fecha2celo;
    }

    public String getTipoprenez() {
        return tipoprenez;
    }

    public void setTipoprenez(String tipoprenez) {
        this.tipoprenez = tipoprenez;
    }

    public String getNomverraco() {
        return nomverraco;
    }

    public void setNomverraco(String nomverraco) {
        this.nomverraco = nomverraco;
    }

    public Integer getNumpajilla() {
        return numpajilla;
    }

    public void setNumpajilla(Integer numpajilla) {
        this.numpajilla = numpajilla;
    }

    public String getFechaeco() {
        return fechaeco;
    }

    public void setFechaeco(String fechaeco) {
        this.fechaeco = fechaeco;
    }

    public Integer getPesomonta() {
        return pesomonta;
    }

    public void setPesomonta(Integer pesomonta) {
        this.pesomonta = pesomonta;
    }*/
}
