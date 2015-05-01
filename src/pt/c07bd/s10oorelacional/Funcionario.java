package pt.c07bd.s10oorelacional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "FUNCIONARIO")
@Access(AccessType.PROPERTY)
@DiscriminatorValue("F")
@PrimaryKeyJoinColumn(name="NOME",referencedColumnName="NOME")
public class Funcionario extends Pessoa {

	private String matricula;

	public Funcionario() {
		super();
		setTipoPessoa('F');
	}

	public Funcionario(String nome, String email, String matricula) {
		super(nome, email);
		this.matricula = matricula;
		setTipoPessoa('F');
	}

	@Column(name = "MATRICULA", length = 10)
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
