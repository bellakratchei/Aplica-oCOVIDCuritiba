package bellakratchei.com.github.repositorio;

import bellakratchei.com.github.models.CSVPessoa;

import java.sql.Date;
import java.util.List;

public interface RepositorioInterface {
	
	public List<?> all();
	public void insert(CSVPessoa entidade);
	public List<CSVPessoa> allDays(Date date);
	public List<CSVPessoa> allYears(Integer year);
	public void mediaF();
	public void mediaM();

}
