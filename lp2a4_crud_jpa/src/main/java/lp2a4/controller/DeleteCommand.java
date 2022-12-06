package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lp2a4.modelo.AlunoDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final AlunoDAO dao = AlunoDAO.getInstance();
		if (dao.delete(request.getParameter("matricula"))) {
			response.getWriter().append("Aluno foi deletado com sucesso!!!");
		} else {
			response.getWriter().append("Deleção não funcionou!!!");			
		}
	}

}
