package com.Dice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceWITHtextFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileReader jobs20 = new FileReader("job_titles.txt");
		BufferedReader bf = new BufferedReader(jobs20);
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String line = null;
		try {
		while ((line = bf.readLine()) != null) {
			driver.get("https://dice.com");
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(line);
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys("Washington,DC");
			driver.findElement(By.id("findTechJobs")).click();
			

			String count = driver.findElement(By.id("posiCountId")).getText();
			System.out.println(line + "-" + count);
			int i = Integer.parseInt(count.replaceAll(",",""));
			if (i > 0) {
				System.out.println("This search returned " + i + " in Washington,DC");

			} else {
				System.out.println("This search returned " + i + " in Washington,DC");
				
			}

		}
		}catch(RuntimeException e) {}
		driver.quit();

	}

}
