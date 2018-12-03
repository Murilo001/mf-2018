/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.loinc;

import java.io.IOException;
import java.io.InputStream;

/**
 * Implementação do manipulador de csv do sus.
 */

public final class Csv {
    
    /**
     * Restringe criação de instância.
     */
    private Csv() {
        // Apenas evita criação de instância.
    }
    
    public static void processar(String[] args) throws IOException
    {
        InputStream arquivoZip = null;
        Json utilitarioJson = new Json();
        Download downloader = new Download();
        utilitarioJson.processaArquivo(downloader.descompacta(arquivoZip), "x");
        
        
        
    }
    
    
}