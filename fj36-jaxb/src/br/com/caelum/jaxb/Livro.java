package br.com.caelum.jaxb;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Livro {
	private String codigo;
	private String titulo;
	private String nomeAutor;
	private BigDecimal valor;
	private Categoria categoria;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the nomeAutor
	 */
	public String getNomeAutor() {
		return nomeAutor;
	}

	/**
	 * @param nomeAutor
	 *            the nomeAutor to set
	 */
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Livro() {
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Livro(String codigo, String titulo, String nomeAutor,
			BigDecimal valor, Categoria categoria) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.valor = valor;
		this.categoria = categoria;
	}
}
