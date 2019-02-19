import java.util.ArrayList;

public class Carro
{
	//parâmetros de cada carro
	private String nome;
	ArrayList<String> datas = new ArrayList<String>();
	
	//getters e setters
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public ArrayList<String> getDatas()
	{
		return this.datas;
	}
	
	public void setDatas(ArrayList<String> datas)
	{
		this.datas.addAll(datas);
	}
	
}
