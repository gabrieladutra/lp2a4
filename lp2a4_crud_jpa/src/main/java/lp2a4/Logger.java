package lp2a4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
	private final String nomeClasse;
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
	
	public Logger(Class<?> classe) {
		this.nomeClasse = classe.getName();
	}
	
	public void info(String texto) {
		System.out.printf( "%s [%s] [INFO] %s", LocalDateTime.now().format(FORMATTER), nomeClasse, texto);
	}
	
	public void error(String texto) {
		System.err.printf( "%s [%s] [ERRO] %s", LocalDateTime.now().format(FORMATTER), nomeClasse, texto);
	}
}
