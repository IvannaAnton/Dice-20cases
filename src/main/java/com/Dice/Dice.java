package com.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<String> itJobs = new ArrayList<String>();
		itJobs.add("SDET");
		itJobs.add("Developer");
		itJobs.add("IT Analist");
		itJobs.add("Buisness Analist");
		itJobs.add("Senior Tester");
		itJobs.add("Scrum Master");
		itJobs.add("Java Developer");
		itJobs.add("JAVA");
		itJobs.add("Ruby");
		itJobs.add("Tester");
		itJobs.add("Web Designer");
		itJobs.add("Manual Tester");
		itJobs.add("Assistant");
		itJobs.add("HTML");
		itJobs.add("Selenium");
		itJobs.add("SQL");
		itJobs.add("UFT");
		itJobs.add("Maven");
		itJobs.add("GitHub");
		itJobs.add("Cucumber");
		try {
			for (String job : itJobs) {
				driver.get("https://dice.com");
				driver.findElement(By.id("search-field-keyword")).clear();
				driver.findElement(By.id("search-field-keyword")).sendKeys(job);
				driver.findElement(By.id("search-field-location")).clear();
				driver.findElement(By.id("search-field-location")).sendKeys("Washington,DC");
				driver.findElement(By.id("findTechJobs")).click();

				String count = driver.findElement(By.id("posiCountId")).getText();
				System.out.println(job + "-" + count);
				int i = Integer.parseInt(count.replaceAll(",",""));
				if (i > 0) {
					System.out.println("This search returned " + i + " in Washington,DC");

				} else {
					System.out.println("This search returned " + i + " in Washington,DC");
					
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Caught exception");
		}

		driver.quit();

	}

}
