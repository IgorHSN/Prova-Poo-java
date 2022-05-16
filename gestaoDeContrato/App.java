package gestaoDeContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;



import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

public class App {
	static Scanner ler = new Scanner(System.in);
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	static List<Colaborador> colaboradorList = new ArrayList<Colaborador>();
	static List<Contrato> contratoList = new ArrayList <Contrato>();
	static List<VendaComissionada> vendaList = new ArrayList <VendaComissionada>();
	public static void main(String[] args) throws ParseException {
		
		
		do {
			System.out.println("\n*** Seletor de Opções ***");
			System.out.println();
			System.out.println("1 - Inserir Colaborador");
			System.out.println("2 - Registrar Contrato");
			System.out.println("3 - Consultar Contrato");
			System.out.println("4 - Encerrar Contrato");
			System.out.println("5 - Listar Colaboradores ativos");
			System.out.println("6 - Consultar contratos do colaborador");
			System.out.println("7 - Lançar venda comissionada");
			System.out.println("8 - Emitir Folha de pagamento");
			System.out.println("0 - Finalizar");
			
			System.out.print("\nOpção: ");
    	int	opcao = ler.nextInt();
	
	
    		switch (opcao) {
    		case 1:
    			
    			inserirColaborador();
    			break;
    		case 2:
    			registrarContrato();
    			break;
     		case 3:
     			consultarContrato();
    			break;
    		case 4:
    			encerrarContrato();
    			break;
    		case 5:
    			listarColaboradoresAtivos();
    			break;
    		case 6:
    			consultarContratoDoColaborador();
    			break;
    		case 7: 
    			lancarVendasComissionadas();
    			break;
    		case 8:	
    			emitirFolhaDePagamento();
    			break;
    		case 0:
				System.out.println("\n--- PROGRAMA FINALIZADO  ---");
				return;
    		default:
				System.out.println("\n--- Opção incorreta  ---");
				break;
    			
    		}
		} while (true);
		
		

	}
	
	public static void inserirColaborador() throws ParseException {
	
		while(true) {
		
		System.out.println("Insira matricula do colaborador ou [0] para encerrar");
		
		int matricula = ler.nextInt();
		
		if (matricula == 0) {
			break;
		}
		
	
		if (pesquisarColaborador(matricula) !=null) {
		System.out.println("--Colaborador ja inserido--");
		continue;
			
		}

		ler.nextLine(); 
		
		System.out.println("Digite o CPF");
		String CPF = ler.nextLine();
		
		
		if(ValidarCPF(CPF) == false) {
			System.out.println("--CPF INVALIDO--");
			continue;
		}

			
			System.out.println("Digite o nome do Colaborador");
			String nome = ler.nextLine();
			
			System.out.println("Digite a data de nascimento ex: 21/10/1980");
			String datanasc = ler.next();
			
			
			Date dataformatada;
			dataformatada = formato.parse(datanasc);
			
			
			
		int idade = calculaIdade(dataformatada);	
				
		
		if (idade <18){
			System.out.println("--Idade abaixo de 18 anos nao e permitida--");
			continue;
			
		}
					
			Colaborador colaborador = new Colaborador( matricula, CPF, nome, dataformatada);
			
			
			colaboradorList.add(colaborador);
		
			
			
		
			
		}
			
		
	}
	
