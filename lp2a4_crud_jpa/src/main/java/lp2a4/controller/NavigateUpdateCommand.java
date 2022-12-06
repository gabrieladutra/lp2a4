package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NavigateUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControllerUtil.loadAlunoRequest(request);
		final RequestDispatcher rd = request.getRequestDispatcher("atualizar_aluno.jsp");
		rd.forward(request, response); 
	}

}
