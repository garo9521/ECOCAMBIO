package controlador;

import java.io.IOException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GoogleMail;
import modelo.QuerysBD;

/**
 * Servlet implementation class RestablecerContra
 */
@WebServlet("/RestablecerContra")
public class RestablecerContra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestablecerContra() {
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
		String boleta = request.getParameter("boleta");
		
		String [] campo = QuerysBD.getDatos(boleta);
		System.out.println(campo[1] + " " + campo[3]);
		try {
			GoogleMail.Send("garo.edgar21", "*Edgar9521*", campo[1], "Proyecto ECOCAMBIO", "Tu contraseña es la siguiente: " + campo[3]);
			System.out.println("Se envio el correo");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Inicio.html");
	}

}
