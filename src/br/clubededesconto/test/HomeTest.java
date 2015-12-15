package br.clubededesconto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeTest {
	
	private static final String HTTP_WWW_CLUBEDEDESCONTOSOI_COM_BR = "http://www.clubededescontosoi.com.br";
	private FirefoxDriver driver;



	@Before
    public void inicializa() {
        driver = new FirefoxDriver();
        driver.get(HTTP_WWW_CLUBEDEDESCONTOSOI_COM_BR);
        
    }
	
	

	@Test
	public void DeveTerOBotaoCadastreSeAgora() {
		/* Esse é um teste considerado ruim, pois qualquer botão com 
		 essa classe acusaria erro.*/
		driver.findElement(By.className("btn-turquoise")).click();
		
		// verifica se existe cadastre-se após clicar na página
		Boolean ExisteMensagem = driver.getPageSource().contains("Cadastre-se");
		assertTrue(ExisteMensagem);
		
	}
	
	
	 @After
	    public void encerra() {
	        driver.close();
	    }

}
