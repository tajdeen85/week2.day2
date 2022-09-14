package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9374308206");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(5000);
		
		String leadID = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).getText();
		System.out.println("Lead ID : " + leadID);
		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(5000);
		
		WebElement noResults = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		
		if (noResults.isDisplayed())
		{
			System.out.println("Lead Record successfully deleted.");
		}
		else
		{
			System.out.println("Lead Record not deleted.");
			
		}
	}

}