	public static void registrarContrato() throws ParseException {
		
	while (true) {	
		System.out.println("Insira a matricula do Colaborador ou (0) para fechar");		
		int matricula = ler.nextInt();
		
		if(matricula == 0) {
			break;
		}
		
		Colaborador colaboradorSelecionado = pesquisarColaborador(matricula);
		
		if(colaboradorSelecionado == null) {
			System.out.println("Colaborador inexistente");
			continue;
		}
		
		
		if(colaboradorSelecionado.isSituacao() == true) {
			System.out.println("-- Colaborador ja adicionado tente de novo --");
			continue;
		}
        
        
        System.out.println("1- Assalariado \n 2- Horista \n 3- Comissionado \n 0- Sair");
        int opcao = ler.nextInt();
        
        ler.nextLine();
        
        switch (opcao) {
		case 1:
		System.out.println("-- Data inicio do contrato --");
		String dataInicio = ler.nextLine();
		Date dataformatada;
		dataformatada = formato.parse(dataInicio);
		
		Date datahoje = new Date();
		
	if(	dataformatada.before(datahoje) == true) {
		System.out.println("--Data invalida!-- \n Data anterior a atual");
		continue;
	}
	
	System.out.println("--Insira o salario mensal--");
	float salarioMensal = ler.nextFloat();
	
	System.out.println("-- Percentual Insalublidade --");
	float percInsalubridade = ler.nextFloat();
	
	System.out.println("-- Percentual Periculosidade --");
	float percPericulosidade = ler.nextFloat();
	

	colaboradorSelecionado.ativar();	

	ContratoAssalariado contratoA = new ContratoAssalariado(dataformatada, colaboradorSelecionado, salarioMensal, percInsalubridade, percPericulosidade);	
	
	contratoA.setAtivo(true);
	
	contratoList.add(contratoA);
	System.out.println("NUMERO DO CONTRATO "+contratoA.getId());
	continue;
	
		case 3:
			System.out.println("-- Data inicio do contrato --");
			String dataInicio2 = ler.nextLine();
			Date dataformatada2;
			dataformatada2 = formato.parse(dataInicio2);
			
			Date datahoje2 = new Date();
			
		if(	dataformatada2.before(datahoje2) == true) {
			System.out.println("--Data invalida!-- \n Data anterior a atual");
			continue;
		}
		System.out.println("-- Percentual de Comissao -- ");
		float percComissao = ler.nextFloat();
		
		System.out.println("-- Ajuda de Custo --");
		float ajudaCusto = ler.nextFloat();
		
		colaboradorSelecionado.ativar();
		
		ContratoComissionado contratoC = new ContratoComissionado(dataformatada2, colaboradorSelecionado, ajudaCusto, percComissao);	
		
		contratoC.setAtivo(true);
				
		contratoList.add(contratoC);
		System.out.println("NUMERO DO CONTRATO "+contratoC.getId());
		continue;
				
 		case 2:
 			System.out.println("-- Data inicio do contrato --");
			String dataInicio3 = ler.nextLine();
			Date dataformatada3;
			dataformatada3 = formato.parse(dataInicio3);
			
			Date datahoje3 = new Date();
			
		if(	dataformatada3.before(datahoje3) == true) {
			System.out.println("--Data invalida!-- \n Data anterior a atual");
			continue;
		}
			System.out.println("--Quantidades de Horas Mensais--");
			int qtdHorasMensais = ler.nextInt();
			
			System.out.println("-- Valor da Hora de Trabalho --");
			float valorHora = ler.nextInt();
		
			colaboradorSelecionado.ativar();
			
		ContradoHorista contratoH = new ContradoHorista(dataformatada3, colaboradorSelecionado, qtdHorasMensais, valorHora);
			
			contratoH.setAtivo(true);
			
			
			
			contratoList.add(contratoH);
			System.out.println("NUMERO DO CONTRATO "+contratoH.getId());
			continue;
			
		case 0:
			System.out.println("\n--- PROGRAMA FINALIZADO  ---");
			return;
		default:
			System.out.println("\n--- Opção incorreta  ---");
			continue;	
        }	
      }
			 
				
	}
	
	public static void consultarContrato() {
		
	while(true) {	
		
	System.out.println("--Insira o ID do contrato ou (0) para encerrar--");	
	int id = ler.nextInt();
	
	if(id == 0) {
		break;
	}
	
	
	Contrato contratoEncontrado = pesquisarContrato(id);
	
	if (contratoEncontrado == null) {
		System.out.println("Contrato nao encontrado");
		continue;
	}
	
	for(Contrato contrato : contratoList) {
		if(contrato.getId() == contratoEncontrado.getId()) {
			System.out.println("-- DATA DO INICIO DO CONTRATO --" +contrato.getDatainicio());
			
		if(contrato.isAtivo() == true) {	
			System.out.println("-- O CONTRATO ESTA ATIVO --");
		}
			
						
		if(contrato.isAtivo() == false) {	
			System.out.println("-- O CONTRATO ESTA DESATIVADO --");
			System.out.println("-- DATA DO ENCERRAMENTO --" +contrato.getDataencerramento());
		}
		
		if(contrato instanceof ContratoAssalariado == true) {
			System.out.println("-- CONTRATO ASSALARIADO");
		}
		
		if(contrato instanceof ContratoComissionado == true) {
			System.out.println("-- CONTRATO COMISSIONADO");
		}
		
		if(contrato instanceof ContradoHorista == true) {
			System.out.println("-- CONTRATO HORISTA --");
			
		}
		
				
		}
	}
		
		
		
		
		
		
	}
	}
	
	public static void encerrarContrato() throws ParseException {
		
	while(true) {	
		System.out.println("-- INFORME O ID DO CONTRATO ou (0) para desistir--");
		int id = ler.nextInt();
		
		if(id == 0) {
			break;
		}
		
	Contrato contratoEncontrado = pesquisarContrato(id);
	
	if (contratoEncontrado == null) {
		System.out.println("Contrato nao encontrado");
		continue;
	}
	
	if (contratoEncontrado.isAtivo() == false) {
		System.out.println(" CONTRATO JA ESTA DESATIVADO");
		continue;
	}
	
	System.out.println("-- INSIRA A DATA DE ENCERRAMENTO --");
	
	String dataEncerramento = ler.nextLine();
	Date dataformatada;
	dataformatada = formato.parse(dataEncerramento);
	
	Date datahoje = new Date();  
	
	if(dataformatada.after(datahoje)) {
		System.out.println("-- DATA INVALIDA! --");
		continue;
	}
	
	contratoEncontrado.encerrarContrato(dataformatada);	
		
		contratoEncontrado.getColaborador().getMatricula();
		
		
	}
		
		
	}
	
