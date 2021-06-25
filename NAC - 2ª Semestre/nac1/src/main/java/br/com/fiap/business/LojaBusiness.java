package br.com.fiap.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.liquibase.LiquibaseEndpoint.ChangeSet;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.LojaModel;
import br.com.fiap.repository.LojaRepository;

@Component
public class LojaBusiness {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public LojaModel applyBusiness(LojaModel lojaModel) throws ResponseBusinessException {
		String url = changeUrlToLowerCase(lojaModel.getURL());
		lojaModel.setURL(url);
		
		verifyUrl(lojaModel.getURL());
		
		return lojaModel;
	}

	private String changeUrlToLowerCase(String url) {
		// TODO Auto-generated method stub
		return url.toLowerCase();
	}
	
	private void verifyUrl(String url) throws ResponseBusinessException{
		String urlLoja = url.toLowerCase();
	    Pattern urlCerta = Pattern.compile("http://|https://www");
		Matcher verifica = urlCerta.matcher(urlLoja);
		if(!verifica.find()) {
		  	throw new ResponseBusinessException("Erro, URL deve conter http://www ou  https://www");
		}
	}
	
}
