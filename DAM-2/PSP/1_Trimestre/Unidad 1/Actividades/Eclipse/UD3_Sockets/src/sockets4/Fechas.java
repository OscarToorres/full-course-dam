package sockets4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fechas {

	public Fechas() {
	}

	public String dateToString(Date fecha) {
		String pattern = "HH:MM:SS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(fecha);
	}

	public Date stringToDate(String fecha) {
		String pattern = "HH:MM:SS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			return simpleDateFormat.parse(fecha);
		} catch (ParseException ex) {
			Logger.getLogger(Fechas.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}