	public static void listarColaboradoresAtivos() {
		
		while (true) {
			
			System.out.println("--Insira a matricula do colaborador ou (0) --");	
			int matricula = ler.nextInt();
			
			if(matricula == 0) {
				break;
			}
			
			Colaborador colaboradorEncontrado = pesquisarColaborador(matricula);
			
			if (colaboradorEncontrado == null) {
				System.out.println("Colaborador nao encontrado");
				continue;
			}	
			
			if(colaboradorEncontrado.isSituacao() == false) {
				System.out.println("-- ESSE COLABORADOR NAO ESTA ATIVO --");
				continue;
				
			}
			
			System.out.println("-- CPF --" +colaboradorEncontrado.getCpf());
			System.out.println("-- MATRICULA --" +colaboradorEncontrado.getMatricula());
			System.out.println("-- NOME --" +colaboradorEncontrado.getNome());
			
			
			
			
		}
			
			}
	
	public static void consultarContratoDoColaborador() {
	
		while(true) {
		
	System.out.println("Insira matricula do colaborador ou (0) para fechar");	
	int matricula = ler.nextInt();
	
	if(matricula ==0) {
		break;
	}
	
	Colaborador colaboradorEncontrado = pesquisarColaborador(matricula);
	
	if(colaboradorEncontrado == null) {
		System.out.println("--Colaborador nao encontrado--");
		continue;
	}
	
	if(colaboradorEncontrado.isSituacao() == false) {
		System.out.println("--COLABORADOR AINDA NAO EFETIVADO--");
		continue;
	}
	
	
	
	for(Contrato contratoColab : contratoList) {
		if(contratoColab.getColaborador().getMatricula() == colaboradorEncontrado.getMatricula()) {
			System.out.println("--CPF-- " +colaboradorEncontrado.getCpf());
			System.out.println("--NOME-- " +colaboradorEncontrado.getNome());
			System.out.println("--MATRICULA-- " +colaboradorEncontrado.getMatricula());
			System.out.println("--SITUACAO-- " +colaboradorEncontrado.isSituacao());
			System.out.println("-- DATA DO INICIO DO CONTRATO-- " +contratoColab.getDatainicio());
			
			
			System.out.println("--ID DO CONTRATO-- " + contratoColab.getId());
			
			if(contratoColab instanceof ContratoAssalariado == true) {
				System.out.println("-- CONTRATO ASSALARIADO");
			}
			
			if(contratoColab instanceof ContratoComissionado == true) {
				System.out.println("-- CONTRATO COMISSIONADO");
			}
			
			if(contratoColab instanceof ContradoHorista == true) {
				System.out.println("-- CONTRATO HORISTA --");
				
			}
			
			if(contratoColab.isAtivo() == false) {
				System.out.println("--CONTRATO DESATIVADO--");
				System.out.println("--DATA DE ENCERRAMENTO-- " +contratoColab.getDataencerramento());
				
			}
									
			
		}
		
	}
	
	}	
		
	}
	
	public static void lancarVendasComissionadas() {
		while(true) {
		System.out.println("--Informe o ID ou (0) para encerrar");	
		int id = ler.nextInt();
		
		if(id == 0) {
			break;
		}
		
	Contrato contratoEncontrado = pesquisarContrato(id);
	

	if(contratoEncontrado == null) {
		System.out.println("--Contrato Inexistente--");
		continue;
	}
	if(contratoEncontrado.isAtivo() == false) {
		System.out.println("--Contrato Encerrado--");
		continue;
	}
	
	if(contratoEncontrado instanceof ContratoComissionado != true) {
		System.out.println("--Tipo do contrato incompativel para essa operacao");
		continue;
	}
	
	if(contratoEncontrado instanceof ContratoComissionado == true) {
	
	
	System.out.println("Informe o id da venda");	
	int idV = ler.nextInt();
	
	System.out.println("--Informe o mes-- Ex: 1,2...--");
	int mes = ler.nextInt();
	
	System.out.println("--Informe o ano--");
	int ano = ler.nextInt();
	
	System.out.println("--Informe o Valor");
	float valor = ler.nextInt();
	
	ContratoComissionado contratoC = (ContratoComissionado) contratoEncontrado;
	
	
	
	VendaComissionada vendaCOM = new VendaComissionada(idV, mes,ano ,valor, contratoC);
	vendaList.add(vendaCOM);
	
	
		
	}
				
		
		
		}
	}
	
