import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{

		ArrayList<String> diasFDS = new ArrayList<String>();
		ArrayList<String> diasSemana = new ArrayList<String>();
		diasFDS.add("sab");
		diasFDS.add("dom");
		diasSemana.add("seg");
		diasSemana.add("ter");
		diasSemana.add("qua");
		diasSemana.add("qui");
		diasSemana.add("sex");
		
		//instanciando empresa SouthCar
		Empresa southCar = new Empresa();
		southCar.setNome("SouthCar");
		southCar.setTipoCarro("Compacto");
		southCar.setValorRegularSemana(210);
		southCar.setValorFidelidadeSemana(150);
		southCar.setValorRegularFDS(200);
		southCar.setValorFidelidadeFDS(90);
		southCar.setLimitePessoas(4);
		
		//instanciando empresa WestCar
		Empresa westCar = new Empresa();
		westCar.setNome("WestCar");
		westCar.setTipoCarro("Esportivo");
		westCar.setValorRegularSemana(530);
		westCar.setValorFidelidadeSemana(150);
		westCar.setValorRegularFDS(200);
		westCar.setValorFidelidadeFDS(90);
		westCar.setLimitePessoas(2);
		
		//instanciando empresa NorthCar
		Empresa northCar = new Empresa();
		northCar.setNome("NorthCar");
		northCar.setTipoCarro("SUV");
		northCar.setValorRegularSemana(630);
		northCar.setValorFidelidadeSemana(580);
		northCar.setValorRegularFDS(600);
		northCar.setValorFidelidadeFDS(590);
		northCar.setLimitePessoas(7);
		
		//adicinando cada empresa ao array de empresas
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		empresas.add(southCar);
		empresas.add(westCar);
		empresas.add(northCar);
		
		//instanciando carros e adicionando-os à empresa correta
		//compactos
		Carro up = new Carro();
		up.setNome("Up");
		southCar.setCarros(up);
		
		Carro ka = new Carro();
		ka.setNome("Ka");
		southCar.setCarros(ka);
		
		//esportivos
		Carro lamborghini = new Carro();
		lamborghini.setNome("Lamborghini");
		westCar.setCarros(lamborghini);
		
		Carro ferrari = new Carro();
		ferrari.setNome("Ferrari");
		westCar.setCarros(ferrari);
		
		//SUV's
		Carro tucson = new Carro();
		tucson.setNome("Tucson");
		northCar.setCarros(tucson);
		
		Carro duster = new Carro();
		duster.setNome("Duster");
		northCar.setCarros(duster);
		
		boolean emExecucao = true;
		//se a entrada for no terminal
		while(emExecucao)
		{
			
			mensagensNovaReservaOuSair();
			int respostaUsuarioExecutarOuSair = receberSelecaoDoConsoleInt();
			
			if(respostaUsuarioExecutarOuSair == 1) {
				
				mensagensModoEntrada();
				int modoEntrada = receberSelecaoDoConsoleInt();
				
				String input = null;
				
				if(modoEntrada == 1) {
					mensagensModoEntradaConsole();
					input = receberSelecaoDoConsoleString();
				}
				else if(modoEntrada == 2) {
					mensagensModoEntradaArquivo();
					String nomeArquivo = receberSelecaoDoConsoleString();
					input = receberModoEntradaArquivo(nomeArquivo);
				}
				
				if(input != null) {
				
					String informacoes[] = input.split(":");
					String tipoCarro = informacoes[0];
					int quantidadePessoas = Integer.parseInt(informacoes[1]);
					ArrayList<String> datas = new ArrayList<String>(Arrays.asList(informacoes[2].split(",")));
					
					Carro carroMaisBarato = new Carro();
					Integer precoMaisBarato = null;
					boolean carroDisponivel = false;
					String nomeEmpresa = "";
					// Para cada empresa
					for(Empresa empresa : empresas)
					{
						// Se tipo for igual ao requerido pelo usuário e tiver limite de pessoas suficientes
						if((empresa.getTipoCarro().equals(tipoCarro)) && (quantidadePessoas <= empresa.getLimitePessoas()))
						{
							// Para cada carro da empresa
							for (Carro carro : empresa.getCarros())
							{
								// Se o carro está disponível para todas as datas requeridas
								if(Collections.disjoint(carro.getDatas(), datas))
								{
									Integer precoCarroAtual = 0;
									// Somar preço para todas as datas
									for(String data : datas)
									{
										String diaDaSemanaAtual = separaDiaDaSemana(data);
										if(diasFDS.contains(diaDaSemanaAtual))
										{
											precoCarroAtual += empresa.getValorRegularFDS();
										}
										else if(diasSemana.contains(diaDaSemanaAtual))
										{
											precoCarroAtual += empresa.getValorRegularSemana();
										}
									}
									if((precoMaisBarato == null) || (precoCarroAtual < precoMaisBarato)) {
										carroMaisBarato = carro;
										precoMaisBarato = empresa.getValorRegularSemana();
										carroDisponivel = true;
										nomeEmpresa = empresa.getNome();
									}
								}
							}
						}
						
					}
					
					if(!carroDisponivel)
					{
						System.out.println("Nenhum carro disponível para as datas desejadas");
					}
					else
					{
						carroMaisBarato.setDatas(datas);
						System.out.println(carroMaisBarato.getNome() + ": " + nomeEmpresa);
					}
				}
			}
			else if(respostaUsuarioExecutarOuSair == -1)
			{
				emExecucao = false;
			}
		}

		System.out.println("Programa encerrado");
		System.exit(0);
	}
	
	public static String separaDiaDaSemana(String data) {
		return data.split("\\(")[1].split("\\)")[0];
	}
	
	public static void mensagensNovaReservaOuSair() {

		System.out.println("- Insira \"1\" para fazer mais uma reserva");
		System.out.println("- Insira \"-1\" para sair do programa");
	}
	
	public static void mensagensModoEntrada() {

		System.out.println("Você deseja utilizar qual método para inserção dos dados?");
		System.out.println("- Insira \"1\" para utilizar o próprio terminal");
		System.out.println("- Insira \"2\" para utilizar um arquivo de texto");
		System.out.println("- Insira outro valor para voltar");
	}
	
	public static int receberSelecaoDoConsoleInt() {
		
		//instancia o scanner, para pegar os inputs
		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		//pega o input que decide se a entrada será no terminal ou em arquivo
	
		valor = entrada.nextInt();
		
		return valor;
	}
	
	public static String receberSelecaoDoConsoleString() {
		
		//instancia o scanner, para pegar os inputs
		Scanner entrada = new Scanner(System.in);
		
		//pega o input que decide se a entrada será no terminal ou em arquivo
		String valor = entrada.nextLine();
		
		return valor;
	}
	
	public static void mensagensModoEntradaConsole() {

		System.out.println("Coloque as informações no formato: ");
		System.out.println("<TIPO_CARRO>:<QUANTIDADE_PASSAGEIROS:<DATA1>,<DATA2>,<DATA3>,...");
	}
	
	public static void mensagensModoEntradaArquivo() {

		System.out.println("Insira o nome do arquivo que está no diretório em que a aplicação está sendo executada, ou o caminho absoluto para o arquivo. Favor inserir extensão do arquivo no nome.");
		System.out.println("O programa atualmente comporta apenas uma linha de entrada por arquivo, ele executará a última linha do arquivo inserido.");
	}
	
	public static String receberModoEntradaArquivo(String nomeArquivo) {

		File arquivo = new File(nomeArquivo);
		Scanner sc = null;
		String textoRetorno = null;
		
		try {
			sc = new Scanner(arquivo);
			
			while(sc.hasNext()) {
			     String texto = sc.next();
			     textoRetorno = texto;
			}
			
		} catch (FileNotFoundException e) {		
			System.out.println("Falha ao abrir o arquivo de input.");
		}
		return textoRetorno;
	}

}
