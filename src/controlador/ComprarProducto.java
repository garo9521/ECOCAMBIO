package controlador;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GoogleMail;
import modelo.QuerysBD;

import java.util.UUID;
/**
 * Servlet implementation class ComprarProducto
 */
@WebServlet("/ComprarProducto")
public class ComprarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boleta = request.getParameter("boleta");
		int costo = -Integer.parseInt(request.getParameter("costo"));
		String nombre = request.getParameter("nombre");
		String codigo = UUID.randomUUID().toString().replace("-","").substring(0, 10).toUpperCase();
		System.out.println(codigo);
		QuerysBD.agregarPuntos(boleta, costo);
		HttpSession session = request.getSession();
		String [] campo = QuerysBD.getDatos(boleta);
		session.setAttribute("boleta", boleta);
		session.setAttribute("nombre", campo[0]);
		session.setAttribute("email", campo[1]);
		session.setAttribute("puntos", campo[2]);
		response.sendRedirect("home.jsp");
		try {
			GoogleMail.Send("garo.edgar21", "*Edgar9521*", campo[1], "Proyecto ECOCAMBIO", "Tu producto se ha canjeado con exito, este es tu codigo: " + codigo + " para canjear el producto " + nombre);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
