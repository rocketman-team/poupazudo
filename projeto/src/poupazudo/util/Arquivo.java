package poupazudo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import poupazudo.model.Usuario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * A classe Arquivo possui funcoes utilitarias pra manipular um arquivo do tipo
 * json usando a biblioteca Gson escrita pelo google.
 * 
 * @author team
 * 
 */
public class Arquivo {

	/**
	 * Caminho do arquivo onde sera persistido o json dos dados
	 */
	/* configurado no eclipse*/
	private static final String DATA = Recursos.LOCAL_DADOS;
	
	private static final String TEMP = Recursos.LOCAL_DADOS_TMP;
     
	/**
	 * Permite preparar um arquivo para escrita em arquivo
	 */
	private static BufferedWriter writer;

	/**
	 * Permite preparar um arquivo para leitura
	 */
	private static BufferedReader reader;

	/**
	 * Biblioteca que permite converter Objectos Java em uma representacao JSON
	 */
	private static Gson gson = new Gson();

	/**
	 * Salva a lista de usuarios do sistema
	 * 
	 * @param lista
	 *            lista de usuarios do sistema
	 * @throws IOException
	 *             Erro ao manipular um arquivo
	 */
	public static void salvar(List<Usuario> lista) throws IOException {
		String wrap = gson.toJson(lista);
		writer = new BufferedWriter(new FileWriter(DATA));
		writer.write(wrap);
		writer.close();
	}
	
	
	public static void salvar(Usuario usuario) throws IOException {
		String wrap = gson.toJson(usuario);
		writer = new BufferedWriter(new FileWriter(TEMP));
		writer.write(wrap);
		writer.close();
	}
	
	public static Usuario getUsuarioTemp() throws IOException {
		String wrap = new File(TEMP).getCanonicalPath();
		reader = new BufferedReader(new FileReader(wrap));
		String unwrap = reader.readLine();
		Usuario usuarioTemp = gson.fromJson(unwrap,
				new TypeToken<Usuario>() {
				}.getType());

		return usuarioTemp;
	}


	/**
	 * Retorna a lista de usuarios do sistema
	 * 
	 * @return Lista e usuarios do sistema
	 * @throws IOException
	 *             Erro ao manipular um arquivo
	 */
	public static List<Usuario> abrir() throws IOException {
		String wrap = new File(DATA).getCanonicalPath();
		reader = new BufferedReader(new FileReader(wrap));
		String unwrap = reader.readLine();
		List<Usuario> tabela = gson.fromJson(unwrap,
				new TypeToken<List<Usuario>>() {
				}.getType());

		return tabela;
	}

}
