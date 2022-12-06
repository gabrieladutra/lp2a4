package lp2a4;

import java.time.format.DateTimeFormatter;

/**
 * Uma classe Util é um tipo específico de classe Helper na qual todos
 * os métodos são estáticos
 * 
 * @author diego
 *
 */
public final class AlunoUtil {
	
	//impede que alguém instancie a classe.
	private AlunoUtil() {}
	
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/uuuu");
}
