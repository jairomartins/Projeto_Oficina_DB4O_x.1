package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class ControleUsuario
 */
@WebServlet("/ControleUsuario")
public class ControleUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao==null){
			HttpSession s = request.getSession();
			s.setAttribute("usuarios",new DaoUsuario().Usuarios());
			response.sendRedirect("cadastroUsuarios.jsp");
		}else if(acao.equals("Cadastrar")){
			Usuario u = new Usuario();
			u.setNome(request.getParameter("usuario"));
			u.setSenha(request.getParameter("senha"));
			new DaoUsuario().cadastrarUsuario(u);
			HttpSession s = request.getSession();
			s.setAttribute("usuarios",new DaoUsuario().Usuarios());
			response.sendRedirect("cadastroUsuarios.jsp");
		}else if(acao.equals("remover")){
			new DaoUsuario().remover(request.getParameter("us"));
			HttpSession s = request.getSession();
			s.setAttribute("usuarios",new DaoUsuario().Usuarios());
			response.sendRedirect("cadastroUsuarios.jsp");
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
