package br.edu.dne.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.dne.dao.EstudanteDAO;
import br.edu.dne.model.Estudantes;

@WebServlet("/ServletEstudante")
public class ServletEstudante extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void processRequest(HttpServletRequest request, HttpServletResponse response) // Req
	throws ServletException, IOException {
		Estudantes estudantes = new Estudantes();
		EstudanteDAO dao;
		String cmd = request.getParameter("cmd");
		try {
			if (cmd.equals("incluir") || cmd.equals("atualizar") ) {
				estudantes.setEmail(request.getParameter("txtEmail"));
				estudantes.setNome(request.getParameter("txtNome"));
				estudantes.setDataNascimento(request.getParameter("txtData"));
				estudantes.setCpf(request.getParameter("txtCpf"));
				estudantes.setCep(request.getParameter("txtCep"));
				estudantes.setNumero(request.getParameter("txtNumero"));
				estudantes.setGenero(request.getParameter("cmbGenero"));
				estudantes.setCelular(request.getParameter("txtCelular"));
				estudantes.setEscolaridade(request.getParameter("cmbEscolaridade"));
				estudantes.setNomeCurso(request.getParameter("txtNomeCurso"));
				estudantes.setSaldo(Float.parseFloat((request.getParameter("numSaldo"))));
				estudantes.setSuspender(request.getParameter("cmbSuspender"));
			} else {
				estudantes.setCpf(request.getParameter("txtCpf"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			dao = new EstudanteDAO();
			RequestDispatcher rd = null;
			if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(estudantes);
			    rd = request.getRequestDispatcher("html/concluido.html");
			} else if (cmd.equalsIgnoreCase("atu")) {
				estudantes = dao.procurarEstudante(estudantes.getCpf());
				HttpSession session = request.getSession(true);
				session.setAttribute("estudantes", estudantes);
				rd = request.getRequestDispatcher("jsp/atualizarEstudante.jsp");
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(estudantes);
				rd = request.getRequestDispatcher("html/concluido.html");
			}else if (cmd.equalsIgnoreCase("con")) {
                estudantes = dao.procurarEstudante(estudantes.getCpf());
                HttpSession session = request.getSession(true);
                session.setAttribute("estudantes", estudantes);
                rd = request.getRequestDispatcher("jsp/consultarEstudante.jsp");// 
            } else if (cmd.equalsIgnoreCase("exc")) {
				estudantes = dao.procurarEstudante(estudantes.getCpf());
				HttpSession session = request.getSession(true);
				session.setAttribute("estudantes", estudantes);
				rd = request.getRequestDispatcher("jsp/excluirEstudante.jsp");// 
			} else if (cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(estudantes);
				rd = request.getRequestDispatcher("html/concluido.html"); //
			}
			
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("Erro ao gravar");
			System.out.println(e.getMessage());
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
