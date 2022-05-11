package pack01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo01 {

	@Test
	public static void acceptAlert() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		String name = "Rajesh";
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@class='btn-style']")).click();
		String text = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		Assert.assertTrue(text.contains(name));
		driver.close();

	}
}
