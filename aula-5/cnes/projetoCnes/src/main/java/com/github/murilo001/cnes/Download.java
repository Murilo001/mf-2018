/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.cnes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Implementação do downloader à partir de uma String de URL.
 */

public final class Download {
    
    /**
     * Restringe criação de instância.
     */
    protected Download() {
        // Apenas evita criação de instância.
    }
    
    /**
     * Faz o download no diretório raiz.
     * 
     * @param url String de url para ser realizado o download. 
     * @return Retorna uma lista de inputStream descompactado do arquivo lido
     * @throws java.net.MalformedURLException 
     * @throws java.io.IOException 
     */
    public ZipInputStream baixa(String url) throws MalformedURLException, 
            IOException {
        URL oracle = new URL(url);
        URLConnection urlConnection = oracle.openConnection();
        return descompacta(urlConnection.getInputStream());
    }
    
    private ZipInputStream descompacta(InputStream inputStream) throws IOException {
        ZipInputStream zin;
        List<ZipInputStream> zins = new ArrayList<>();
        zin = new ZipInputStream(inputStream);
        ZipEntry entry;
        System.out.println("Aguarde...");
        while ((entry = zin.getNextEntry()) != null) {
            if (entry.getName().contains("tbEstabelecimento"))
            {
                return zin;
            }
        }
            
        return null;
    }
    
        
    
    
    
}
    


