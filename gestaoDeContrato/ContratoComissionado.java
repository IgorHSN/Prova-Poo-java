package gestaoDeContrato;

import java.util.Date;

public class ContratoComissionado extends Contrato {
	

private float percComissao;
private float ajudaCusto;




public ContratoComissionado(Date datainicio, Colaborador colaborador, float percComissao, float ajudaCusto) {
	super(datainicio, colaborador);
	this.percComissao = percComissao;
	this.ajudaCusto = ajudaCusto;
}



public float calcVencimento(float salario) {
	
	float	percAjudacusto = (float) (this.ajudaCusto * 0.5 / 100);
	float 	seguro = salario * 1 / 100;
	
	this.ultimoVencimento = seguro + percAjudacusto;
	
	
	return this.ultimoVencimento;
	
}







public float getPercComissao() {
	return percComissao;
}



public float getAjudaCusto() {
	return ajudaCusto;
}



}
