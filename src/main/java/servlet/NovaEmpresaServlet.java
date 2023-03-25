package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmpresaEx2;
import repository.EmpresaRepository;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/NovaEmpresaServlet")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmpresaEx2> empresas = EmpresaRepository.getEmpresas();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");;
		out.println("<ul>");
		
		for(EmpresaEx2 empresa : empresas) {
			out.println("<li>");
			out.println(empresa.getNome());
			out.println("</li>");
		}
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(request.getParameter("id"));  
		String nome = request.getParameter("nome");
	
		EmpresaEx2 empresa = new EmpresaEx2(id, nome);
		
		EmpresaRepository.addEmpresa(empresa);
		
		EmpresaRepository.getEmpresas().forEach(e -> System.out.println(e.getNome()));
		
		doGet(request, response);
	}

}
