package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import classes.pages.submarino;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import cucumber.runtime.CucumberException;

public class logar {

	ChromeDriver navegador;

	Yaml yaml = new Yaml(new Constructor(submarino.class));
	InputStream input = this.getClass().getClassLoader().getResourceAsStream("logar.yaml");
	submarino site = yaml.load(input);

	@Dado("^Que eu esteja na pagina do Submarino$")
	public void que_eu_esteja_na_pagina_do_Submarino() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\utils\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		navegador.get(site.getUrl());
		navegador.manage().window().maximize();

	}

	@Quando("^acessar a pagina de login$")
	public void acessar_a_pagina_de_login() throws Throwable {

		Actions actions = new Actions(navegador);
		WebElement menu = navegador.findElement(By.id(site.getHoverLogin()));
		actions.moveToElement(menu).pause(2000);

		WebElement subMenu = navegador.findElement(By.id(site.getBotaoEntrar()));
		actions.moveToElement(subMenu);
		actions.click().build().perform();

	}

	@Quando("^clicar em continuar$")
	public void clicar_em_continuar() throws Throwable {
		WebElement btn = navegador.findElement(By.id(site.getBotaoContinuar()));
		btn.click();
	}

	@Quando("^inserir minhas informacoes$")
	public void inserirMinhasInformacoes() throws Throwable {
		navegador.findElement(By.id(site.getCampoEmail())).sendKeys(site.getEmail());
		navegador.findElement(By.id(site.getCampoSenha())).sendKeys(site.getSenha());
	}

	@Quando("^inserir minhas informacoes incorretas$")
	public void inserirMinhasInformacoesIncorretas() throws Throwable {
		navegador.findElement(By.id(site.getCampoEmail())).sendKeys(site.getEmailIncorreto());
		navegador.findElement(By.id(site.getCampoSenha())).sendKeys(site.getSenha());
	}

	@Entao("^aparece a informacao 'Ola Nome'$")
	public void apareceAInformacaoOlaNome() throws Throwable {
		try {
			
			JOptionPane.showMessageDialog(null,
					"Por favor, preencha o captcha e depois clique no botão 'OK' para continuar");

			String validador = navegador.findElement(By.className("usr-nick")).getText();

			System.out.println(validador);
			assertTrue(validador.length() > 0);
			System.out.println("passou no teste");
		} catch (CucumberException e) {
			throw new CucumberException("Test Failed");
		} finally {
			 navegador.close();
		}

	}

	@Entao("^aparece a mensagem 'E-mail ou senha incorretos'$")
	public void aparece_a_mensagem_E_mail_ou_senha_incorretos() throws Throwable {
		try {
			JOptionPane.showMessageDialog(null,
					"Por favor, preencha o captcha e depois clique no botão 'OK' para continuar");

			String validadorErro = navegador.findElement(By.className("entrar-formError --zeroLeft")).getText();
			assertEquals("E-mail ou senha incorretos", validadorErro);
			System.out.println("passou no teste");
		} catch (CucumberException e) {
			throw new CucumberException("Test Failed");
		} finally {
			navegador.close();
		}

	}

}
