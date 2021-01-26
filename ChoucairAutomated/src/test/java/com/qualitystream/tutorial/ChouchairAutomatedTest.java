package com.qualitystream.tutorial;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChouchairAutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("Empleos");
	By registerPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2020/11/Recurso-6-150x150.png']");
	By applyBtnLocator = By.cssSelector("input[type='button']");
				
	By namecomplete = By.id("nombre-completo");
	By email = By.name("correo-electronico");
	By cell_phone = By.cssSelector("input[name='celular-o-telefono-de-contacto']");
	By formalStudy = By.id("que-estudios-formales-tienes-o-en-que-semestre-te-encuentras-actualmente");
	By timeExperience = By.name("que-tiempo-de-experiencia-certificada-tienes-en-pruebas-o-en-desarrollo-de-softwaresi-aplica");
	By knowAutomate = By.id("conoces-de-automatizacion-de-pruebas-te-gustaria-aprendersi-aplica");
	By wageAspiration = By.name("cual-es-tu-aspiracion-salarial");
	By timeAvailability = By.id("si-eres-seleccionado-que-disponibilidad-de-tiempo-para-ingresar-tendrias");
	By additionalMessage = By.name("mensaje-adicional");
	//By fileBtnLocator = By.cssSelector("input[type='file']");
	By sendBtnLocator = By.cssSelector("input[type='submit']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/César/eclipse-workspace/QualityStreamTutorial/src/test/resources/chromedriver/chromedriver.exe/");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com");
	}
        	
	@After
	public void tearDown() throws Exception{
		//driver.quit();
	}

	@Test
	public void RegisterUser() throws InterruptedException {
		File file = new File("C:\\Users\\César\\Desktop\\Test\\AutomatizaciónTest.docx");
		String path = file.getAbsolutePath();
		
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2200)");
        Thread.sleep(2000);
        driver.findElement(registerPageLocator).click();
        js.executeScript("window.scrollBy(0,1400)");
        Thread.sleep(2000);
        driver.findElement(applyBtnLocator).click();
        Thread.sleep(2000);
    	driver.findElement(namecomplete).sendKeys("César Javier Montaña Rojas");;
		driver.findElement(email).sendKeys("cesarmontanar@gmail.com");
		driver.findElement(cell_phone).sendKeys("3102627109");
		driver.findElement(formalStudy).sendKeys("Tecnólogo en Informática y actualmente"
											     + " estudiando Ingeniería de Sistemas");
		driver.findElement(timeExperience).sendKeys("3 años realizando pruebas funcionales, "
									   			    + "Documentación, Reporte de pruebas "
									   			    + "y Diseño de Casos");
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1000);
		driver.findElement(knowAutomate).sendKeys("Muy poco, algo de Selenium. Me gustaria aprender");
		driver.findElement(wageAspiration).sendKeys("$3'000.000");
		driver.findElement(timeAvailability).sendKeys("Inmediato");
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1000);
		driver.findElement(additionalMessage).sendKeys("Esta prueba se realizó con todas las ganas "
													   + "de aprender y demostrar que quiero ocupar "
													   + "el cargo y así mismo aprender mucho más "
													   + "de pruebas automatizadas");
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		driver.findElement(By.id("cv")).sendKeys(path);
		driver.findElement(sendBtnLocator).click();
		Thread.sleep(2000);
	}
}
