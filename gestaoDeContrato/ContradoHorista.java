package gestaoDeContrato;

import java.util.Date;

public class ContradoHorista extends Contrato {
	

private int horasMes;
private float valorHora;

public ContradoHorista(Date datainicio, Colaborador colaborador, int horasMes, float valorHora) {
	super(datainicio, colaborador);
	this.horasMes = horasMes;
	this.valorHora = valorHora;
}

public float calcVencimento(float salario) {
	
	if (salario <= 5000) {
		float seguro = salario * 2 /100; 	
		
		this.ultimoVencimento = seguro;
	}
	
	if (salario > 5000) {
		float seguro = (float) (salario * 2.5 /100);
		
		this.ultimoVencimento = seguro;
	}

	
	return this.ultimoVencimento;
	
}

public int getHorasMes() {
	return horasMes;
}

public float getValorHora() {
	return valorHora;
}
	



}
