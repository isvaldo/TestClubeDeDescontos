package br.clubededesconto.test;

import static org.junit.Assert.*;

import org.junit.Test;
import br.clubededesconto.helpers.ReadSiteMapJson;

public class StatusDePaginasTest {

	@Test
	public void test() {
		
		String sitemap = "/home/isvaldo/workspace-eclipse/TestClubeDeDescontos/sitemap/sitemap.json";
		ReadSiteMapJson reader = new ReadSiteMapJson(sitemap);
		
		// Imprime todas as Url's
		for (String url : reader.getUrls()) {
			
			 //WebDriver driver = new FirefoxDriver();
		       // driver.get(url);
		        
		        //WebElement content = driver.findElement(By.className("wrapper"));
		        //boolean Ref = driver.getPageSource().contains("CLUBE DE DESCONTOS");
		        System.out.println(url);
		     //driver.close();   
		}
		
	}

}
