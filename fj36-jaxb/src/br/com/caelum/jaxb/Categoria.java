/**
 * 
 */
package br.com.caelum.jaxb;

/**
 * @author soa4769
 *
 */
public class Categoria {

	private String nome;
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 */
	public Categoria() {
	}
	
	/**
	 * 
	 */
	public Categoria(String nome) {
		this.nome = nome;
	}
}