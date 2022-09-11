package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Name");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Test@123");
		
		WebElement birthDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthDayDD = new Select(birthDay);		
		birthDayDD.selectByValue("10");
		
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select birthMonthDD = new Select(birthMonth);
		birthMonthDD.selectByVisibleText("Aug");
		
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select birthYearDD = new Select(birthYear);
		birthYearDD.selectByVisibleText("1990");
		
		driver.findElement(By.xpath("//input[@class='_8esa']")).click();		

	}

}
