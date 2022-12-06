package entities;

package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String codigo;
	
	@Column
	private String nome;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<Aluno> alunos;

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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
   
}