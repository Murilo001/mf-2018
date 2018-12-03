/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.murilo001.loinc;

import com.github.murilo001.loinc.model.dao.TableCoreDAO;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Murilo
 */
public class TableCore {
    
    public static void processarArquivoZipado(String caminhoArquivo, 
            boolean baixado) throws IOException
    {
        Download downloader = new Download();
        if (baixado) {
            List<String> linhasDoArquivo = new ArrayList<>();
            linhasDoArquivo = 
                    leituraTableCore(downloader.descompacta(new FileInputStream(caminhoArquivo)));
            criarTabela(linhasDoArquivo.get(0));
            popularTabela(linhasDoArquivo);
        } else {
            List<String> linhasDoArquivo = new ArrayList<>();
            linhasDoArquivo = 
                    leituraTableCore(downloader.baixa(caminhoArquivo));
            criarTabela(linhasDoArquivo.get(0));
            popularTabela(linhasDoArquivo);
        }
        
    }
    
    public static void criarTabela(String metaDados) throws IOException {
        TableCoreDAO tabelaDao = new TableCoreDAO();
        tabelaDao.create(metaDados.replace("\"", "").split(","));
    }
    
    public static void popularTabela(List<String> dados) {
        
    }
    
    public static List<String> leituraTableCore(ZipInputStream zin) 
            throws UnsupportedEncodingException, IOException
    {
        InputStreamReader inputReader = new InputStreamReader(zin, "UTF-8");
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
    
    
}
