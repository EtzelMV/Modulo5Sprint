package grupal.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Contacto
 */
@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// Verificar si el usuario ha iniciado sesión
    	HttpSession session = request.getSession();
        if (session.getAttribute("usuario") != null) {
        	// Establecer la página específica a incluir en la plantilla
    	    request.setAttribute("contenido", "contacto.jsp");

    	    // Redirigir a la vista
    	    request.getRequestDispatcher("views/plantilla.jsp").forward(request, response);
        } else {
            // Si el usuario no ha iniciado sesión, redirigir al formulario de inicio de sesión
            response.sendRedirect("Login");
        }
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}