	public static void emitirFolhaDePagamento() {
	while(true) {	
		System.out.println("--Digite o mes ou (0) --");
		int mes = ler.nextInt();
		if(mes == 0) {
			break;
		}
		
		System.out.println("--Digite o Ano--");
		int ano = ler.nextInt();
		
	for(Contrato contrato : contratoList) {	
			
			
			
			
			
	if(contrato instanceof ContratoAssalariado == true) {
				System.out.println("-- CONTRATO ASSALARIADO");
				
				System.out.println("--MATRICULA-- " + contrato.getId());
				
				System.out.println("--NOME-- " + contrato.getColaborador().getNome());
				
				ContratoAssalariado contratoA = (ContratoAssalariado) contrato;		
				
				
				float salarioA = contratoA.getSalarioMensal() + contratoA.getPercPericulosidade() + contratoA.getPercInsalubridade();
				contratoA.calcVencimento(salarioA);
				
				System.out.println("--SALARIO ASSALARIADO--" + salarioA);
				System.out.println("--SEGURO--" + contratoA.calcVencimento(salarioA));
				
			}
			
	
			
	if(contrato instanceof ContradoHorista == true) {
				System.out.println("-- CONTRATO HORISTA --");
				
				System.out.println("--MATRICULA-- " + contrato.getId());
				
				System.out.println("--NOME-- " + contrato.getColaborador().getNome());
				
					ContradoHorista contratoH = (ContradoHorista) contrato;		
		 
			float salarioH = contratoH.getHorasMes() * contratoH.getValorHora();
				
				
		
				System.out.println("--SALARIO HORISTA--" +salarioH);
				System.out.println("--SEGURO--" + contratoH.calcVencimento(salarioH));
				
				
			}
	
	
	if(contrato instanceof ContratoComissionado == true) {
		System.out.println("-- CONTRATO COMISSIONADO");
		
		System.out.println("--MATRICULA-- " + contrato.getId());
		
		System.out.println("--NOME-- " + contrato.getColaborador().getNome());
		
		ContratoComissionado contratoC = (ContratoComissionado) contrato;
		
		
			System.out.println("-- INSIRA O ID DA VENDA OU (0)");
			int idv = ler.nextInt();
			
			if(idv == 0) {
				break;
				
			}
			
			VendaComissionada VendaC = pesquisarVenda(idv);
			
			if(VendaC == null) {
				System.out.println("Venda nao encontrada");
				continue;
			}
			
			float salario = (VendaC.getValor() * contratoC.getPercComissao() /100) + contratoC.getAjudaCusto();
			contratoC.calcVencimento(salario);
			
			System.out.println("--SALARIO COMISSIONADO-- " + salario);
			System.out.println("--SEGURO--" + contratoC.calcVencimento(salario));			
		}
						
		
		
	}
	
			
		System.out.println("ANO " + ano);
		System.out.println("MES " + mes);
			
		}
	}
	

		
				
			
					
		
		
		
	public static boolean ValidarCPF(String CPF) {
	       
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

       
        
        
        try {
        
        	
        	
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            	
            	
      
            	
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // 
            
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        
            
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }	
	
	
	
	public static Contrato pesquisarContrato(int id) {
for (Contrato contract : contratoList) {
			
			if (contract.getId() == id) {
				return contract;
			}
			
		}
		return null;
	}
	
	public static VendaComissionada pesquisarVenda(int id) {
		for (VendaComissionada vendaC : vendaList) {
			
			if(vendaC.getId() == id) {
				return vendaC;
			}
			
		}
		return null;
	}
	
	
	
	public static Colaborador pesquisarColaborador(int matricula) {
		for (Colaborador colab : colaboradorList) {
			
			if (colab.getMatricula() == matricula) {
				return colab;
			}
			
		}
		return null;
	}
	
	public static int calculaIdade(java.util.Date dataNasc){

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNasc);

		 

		

		Calendar today = Calendar.getInstance();

		 

	

		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		 

		dateOfBirth.add(Calendar.YEAR, age);

		 

		

		if (today.before(dateOfBirth)) {

		age--;

		}

		return age;

		}
	

	
	
	public static int calculoIdade(Date dataNascimento) {
	    Calendar hoje = Calendar.getInstance();
	    int idade = hoje.get(Calendar.YEAR) - dataNascimento.getYear();
	    int mesAtual = hoje.get(Calendar.MONTH) + 1;
	    if ((mesAtual == dataNascimento.getMonth() && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.getDay())
	        || mesAtual < dataNascimento.getMonth()) {
	        idade--;
	    }
	    return idade;
	}
	
	
	
	
	
	
	
	

}
