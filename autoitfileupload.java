package com.autoitscriptfileupload;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoitfileupload {
	
	   protected static String url="https://www.filemail.com/share/upload-file";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
		
@Test
public void fileupload() throws InterruptedException, IOException {
	driver.get(url);
	
	WebElement titleelement=driver.findElement(By.id("FilemailSubjectURL"));
	titleelement.sendKeys("task-1");
	
	WebElement messagebox=driver.findElement(By.id("FilemailMessageToURL"));
	messagebox.sendKeys("uploading frontend task");
	
	driver.findElement(By.id("addBtn")).click();
	Thread.sleep(2000);
	
	//provide the path of the auto executable file
	String path="C:\\Program Files (x86)\\AutoIt3\\fileupload.exe";
	Thread.sleep(2000);
	ProcessBuilder builder=new ProcessBuilder(path);
	builder.start();
	WebElement sendbtn=driver.findElement(By.id("sendBtn"));
	sendbtn.click();
	Thread.sleep(2000);	
}
    
@AfterSuite
public void closechromebrowser() {
     driver.quit();
}  
}
