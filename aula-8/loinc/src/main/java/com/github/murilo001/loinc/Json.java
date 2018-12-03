/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.loinc;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;


/**
 * Implementação do processador do arquivo para Json.
 */

public final class Json {
    
    /**
     * Apenas habilita a criação de instância.
     */
    protected Json() {
        // Apenas evita criação de instância.
    }
    
    public void processaArquivo(ZipInputStream zin, String nomeJson) throws IOException
    {
        List<String> linhasDoArquivo = new ArrayList<>();
        linhasDoArquivo = leituraEstabelecimento(zin);
        escritaEstabelecimento(linhasDoArquivo, nomeJson);
    }
    
    
    public List<String> leituraEstabelecimento(ZipInputStream zin) throws UnsupportedEncodingException, IOException
    {
        InputStreamReader inputReader = 
                            new InputStreamReader(zin, "UTF-8");
        BufferedReader in;
        in = new BufferedReader(inputReader);
        List<String> linhasDoArquivo = new ArrayList<>();
        for (String linha = in.readLine(); linha != null;
                linha = in.readLine()) {    
            linhasDoArquivo.add(linha);
        }
        in.close();
        return linhasDoArquivo;
    }
    
    private static void escritaEstabelecimento(
            List<String> linhas, String nomeJson) throws IOException {
        
        File jsonFile = new File(nomeJson);
        jsonFile.createNewFile();
        BufferedWriter writer;
        writer = Files.newBufferedWriter(jsonFile.toPath(), 
                StandardCharsets.UTF_8);
        TableCore estabelecimento = new TableCore();
        
        for(String linha: linhas){
            TableCore estabelecimentoAtual = 
                estabelecimento.preencheEstabelecimento(removeColunas(linha));
            String estabelecimentoSerializado = 
                    new Gson().toJson(estabelecimentoAtual);
            writer.write(estabelecimentoSerializado);
            writer.newLine();
            writer.flush();
        }
        writer.close();
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
    public static String[] removeColunas(String linha) {
        String[] arraySplit = linha.split(";");
        String codigoUnidade, razaoSocial, latitude, longitude;
        codigoUnidade = arraySplit[1];
        razaoSocial = arraySplit[5];
        latitude = arraySplit[39];
        longitude = arraySplit[40];
        String[] arrayUtil = { codigoUnidade, razaoSocial, latitude, longitude};
        return arrayUtil;
    }

    
    
    
    
}