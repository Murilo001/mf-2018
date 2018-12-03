
/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.murilo001.loinc;

import java.io.IOException;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Programa que faz o download do zip, extrai o csv, faz processamento e exibe
 * os resultados, juntamente com a localização, em uma tabela.
 *
 */
public final class ProgramaCsv {
    
    private static final Logger logger =
            LogManager.getLogger(ProgramaCsv.class);
    
    /**
     * Restringe criação de instância.
     */
    private ProgramaCsv() {
        // Apenas evita criação de instância.
    }
    
    
     /**
     * Ponto de entrada da aplicação. Apenas para ilustra chamada de método.
     *
     * @param args Ignorados.
     */
    public static void main(String[] args) {
        try {
            Csv.processar(args);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ProgramaCsv.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println("Operação concluída.");
    }
    
}
