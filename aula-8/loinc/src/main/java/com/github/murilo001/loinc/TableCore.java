/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.murilo001.loinc;

/**
 *
 * @author Murilo
 */
public class TableCore {

    private int loincNum;
    private String component;
    private String property;
    private String timeAspct;
    private String system;
    private String scaleTyp;
    private String methodTyp;
    private String classLoinc;
    private String classType;
    private String longCommonName;
    private String shortname;
    private String externalCopyrightNotice;
    private String status;
    private String versionFirstReleased;
    private String versionLastChanged;
    
    public int getLoincNum() {
        return loincNum;
    }

    public void setLoincNum(int loincNum) {
        this.loincNum = loincNum;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTimeAspct() {
        return timeAspct;
    }

    public void setTimeAspct(String timeAspct) {
        this.timeAspct = timeAspct;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getScaleTyp() {
        return scaleTyp;
    }

    public void setScaleTyp(String scaleTyp) {
        this.scaleTyp = scaleTyp;
    }

    public String getMethodTyp() {
        return methodTyp;
    }

    public void setMethodTyp(String methodTyp) {
        this.methodTyp = methodTyp;
    }

    public String getClassLoinc() {
        return classLoinc;
    }

    public void setClassLoinc(String classLoinc) {
        this.classLoinc = classLoinc;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getLongCommonName() {
        return longCommonName;
    }

    public void setLongCommonName(String longCommonName) {
        this.longCommonName = longCommonName;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getExternalCopyrightNotice() {
        return externalCopyrightNotice;
    }

    public void setExternalCopyrightNotice(String externalCopyrightNotice) {
        this.externalCopyrightNotice = externalCopyrightNotice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersionFirstReleased() {
        return versionFirstReleased;
    }

    public void setVersionFirstReleased(String versionFirstReleased) {
        this.versionFirstReleased = versionFirstReleased;
    }

    public String getVersionLastChanged() {
        return versionLastChanged;
    }

    public void setVersionLastChanged(String versionLastChanged) {
        this.versionLastChanged = versionLastChanged;
    }
    
    /**
     * Realiza a criação de instância com elementos vazios.
     */
    public TableCore() {
        loincNum = 0;
        component = "";
        property = "";
        timeAspct = "";
        system = "";
        scaleTyp = "";
        methodTyp = "";
        classLoinc = "";
        classType = "";
        longCommonName = "";
        shortname = "";
        externalCopyrightNotice = "";
        status = "";
        versionFirstReleased = "";
        versionFirstReleased = "";
    }
    
    
    public TableCore preencheEstabelecimento(String[] colunas)
    {
        TableCore stab = new TableCore();
        stab.setLoincNum(Integer.parseInt(colunas[0]));
        stab.setProperty(colunas[1]);
        stab.setTimeAspct(colunas[2]);
        stab.setSystem(colunas[3]);
        stab.setScaleTyp(colunas[4]);
        stab.setMethodTyp(colunas[5]);
        stab.setClassLoinc(colunas[6]);
        stab.setClassType(colunas[7]);
        stab.setLongCommonName(colunas[8]);
        stab.setShortname(colunas[9]);
        stab.setExternalCopyrightNotice(colunas[10]);
        stab.setStatus(colunas[11]);
        stab.setVersionFirstReleased(colunas[12]);
        stab.setVersionLastChanged(colunas[13]);
        
        return stab;
    }

    
}
