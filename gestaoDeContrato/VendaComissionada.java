package gestaoDeContrato;

public class VendaComissionada  {
	
private int	id;
private int	mes;
private int	ano;
private float valor;
private ContratoComissionado ContratoComissionado;


public VendaComissionada(int id ,int mes, int ano, float valor,
		gestaoDeContrato.ContratoComissionado contratoComissionado) {
	super();
	this.mes = mes;
	this.ano = ano;
	this.valor = valor;
	ContratoComissionado = contratoComissionado;
}


public int getMes() {
	return mes;
}


public void setMes(int mes) {
	this.mes = mes;
}


public int getAno() {
	return ano;
}


public void setAno(int ano) {
	this.ano = ano;
}


public float getValor() {
	return valor;
}


public void setValor(float valor) {
	this.valor = valor;
}


public ContratoComissionado getContratoComissionado() {
	return ContratoComissionado;
}




public int getId() {
	return id;
}







}
