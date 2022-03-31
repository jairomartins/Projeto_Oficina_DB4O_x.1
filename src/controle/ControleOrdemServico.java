package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoOS;
import modelo.Carro;
import modelo.Cliente;
import modelo.OrdemServico;
import modelo.Servico;

/**
 * Servlet implementation class ControleOrdemServico
 */
@WebServlet("/ControleOrdemServico")
public class ControleOrdemServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleOrdemServico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		//new DaoOS().apagarOrdemServicos();
		if(acao==null){
			new DaoOS().mostrarDadosOSs(new DaoOS().buscaOS());
			response.sendRedirect("cadastroOrdemServico.jsp");
		}else if(acao.equals("Abrir")){
			new DaoOS().cadastraOS(this.carregaDadosOS(request));
			HttpSession sessaoAtual = request.getSession();
			sessaoAtual.setAttribute("OrdenServicos", new DaoOS().buscaOS());
			response.sendRedirect("ordemServicos.jsp");
		}else if(acao.equals("ler")){
			HttpSession sessaoAtual = request.getSession();
			sessaoAtual.setAttribute("OrdenServicos", new DaoOS().buscaOS());
			response.sendRedirect("ordemServicos.jsp");
		}else if(acao.equals("Buscar")){
			this.executarBusca(request);
			response.sendRedirect("ordemServicos.jsp");
		}else if(acao.equals("Detalhe")){
			HttpSession sessaoAtual = request.getSession();
			sessaoAtual.setAttribute("OrdenServico", new DaoOS().OSPorCodigo(Integer.valueOf(request.getParameter("cod"))));
			response.sendRedirect("verOrdemServico.jsp");
		}else if(acao.equals("Adicionar")){
			HttpSession sessaoAtual = request.getSession();
			int codigo =Integer.valueOf(request.getParameter("cod"));
			new DaoOS().adicionarServicoOS(this.carregaServico(request), codigo);
			sessaoAtual.setAttribute("OrdenServico", new DaoOS().OSPorCodigo(Integer.valueOf(request.getParameter("cod"))));
			
			response.sendRedirect("verOrdemServico.jsp");
		}else if (acao.equals("Fechar")){
			new DaoOS().finalizarOS(Integer.valueOf(request.getParameter("cod")));
			HttpSession sessaoAtual = request.getSession();
			sessaoAtual.setAttribute("OrdenServico", new DaoOS().OSPorCodigo(Integer.valueOf(request.getParameter("cod"))));
			response.sendRedirect("verOrdemServico.jsp");
		}else if(acao.equals("Remover")){
			new DaoOS().removeServicoOS(request.getParameter("servico"), Integer.valueOf(request.getParameter("cod")));
			HttpSession sessaoAtual = request.getSession();
			sessaoAtual.setAttribute("OrdenServico", new DaoOS().OSPorCodigo(Integer.valueOf(request.getParameter("cod"))));
			response.sendRedirect("verOrdemServico.jsp");
		}
		else{
			response.sendRedirect("cadastroOrdemServico.jsp");
		}
	}
	
	
	public OrdemServico carregaDadosOS(HttpServletRequest request){
		OrdemServico os = new OrdemServico();
		Cliente c = new Cliente();
		Carro car = new Carro();
		c.setNome(request.getParameter("dono"));
		c.setCpf(request.getParameter("cpf"));
		c.setEndereco(request.getParameter("endereco"));
		c.setTelefone(request.getParameter("telefone"));
		os.setCliente(c);
		
		car.setPlaca(request.getParameter("placa"));
		car.setMarca(request.getParameter("marca"));
		car.setModelo(request.getParameter("modelo"));
		car.setAno(Integer.valueOf(request.getParameter("ano")));
		car.setCombustivel(request.getParameter("combustivel"));
		os.setCarro(car);

		os.setProblemas(request.getParameter("problemas"));
		return os;	
	}
	
	public void executarBusca(HttpServletRequest request){
		HttpSession sessaoAtual = request.getSession();
		if(request.getParameter("placa").equals("")){
			sessaoAtual.setAttribute("OrdenServicos", new DaoOS().OSPorFiltro((Boolean.valueOf(request.getParameter("status")))));
		}else{
			sessaoAtual.setAttribute("OrdenServicos", new DaoOS().OSPorFiltro(request.getParameter("placa"),request.getParameter("status")));
		}
	}
	
	
	public Servico carregaServico(HttpServletRequest request){
		Servico s = new Servico();
		s.setNome(request.getParameter("nomeservico"));
		s.setValor(Double.valueOf(request.getParameter("valor")));
		return s;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
