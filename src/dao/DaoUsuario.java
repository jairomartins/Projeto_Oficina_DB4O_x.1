package dao;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import modelo.Usuario;

public class DaoUsuario{

	public void cadastrarUsuario(Usuario u) {
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try {
			banco.store(u);
		} finally {
			banco.close();
		}
	}

	@SuppressWarnings("unused")
	public boolean existe(Usuario u){
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try{
			@SuppressWarnings("serial")
			ObjectSet<Usuario> usuarios =  banco.query(new Predicate<Usuario>(){
				public boolean match(Usuario usu){
					return (usu.getNome().equals(u.getNome())&&usu.getSenha().equals(u.getSenha()));
				}
			}) ;
			for(Usuario us:usuarios){
				return true;
			}
		}finally{
			banco.close();
		}
		return false;
	}
	
	
	//Retorna os usuarios contido no banco
	@SuppressWarnings("serial")
	public ArrayList<Usuario> Usuarios(){
		ArrayList<Usuario> us = new ArrayList<>();
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try{
			ObjectSet<Usuario> usuarios =  banco.query(new Predicate<Usuario>(){
				public boolean match(Usuario usu){
					return usu!=null;
				}
			}) ;
			
			while(usuarios.hasNext()){
				us.add(usuarios.next());
			}
			return us;
		}finally{
			banco.close();
		} 
	}
	
	public boolean remover(String nomeUsuario){
		ObjectContainer banco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BancoOficina.yap");
		try{
			@SuppressWarnings("serial")
			ObjectSet<Usuario> usuarios =  banco.query(new Predicate<Usuario>(){
				public boolean match(Usuario usu){
					return (usu.getNome().equals(nomeUsuario));
				}
			}) ;
			Usuario u = usuarios.get(0);
			banco.delete(u);
			banco.commit();
		}finally{
			banco.close();
		}
		return false;
	}
	

}
