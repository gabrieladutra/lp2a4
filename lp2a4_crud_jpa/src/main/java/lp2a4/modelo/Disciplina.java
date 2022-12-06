package lp2a4.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina {
	
	@Id
	@Column
	private String codigo;
	
	@Column
	private String nome;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<AlunoPOJO> alunos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AlunoPOJO> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoPOJO> alunos) {
		this.alunos = alunos;
	}

}
