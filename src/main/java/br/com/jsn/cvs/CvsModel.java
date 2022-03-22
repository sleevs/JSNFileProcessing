package br.com.jsn.cvs;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CvsModel  {
	

	@CsvBindByName(column = "agencia", required = true)
    private String agencia;

	@CsvBindByName(column = "conta", required = true)
    private String conta;

	@CsvBindByName(column = "saldo", required = true)
    private String saldo;

	@CsvBindByName(column = "status", required = true)
    private String status;

    
    public CvsModel() {
    	
    }


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public String getSaldo() {
		return saldo;
	}


	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
