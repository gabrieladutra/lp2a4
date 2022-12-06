package lp2a4.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Por se tratar de um CRUD sem regras de negócio, o objeto implementado é um simples POJO.
 * 
 * Em outras circunstâncias pode ser necessário utilizam uma classe que possua outros métodos.
 * 
 * Para entender melhor essa discussão poderá procurar por modelo anêmico X modelo rico.
 * 
 * @author diego
 *
 */
@Entity
@Table(name="aluno")
public class AlunoPOJO {
	
	@Id
	@Column
	private String matricula;

	@Column(nullable = false)
	private String nome;
	
	@Column
	private String endereco;
	
	@Column(name="data_ingresso", nullable = false)
	private LocalDate dataIngresso;
	
	@Column(name="data_conclusao")
	private LocalDate dataConclusao;
	
	@ManyToMany
	@JoinTable(
			  name = "disciplinas_semestre", 
			  joinColumns = @JoinColumn(name = "matricula"), 
			  inverseJoinColumns = @JoinColumn(name = "codigo"))
	private List<Disciplina> disciplinas;
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataIngresso() {
		return dataIngresso;
	}
	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
	@Override
	public String toString() {
		return "AlunoPOJO [matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + ", dataIngresso="
				+ dataIngresso + ", dataConclusao=" + dataConclusao + "]";
	}
}
