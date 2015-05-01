package pt.c07bd.s10oorelacional;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "AUTOR")
@Access(AccessType.PROPERTY)
@DiscriminatorValue("A")
@PrimaryKeyJoinColumn(name = "NOME", referencedColumnName = "NOME")
public class Autor extends Pessoa {

	private String estilo;

	private List<Autor> coAutor;

	public Autor() {
		super();
		setTipoPessoa('A');
		coAutor = new LinkedList<Autor>();
	}

	public Autor(String nome, String email, String estilo) {
		super(nome, email);
		this.estilo = estilo;
		setTipoPessoa('A');
		coAutor = new LinkedList<Autor>();

	}

	@Column(name = "ESTILO", length = 50)
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AUTOR_COAUTOR", 
		joinColumns = @JoinColumn(name = "AUTOR", referencedColumnName = "NOME"), 
		inverseJoinColumns = @JoinColumn(name = "COAUTOR", referencedColumnName = "NOME"))
	public List<Autor> getCoAutor() {
		return coAutor;
	}

	public void setCoAutor(List<Autor> coAutor) {
		this.coAutor = coAutor;
	}


}
