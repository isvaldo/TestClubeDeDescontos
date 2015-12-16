package br.clubededesconto.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@Test
	public void DeveCarregarDescontosAteOfinal(){
		WebElement BotaoSemMaisDescontos = (new WebDriverWait(driver, 10))
				.until(new ExpectedCondition<WebElement>(){
				@Override
				public WebElement apply(WebDriver driver) {
					
					WebElement botao = driver.findElement(By.id("carregar-botao"));
					// Outro test mal elaborado, pois estou me guiando pelo conteudo do texto
					// do botão. assim que o texto mudar, o teste vai acusar falha
					// uma boa opção seria colocar todos os textos em constantes
					if (botao.getAttribute("innerHTML").equals("Não existem mais ofertas.")){
						return botao;
					}else {
						botao.click();
						return null;
					}
					
				}});
		
		assertTrue(BotaoSemMaisDescontos.getAttribute("innerHTML").equals("Não existem mais ofertas."));
		
	}
	
	
	 @After
	    public void encerra() {
	        
	    }

}
