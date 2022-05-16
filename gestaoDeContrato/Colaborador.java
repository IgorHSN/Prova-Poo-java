package gestaoDeContrato;

import java.util.Date;


public class Colaborador  {	
	
private int matricula;	
private String cpf;
private String nome;
private Date dataNasc;
private boolean situacao;

public Colaborador(int matricula, String cpf,
		String nome, Date dataNasc) {
	this.matricula = matricula;
	this.cpf = cpf;
	this.nome = nome;
	this.dataNasc = dataNasc;
	this.situacao = false;
}



public void ativar() {
this.situacao = true;	
	
}

public void desativar() {
this.situacao = false;
	
}



public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Date getDataNasc() {
	return dataNasc;
}

public void setDataNasc(Date dataNasc) {
	this.dataNasc = dataNasc;
}

public int getMatricula() {
	return matricula;
}

public boolean isSituacao() {
	return situacao;
}











	
	

}
