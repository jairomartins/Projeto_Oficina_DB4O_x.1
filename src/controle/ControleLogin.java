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
 * Servlet implementation class ControleLogin
 */
@WebServlet("/ControleLogin")
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		
		if(acao.equals("Sair")){
			request.getSession().invalidate();
		}
		
		
		Usuario u = new Usuario();
		u.setNome(request.getParameter("usuario"));
		u.setSenha(request.getParameter("senha"));
		
		if(new DaoUsuario().existe(u)){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", u);
			response.sendRedirect("ControleOrdemServico");
		}
		else{
			response.sendRedirect("index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
