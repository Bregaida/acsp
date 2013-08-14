/**
 * 
 */
package br.com.acsp.curso.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author eduardobregaida
 * 
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column private String nome;
    @Column private Long rg;
    @Column private Long cpf;
    @Column private Long tituloEleitor;
    @Column private Long alistamentoMilitar;
    @Column private boolean ativo;

    @Enumerated(EnumType.STRING)
    private EscolaridadeType escolaridade;

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(Long tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public Long getAlistamentoMilitar() {
		return alistamentoMilitar;
	}

	public void setAlistamentoMilitar(Long alistamentoMilitar) {
		this.alistamentoMilitar = alistamentoMilitar;
	}

	public EscolaridadeType getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeType escolaridade) {
		this.escolaridade = escolaridade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
