package gestaoDeContrato;

import java.util.Date;

public class ContratoAssalariado extends Contrato {
	

private float salarioMensal;
private float percInsalubridade;
private float percPericulosidade;


public ContratoAssalariado(Date datainicio, Colaborador colaborador, float salarioMensal,
		float percInsalubridade, float percPericulosidade) {
	super(datainicio, colaborador);
	this.salarioMensal = salarioMensal;
	this.percInsalubridade = percInsalubridade;
	this.percPericulosidade = percPericulosidade;
}

public float calcVencimento(float salario) {
	float seguro;
	
	seguro = salario * 2 / 100;
	
	float vseguro = seguro;
	
	if(vseguro > 25 && vseguro <= 150) {
		
		this.ultimoVencimento = vseguro;
	}
	
	
	return this.ultimoVencimento;
	
}

public float getSalarioMensal() {
	return salarioMensal;
}

public void setSalarioMensal(float salarioMensal) {
	this.salarioMensal = salarioMensal;
}

public float getPercInsalubridade() {
	return percInsalubridade;
}

public float getPercPericulosidade() {
	return percPericulosidade;
}





}
