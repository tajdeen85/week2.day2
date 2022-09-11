package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Find Leads')]")).click();
		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).click();
		
		//String actualCompany = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).getAttribute("Value");		
		//String updatedCompany = actualCompany.concat("Updated");
		
		String updatedCompany = "Company1";
		System.out.println("Updated Company Name : " + updatedCompany);
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(updatedCompany);
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//Extracting company name and trim last 8 characters, which is space followed by system generated company ID
		String companyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		companyName = companyName.substring(0,companyName.length()-8);
		
		System.out.println("View Lead - Company Name: " + companyName);
		
		if (updatedCompany.equals(companyName))
		{
			System.out.println("PASS: Updated Company Name reflected in the View Lead page.");
		}
		else
		{
			System.out.println("FAIL: Updated Company Name not not reflected in the View Lead page.");
		}
		

	}

}
