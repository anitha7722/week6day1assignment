package week6.day1.assign.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DupliLeadsSteps extends BaseSteps {
	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	@When("Load URL {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}

	@And("Type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("Type password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("Click Login Button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Verify Login is successful")
	public void isSuccess() {
		WebElement eleCrm = driver.findElement(By.linkText("CRM/SFA"));
		System.out.println(eleCrm.isDisplayed());
	}

	@Then("Verify Login Failed with error (.*)$")
	public void isFailed(String errorMessage) {
		WebElement eleError = driver.findElement(By.xpath("//div[@id='errorDiv']/p[2]"));
		if (eleError.getText().equals(errorMessage)) {
			System.out.println("The error message appeared " + errorMessage);
		} else {
			System.out.println("The error message did not appear " + errorMessage);
		}
		
	}
	@When ("Click Find Leads Menu")
	public void clickfindlead() {
		driver.findElement(By.linkText("Find Leads")).click();	
	}
	@And ("Click Email Tab")
	public void emailtab() {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	
	}
	@And ("Click Find Leads Button")
	public void findleadsbutton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	}
	String firstName;

	@And("Capture First resulting Lead Name")
	public void getFirstName() {

		firstName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a"))
				.getText();
		System.out.println("First Resulting lead: " + firstName);
	}

	@And("Click Duplicate Lead Button")
	public void clickDuplicateLead() {
		driver.findElement(By.xpath("(//a[text()='Duplicate Lead'])")).click();
	}

	@And("Verify the title as Duplicate Lead")
	public void verifyTitle() {
		String getTitle = driver.findElement(By.xpath("(//div[@id='sectionHeaderTitle_leads'])")).getText();
		if (getTitle.equalsIgnoreCase("Duplicate Lead")) {
			System.out.println("Title verification success");
		} else {
			System.out.println("Incorrect Title. Have a check on it");
		}

	}

	@And("Click on CreateLead Button")
	public void clickCreateLeads() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@And("Verify the Duplicated LeadName is as same as Captured LeadName")

	public void verifyDupesCreation() {
		String duplicatedFname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		// System.out.println(duplicatedFname);

		if (firstName.equalsIgnoreCase(duplicatedFname)) {
			System.out.println("Duplicated lead name: " + firstName + "is same as captured name: " + duplicatedFname
					+ " test case passed >> Closing window");
			driver.quit();
		} else {
			System.err.println("Name not matched !! Have a check on it");
		}

	
	
}
}

