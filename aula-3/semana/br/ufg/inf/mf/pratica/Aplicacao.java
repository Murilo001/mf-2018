package br.ufg.inf.mf.pratica;

import java.time.LocalDate;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Calendar;

public class Aplicacao {

	private static final int acabouSemana = 8;
	private static final int domingo = 1;

	public static void main(String[] args) {

            Locale usersLocale = Locale.getDefault();
            DateFormatSymbols dfs = new DateFormatSymbols(usersLocale);
            String weekdays[] = dfs.getWeekdays();
	    Calendar cal = Calendar.getInstance(usersLocale);
	    int diaCorrente = LocalDate.now().getDayOfWeek().getValue() + 1;
	    if (diaCorrente == acabouSemana) {
	    	diaCorrente = domingo;
	    }   
	
	    System.out.println(weekdays[diaCorrente]);
	    
	}

}