/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.murilo001.cnes;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;


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
        String nomeResultadoJson = "ResultadoJson";
        int size = args.length;
        if (size >= 1 && !StringUtils.isBlank(args[0]))
        {
            System.out.println("entrou");
            UrlValidator urlValidator = new UrlValidator();
            if (urlValidator.isValid(args[0])) {
                System.out.println("url is valid");
                if (size >= 2 && !StringUtils.isBlank(args[1]))
                {
                    nomeResultadoJson = args[1];
                    Download.baixa(args[0]);
                }    
                else {
                    Download.baixa(args[0]);
                }
            } else {
                System.out.println("url is invalid");
            }
        }
        else {
            System.out.println("Informe a url");
        }
    }
    
    
}