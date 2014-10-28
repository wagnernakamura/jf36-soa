/**
 * 
 */
package br.com.caelum.estoque.ws;

/**
 * @author soa4769
 *
 */
public class ItemEstoque {

	private String codigo;
	private Integer quantidade;
	
	/**
	 * 
	 */
	public ItemEstoque() {
	}
	
	public ItemEstoque(String codigo, Integer quantidade){
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
