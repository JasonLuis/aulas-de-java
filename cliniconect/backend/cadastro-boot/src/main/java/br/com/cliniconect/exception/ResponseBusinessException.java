package br.com.cliniconect.exception;

public class ResponseBusinessException extends Exception{
	
	private String mensagem;
	
	public ResponseBusinessException(String mensagem) {
		super();
		this.setMensagem(mensagem);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
