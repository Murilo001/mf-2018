/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.cnes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Implementação do downloader à partir de uma String de URL.
 */

public final class Download {
    
     /**
     * Restringe criação de instância.
     */
    private Download() {
        // Apenas evita criação de instância.
    }
    
    /**
     * Faz o download na pasta x
     * 
     * @param url String de url para ser realizado o download. 
     * @throws java.net.MalformedURLException 
     * @throws java.io.IOException 
     */
    public static void baixa(String url) throws MalformedURLException, IOException {
        
        
        URL oracle = new URL(url);
        URLConnection urlConnection = oracle.openConnection();
        ZipInputStream zin = new ZipInputStream(urlConnection.getInputStream());
        
        
        ZipEntry entry;

        InputStream is = null;
        
        while ((entry = zin.getNextEntry()) != null) {
            System.out.println("Unzipping: " + entry.getName());
            if (entry.getName().contains("tbEstabelecimento"))
            {
                InputStreamReader reader = new InputStreamReader(zin, "UTF-8");
                BufferedReader in = new BufferedReader(reader);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("to aq 2");
                    System.out.println(inputLine);
                }
                in.close();
            }  
        }
        System.out.println("passou do while");
             
        
        
        
        
    }
    
    
}
    


