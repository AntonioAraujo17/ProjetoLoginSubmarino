package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class logar {
	private WebDriver navegador;
	
	@Given("^Que eu esteja na pagina do Submarino$")
	
	public void que_eu_esteja_na_pagina_do_Submarino() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\suporte\\chromedriver.exe");
        navegador = new ChromeDriver();
       navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        navegador.get("https://www.submarino.com.br/");
        navegador.manage().window().maximize();
		
	}

	@When("^acessar a pagina de login$")
	public void acessar_a_pagina_de_login() throws Throwable {
		
		Actions actions = new Actions(navegador);
        WebElement menu = navegador.findElement(By.id("h_user"));
        actions.moveToElement(menu).pause(2000);
        
        
         WebElement subMenu = navegador.findElement(By.id("h_usr-signin"));
         actions.moveToElement(subMenu);
         actions.click().build().perform();
		
	}

	@When("^clicar em continuar$")
	public void clicar_em_continuar() throws Throwable {
		WebElement btn = navegador.findElement(By.id("login-button"));
        btn.click();
	}

	@Then("^aparece a mensagem 'E-mail ou senha incorretos'$")
	public void aparece_a_mensagem_E_mail_ou_senha_incorretos() throws Throwable {
		WebElement btn = navegador.findElement(By.id("login-button"));
		while((btn.isEnabled())) {
        	int i = 1000;
        	Thread.sleep(i);
        	if(!(btn.isDisplayed())) {
        		WebElement mensagemEmail = navegador.findElement(By.className("entrar-formError --zeroLeft"));
        		assertEquals("E-mail ou senha incorretos", mensagemEmail.getText());
                navegador.quit();
        		break;
        	}
        	i++;
        }

	}
	
	@When("^inserir minhas informacoes$")
	public void inserirMinhasInformacoes() throws Throwable {
		navegador.findElement(By.id("email-input")).sendKeys("willianstech@gmail.com");
		navegador.findElement(By.id("password")).sendKeys("653498ww");
	}

	@When("^inserir minhas informacoes incorretas$")
	public void inserirMinhasInformacoesIncorretas() throws Throwable {
		navegador.findElement(By.id("email-input")).sendKeys("45893513822@gmail.com");
		navegador.findElement(By.id("password")).sendKeys("653498w");
	}
	
	@Then("^aparece a informacao 'Ola Nome'$")
	public void apareceAInformacaoOlaNome() throws Throwable {
		WebElement btn = navegador.findElement(By.id("login-button"));
		
		while((btn.isEnabled())) {
        	int i = 1000;
        	Thread.sleep(i);
        	if(!(btn.isDisplayed())) {
        		 WebElement mensagemEmail = navegador.findElement(By.className("usr-nick"));
        		 assertEquals("Nome", mensagemEmail.getText());
                navegador.quit();
        		break;
        	}
        	i++;
        }
    
	}

}
