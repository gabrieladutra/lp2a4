package lp2a4.controller;

import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;
import lp2a4.AlunoUtil;
import lp2a4.modelo.AlunoDAO;
import lp2a4.modelo.AlunoPOJO;

/**
 * Uma classe Util é um tipo específico de classe Helper na qual todos
 * os métodos são estáticos
 * 
 * @author diego
 *
 */
public final class ControllerUtil {
	
	private ControllerUtil() {}
	
	protected static AlunoPOJO transform(HttpServletRequest request) {
		AlunoPOJO aluno = new AlunoPOJO();
		aluno.setMatricula( request.getParameter("matricula") );
		aluno.setNome( request.getParameter("nome") );
		aluno.setEndereco( request.getParameter("endereco") );
		aluno.setDataIngresso( LocalDate.parse( request.getParameter("dataIngresso") , AlunoUtil.DATE_FORMAT ) );
		aluno.setDataConclusao( LocalDate.parse( request.getParameter("dataConclusao") , AlunoUtil.DATE_FORMAT ) );
		return aluno;
	}
	
	protected static void loadAlunoRequest(HttpServletRequest request) {
		final String matricula = request.getParameter("matricula");
		final AlunoDAO dao = AlunoDAO.getInstance();
		final AlunoPOJO aluno = dao.retrieve(matricula);
		request.setAttribute("aluno", aluno);
	}
}
