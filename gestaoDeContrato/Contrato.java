package gestaoDeContrato;

import java.util.Date;

public abstract class Contrato {
	
	
private static int sequence = 1;

private int id;
protected float ultimoVencimento;
private Date datainicio;
private Date dataencerramento;
private Colaborador colaborador;
private boolean ativo;




public Contrato(Date datainicio, Colaborador colaborador) {
	super();
	
	this.id = sequence++;	
	this.datainicio = datainicio;
	this.colaborador = colaborador;
	this.ativo = false;
}


public Date encerrarContrato(Date dataDemissao) {
	this.ativo = false;
	this.colaborador.desativar();
	
	return dataDemissao;
	
	
}


public Date getDatainicio() {
	return datainicio;
}


public void setDatainicio(Date datainicio) {
	this.datainicio = datainicio;
}


public Colaborador getColaborador() {
	return colaborador;
}


public void setColaborador(Colaborador colaborador) {
	this.colaborador = colaborador;
}


public boolean isAtivo() {
	
	return ativo;
}


public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}


public int getId() {
	return id;
}


public Date getDataencerramento() {
	return dataencerramento;
}


public float getUltimoVencimento() {
	return ultimoVencimento;
}





}
