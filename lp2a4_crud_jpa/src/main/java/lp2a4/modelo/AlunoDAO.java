package lp2a4.modelo;

public interface AlunoDAO {
	
	public boolean create(AlunoPOJO aluno);
	public AlunoPOJO retrieve(String matricula);
	public boolean update(AlunoPOJO aluno);
	public boolean delete(String matricula);
	
	public static AlunoDAO getInstance() {
		return new AlunoPropertiesDAO();
	}	
}