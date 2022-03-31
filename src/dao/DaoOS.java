package dao;

import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import modelo.OrdemServico;
import modelo.Servico;

public class DaoOS {

	public void cadastraOS(OrdemServico os) {
		os.setCodigo(this.gerarCodigo());
		ArrayList<Servico> servicos = new ArrayList<>();
		os.setServicos(servicos);
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			banco.store(os);
			System.out.println("DaoOS:CdastrarOS:>>> OrdemServico Cadastrada!");
		} finally {
			banco.close();
		}
	}

	public ArrayList<OrdemServico> buscaOS() {
		ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS != null;
				}
			});

			while (oss.hasNext()) {
				ordens.add((OrdemServico) oss.next());
			}

			// this.mostrarDadosOSs(ordens);
		} finally {
			banco.close();
		}

		return ordens;
	}

	public ArrayList<OrdemServico> OSPorFiltro(Boolean status) {

		ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS.isStatus() == status;
				}
			});

			while (oss.hasNext()) {
				ordens.add((OrdemServico) oss.next());
			}

			this.mostrarDadosOSs(ordens);
		} finally {
			banco.close();
		}

		return ordens;
	}

	public ArrayList<OrdemServico> OSPorFiltro(String placa, String status) {

		boolean statusBuscado;
		if (status.equals("true")) {
			statusBuscado = true;
		} else {
			statusBuscado = false;
		}
		ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return ((OS.getCarro().getPlaca().equals(placa)) && (OS.isStatus() == statusBuscado));
				}
			});

			while (oss.hasNext()) {
				ordens.add((OrdemServico) oss.next());
			}

			this.mostrarDadosOSs(ordens);
		} finally {
			banco.close();
		}

		return ordens;
	}

	public void apagarOrdemServicos() {
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS != null;
				}
			});

			while (oss.hasNext()) {
				banco.delete(oss.next());
				System.out.println("Apagando ...");
			}

		} finally {
			banco.close();
		}
	}

	public ArrayList<OrdemServico> OSPorCodigo(int codigo) {

		ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS.getCodigo() == codigo;
				}
			});

			while (oss.hasNext()) {
				ordens.add((OrdemServico) oss.next());
			}

			// this.mostrarDadosOSs(ordens);
		} finally {
			banco.close();
		}

		return ordens;
	}

	public int gerarCodigo() {
		int codigo = 0;
		ArrayList<OrdemServico> ordens = this.buscaOS();
		for (OrdemServico o : ordens) {
			if (o.getCodigo() >= codigo) {
				codigo = o.getCodigo() + 1;
			}
		}

		return codigo;
	}

	public void adicionarServicoOS(Servico servicoNovo, int codigoOS) {

	//	ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS.getCodigo() == codigoOS;
				}
			});
			System.out.println("Adicionar servido >>" + servicoNovo.getNome());
			ArrayList<Servico> ss = oss.get(0).getServicos();
			ss.add(servicoNovo);
			banco.store(ss);
			banco.commit();
		} finally {
			banco.close();
		}

	}
	
	public void removeServicoOS(String nomeServico, int codigoOS) {

	//	ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS.getCodigo() == codigoOS;
				}
			});

			ArrayList<Servico> ss = oss.get(0).getServicos();
			int index = 0;
			for(Servico s : ss){
				if(s.getNome().equals(nomeServico)){
					break;
				
				}
				index++;	
			}
			ss.remove(index);
			banco.store(ss);
			banco.commit();
		} finally {
			banco.close();
		}

	}
	
	public void finalizarOS(int codigoOS) {

		//ArrayList<OrdemServico> ordens = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			ObjectSet<OrdemServico> oss = banco.query(new Predicate<OrdemServico>() {

				private static final long serialVersionUID = 1L;

				public boolean match(OrdemServico OS) {
					return OS.getCodigo() == codigoOS;
				}
			});
			OrdemServico os = oss.next();
			if(os.isStatus()){
				os.setStatus(false);
			}else{
				os.setStatus(true);
			}
			banco.store(os);
			banco.commit();
		} finally {
			banco.close();
		}

	}


	public void mostrarDadosOSs(ArrayList<OrdemServico> oss){
		System.out.println("$$");
		for(OrdemServico os : oss){
			System.out.println("DaoOS:mostrarDadosOSs:codigo >>> "+os.getCodigo());
			System.out.println("DaoOS:mostrarDadosOSs:cliente >>> "+os.getCliente().getNome());
			System.out.println("DaoOS:mostrarDadosOSs:placa >>> "+os.getCarro().getPlaca());
			System.out.println("DaoOS:mostrarDadosOSs:problemas >>> "+os.getProblemas());
			for(Servico s:os.getServicos()){
				System.out.print("##");
				System.out.println(s.getNome());
			}
			System.out.println("Valor ### "+os.getValorTotal());
		}
	}
	
	
	

}
