import java.util.ArrayList;

public class Empresa
{
	//parâmetros de cada empresa
	private String nome;
	private String tipoCarro;
	private int valorRegularSemana;
	private int valorFidelidadeSemana;
	private int valorRegularFDS;
	private int valorFidelidadeFDS;
	private int limitePessoas;
	private ArrayList<Carro> carros = new ArrayList<Carro>();
	
	//getters e setters
	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getTipoCarro()
	{
		return this.tipoCarro;
	}

	public void setTipoCarro(String tipoCarro)
	{
		this.tipoCarro = tipoCarro;
	}

	public int getValorRegularSemana()
	{
		return this.valorRegularSemana;
	}
	
	public void setValorRegularSemana(int valorRegularSemana)
	{
		this.valorRegularSemana = valorRegularSemana;
	}
	
	public int getValorFidelidadeSemana()
	{
		return this.valorFidelidadeSemana;
	}
	
	public void setValorFidelidadeSemana(int valorFidelidadeSemana)
	{
		this.valorFidelidadeSemana = valorFidelidadeSemana;
	}
	
	public int getValorRegularFDS()
	{
		return this.valorRegularFDS;
	}
	
	public void setValorRegularFDS(int valorRegularFDS)
	{
		this.valorRegularFDS = valorRegularFDS;
	}
	
	public int getValorFidelidadeFDS()
	{
		return this.valorFidelidadeFDS;
	}
	
	public void setValorFidelidadeFDS(int valorFidelidadeFDS)
	{
		this.valorFidelidadeFDS = valorFidelidadeFDS;
	}
	
	public int getLimitePessoas()
	{
		return this.limitePessoas;
	}
	
	public void setLimitePessoas(int limitePessoas)
	{
		this.limitePessoas = limitePessoas;
	}
	
	public ArrayList<Carro> getCarros()
	{
		return this.carros;
	}
	
	public void setCarros(Carro carro)
	{
		this.carros.add(carro);
	}

}
