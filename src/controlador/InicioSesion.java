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
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
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
		QuerysBD mysql = new QuerysBD();
		String boleta = request.getParameter("boleta");
		String pass = request.getParameter("password");
		
		String usuario = mysql.validarUsuario(boleta,pass);
		
		//Jalamos el usuario y su tipo, si es nulo no existe
		if(usuario.equals("null"))
		{
			response.sendRedirect("Error.html");
		}
		else
		{
			//Jalamos los registros que ya tiene el usuario, y los metemos en un pojo para llevarnos por la sesion
			// igual pongo su usuario en la sesion, para con JSP construir el home
			// creo que lo unico que varia es si el usuario puede o no agregar una cuenta
			HttpSession session = request.getSession();
			
			//proponrgo que el metodo regrese un arrayList de registros del usuario para que mas adelante los muestre en JSP y cuando
			//se selecciona un registro a usar o a modificar el servlet de las operaciones lo encuentre rapido y agregue etc..
			usuario = boleta;
			//recorreel hashMap con el iterator para sacar los objetos
			session.setAttribute("usuario", usuario);
			session.setAttribute("boleta", boleta);
			response.sendRedirect("home.jsp");
			
		}
	}

}
