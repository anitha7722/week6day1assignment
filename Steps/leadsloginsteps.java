package week6.day1.assign.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class leadsloginsteps{
ChromeDriver driver;

@Given ("Launch Chrome browser")
public void Launchbrowser() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
@When("Load URL{string}")
public void loadurl(String url) {
driver.get(url);
} 
@And ("Type username as (.*)$")
public void username(String username) {
driver.findElement(By.id("username")).sendKeys(username);
} 
@And ("Type password as (.*)$")
public void password(String password) {
driver.findElement(By.id("password")).sendKeys(password);
} 
@And ("Click Login Button") 
public void login()	{
driver.findElement(By.className("decorativeSubmit")).click();

}
@And ("Click CRM/SFA")
public void crmsfa() {
    driver.findElement(By.linkText("CRM/SFA")).click();
	
}
@And ("Click on the Leads")
public void clickLeads() {
driver.findElement(By.linkText("Leads")).click();
}
@And ("Click to create leads")
public void createLeads() {
	driver.findElement(By.linkText("Create Lead")).click();
}
@And("Type CompanyName as(.*)$")
public void companyname(String companyName) {
driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
}
@And("Type Firstname as(.*)$")
public void firstName(String  firstName) {
driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
}
@And("Type Lastname as(.*)$")
public void lastName(String  lastName) {
driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
}
@Then("Click submitt")
public void submity() {
driver.findElement(By.className("smallSubmit")).click();
}
}
