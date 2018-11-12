/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.cnes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
     * Faz o download na pasta x.
     * 
     * @param url String de url para ser realizado o download. 
     * @throws java.net.MalformedURLException 
     * @throws java.io.IOException 
     */
    public static void baixa(String url) throws MalformedURLException, IOException {
        URL oracle = new URL(url);
        URLConnection urlConnection = oracle.openConnection();
        ZipInputStream zin;
        zin = new ZipInputStream(urlConnection.getInputStream());
        ZipEntry entry;
            
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println("Unzipping: " + entry.getName());
                if (entry.getName().contains("tbEstabelecimento"))
                {
                    InputStreamReader inputReader = 
                            new InputStreamReader(zin, "UTF-8");
                    BufferedReader in;
                    in = new BufferedReader(inputReader);
                        File jsonFile = new File("serialkiller5.txt");
                        jsonFile.createNewFile();
                        BufferedWriter writer = Files.newBufferedWriter(
                                    jsonFile.toPath(), StandardCharsets.UTF_8);
                        for (String line = in.readLine(); line != null;
                                line = in.readLine()) {                       
                            line = removeColunas(line);
                            writer.write(line);
                            writer.newLine();
                            writer.flush();
                        }
                        in.close();
                        writer.close();
                }
            }
        System.out.println("passou do while");
    }
    
    /**
     * Método utilitário que remove as colunas desncessárias, returnando uma
     * string com quatro colunas: código cnes, razão social, latitude 
     * e longitude.
     * 
     * @param linha String contendo todos os dados da tabela "tbEstabelecimento"
     * de um estabelecimento. 
     * @return Retorna uma string contendo "Código cnes, razão social, latitude
     * e longitude.
     */
    public static String removeColunas(String linha) {
        String[] arraySplit = linha.split(";");
        String codigoUnidade, razaoSocial, latitude, longitude, json;
        codigoUnidade = arraySplit[1];
        razaoSocial = arraySplit[5];
        latitude = arraySplit[39];
        longitude = arraySplit[40];
        json = codigoUnidade + razaoSocial + latitude + longitude;
        return json;
    }
    
    
}
    


