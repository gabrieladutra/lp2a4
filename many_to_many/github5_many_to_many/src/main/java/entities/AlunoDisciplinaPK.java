package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.Embeddable;


@Embeddable
public class AlunoDisciplinaPK  implements Serializable {   
   
	         
	private String matricula;         
	private String codigo;
	private static final long serialVersionUID = 1L;

	public AlunoDisciplinaPK() {}

	

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
  
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof AlunoDisciplinaPK)) {
			return false;
		}
		AlunoDisciplinaPK other = (AlunoDisciplinaPK) o;
		return true
			&& (getMatricula() == null ? other.getMatricula() == null : getMatricula().equals(other.getMatricula()))
			&& (getCodigo() == null ? other.getCodigo() == null : getCodigo().equals(other.getCodigo()));
	}
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getMatricula() == null ? 0 : getMatricula().hashCode());
		result = prime * result + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return result;
	}    
}