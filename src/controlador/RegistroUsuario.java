package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.QuerysBD;

/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistroUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String campos[] = new String[4];
		campos[0] = request.getParameter("email");
		campos[1] = request.getParameter("boleta");
		campos[2] = request.getParameter("nombre");
		campos[3] = request.getParameter("clave1");
		
		System.out.println(campos[0]);
		
		QuerysBD mysql = new QuerysBD();
		
		mysql.registrarUsuario(campos);
		
		response.sendRedirect("Inicio.html");
	}

}
