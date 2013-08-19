/**
 *
 */
package br.com.acsp.curso.domain;

/**
 * @author eduardobregaida
 */
public enum EscolaridadeType {
	FUNDAMENTAL(1, "Fundamental"), MEDIO(2, "M�dio"), TECNICO(3, "T�cnico"), GRADUACAO(
			4, "Gradua��o"), POS_GRADUACAO(5, "P�s-Gradua��o"), MESTRADO(6,
			"Mestrado"), DOUTORADO(7, "Doutorado");

	private EscolaridadeType(Integer id, String descricao) {
		setId(id);
		setDescricao(descricao);
	}

	private Integer id;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EscolaridadeType getInstance(Integer id) {
		EscolaridadeType enumObj = null;

		for (EscolaridadeType element : EscolaridadeType.values()) {
			if (element.getId().equals(id)) {
				enumObj = element;
				break;
			}
		}

		return enumObj;
	}
}
