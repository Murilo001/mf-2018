/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.murilo001.cnes;

/**
 *
 * @author Murilo
 */
public class Estabelecimento {

    private String codigoCnes;
    private String razaoSocial;
    private String latitude;
    private String longitude;
    
    /**
     * Realiza a criação de instância com elementos vazios.
     */
    public Estabelecimento() {
        codigoCnes = "";
        razaoSocial = "";
        latitude = "";
        longitude = "";
    }
    
    public String getCodigoCnes() {
        return codigoCnes;
    }

    public void setCodigoCnes(String codigoCnes) {
        this.codigoCnes = codigoCnes;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public Estabelecimento preencheEstabelecimento(String[] colunas)
    {
        Estabelecimento stab = new Estabelecimento();
        stab.setCodigoCnes(colunas[0]);
        stab.setRazaoSocial(colunas[1]);
        stab.setLatitude(colunas[2]);
        stab.setLongitude(colunas[3]);
        
        return stab;
    }

    
}
