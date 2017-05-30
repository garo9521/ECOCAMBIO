package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.QuerysBD;

/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
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
		HttpSession session = request.getSession();
		String boleta = (String) session.getAttribute("boleta");
		
		
		String campos[] = new String[3];
		campos[0] = request.getParameter("email");
		campos[1] = request.getParameter("nombre");
		campos[2] = request.getParameter("password");
		
		System.out.println(campos[0]);
		
		QuerysBD mysql = new QuerysBD();
		
		mysql.actualizaUsuario(boleta, campos);
		String [] campo = QuerysBD.getDatos(boleta);
		session.setAttribute("boleta", boleta);
		session.setAttribute("nombre", campo[0]);
		session.setAttribute("email", campo[1]);
		session.setAttribute("puntos", campo[2]);
		response.sendRedirect("home.jsp");
	}

}
