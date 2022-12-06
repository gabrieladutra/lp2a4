package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Veiculo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column 
	private int id;
	
	@Column
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_proprietario")
	private Proprietario proprietario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", proprietario=" + proprietario + "]";
	}	
   
}