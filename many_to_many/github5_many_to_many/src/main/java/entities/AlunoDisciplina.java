package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="aluno_has_disciplina")

public class AlunoDisciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AlunoDisciplinaPK matricula_codigo;
	
	@MapsId("matricula")	
	@ManyToOne
	@JoinColumn(name="matricula")
	private Aluno aluno;  
	
	@MapsId("codigo")
	@JoinColumn(name="codigo")
	@ManyToOne
	private Disciplina disciplina;
	
	private int nota;
	
	
	public AlunoDisciplina() {
		super();
	}

	public AlunoDisciplinaPK getMatricula_codigo() {
		return matricula_codigo;
	}

	public void setMatricula_codigo(AlunoDisciplinaPK matricula_codigo) {
		this.matricula_codigo = matricula_codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}     
}