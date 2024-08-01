package magentoWebSiteTesting;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {

	WebDriver driver = new ChromeDriver();

	String myWebsite = "https://magento.softwaretestingboard.com/";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	Random rand = new Random();

	String password = "iLoveMyMom!234k";

	String emailAddressToLogin = "";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(myWebsite);

	}

	@Test(priority = 1)
	public void CreateAnAccount() {

		// xpath
//		WebElement createAccountPage = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));

		// partialLinkText

//		WebElement createAccountPage = driver.findElement(By.partialLinkText("Account"));

		// linkText
		WebElement createAccountPage = driver.findElement(By.linkText("Create an Account"));
//
		createAccountPage.click();

		// example
//		String[] thearrayNameforExampleFirstNames = { "firstname", "firstname2", "firstname3" };

		// first names
		String[] first_Names = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace" };
		// last names
		String[] Last_Names = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };

		int randomIndexForTheFirstName = rand.nextInt(first_Names.length);
		int randomIndexForTheLastName = rand.nextInt(Last_Names.length);

		System.out.println(randomIndexForTheFirstName);
		System.out.println(randomIndexForTheLastName);

		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		WebElement emailAddressInput = driver.findElement(By.id("email_address"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		String firstname = first_Names[randomIndexForTheFirstName];

		String lastname = Last_Names[randomIndexForTheLastName];

		System.out.println(firstname);
		System.out.println(lastname);
		int randomnumber = rand.nextInt(9876);

		String domainName = "@gmail.com";

		firstNameInput.sendKeys(firstname);
		lastNameInput.sendKeys(lastname);
		emailAddressInput.sendKeys(firstname + lastname + randomnumber + domainName);
		passwordInput.sendKeys(password);
		confirmPassword.sendKeys(password);
		createAccountButton.click();

		emailAddressToLogin = firstname + lastname + randomnumber + domainName;

	}

	@Test(priority = 2)
	public void logOut() {
		driver.get(logoutPage);

	}

	@Test(priority = 3)
	public void loginTest() {
		WebElement LoginPage = driver.findElement(By.linkText("Sign In"));
		LoginPage.click();

		WebElement EmailLoginInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.cssSelector(".action.login.primary"));

		
		
		EmailLoginInput.sendKeys(emailAddressToLogin);
		passwordInput.sendKeys(password);
		LoginButton.click();
	}

}
