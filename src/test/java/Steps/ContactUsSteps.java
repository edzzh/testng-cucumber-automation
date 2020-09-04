package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ContactUsSteps {
    WebDriver driver;
    ArrayList<String> tabs;

    @Before()
    public void beforeHook() {
        System.out.println("Starting Chrome driver...");
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/edgarshartmanis/Desktop/Cucumber_&_TestNG/CucumberAdvancedTestNG/src/test/java/drivers/chromedriver"
        );
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("I access WebdriverUniversity homepage")
    public void iAccessWebdriverUniversityHomepage() {
        driver.get("http://www.webdriveruniversity.com/");
    }

    @When("I click on the contact us button")
    public void iClickOnTheContactUsButton() throws InterruptedException {
        driver.findElement(By.xpath("//a//h1[contains(text(), 'CONTACT US')]")).click();

        // Navigate to second active window tab with Contact Us form details
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @When("I enter a first name")
    public void iEnterAFirstName() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Edgars");
    }

    @And("I enter a last name")
    public void iEnterALastName() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Hartmanis");
    }

    @And("I enter a email address")
    public void iEnterAEmailAddress() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test124@gmail.com");
    }

    @And("I enter a comment")
    public void iEnterAComment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("I like dogs and cats! :)");
    }

    @When("I click on Submit button")
    public void iClickOnSubmitButton() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("The information should be successfully submitted via contact form")
    public void theInformationShouldBeSuccessfullySubmittedViaContactForm() {
        System.out.println("SUBMITED");
    }

    @When("I click on Reset button")
    public void iClickOnResetButton() {
        driver.findElement(By.xpath("//input[@value='RESET']")).click();
    }

    @Then("The information should be cleaned up in the form")
    public void theInformationShouldBeCleanedUpInTheForm() {
        System.out.println("RESET");
    }

    @When("I enter a invalid first name")
    public void iEnterAInvalidFirstName() {

    }

    @And("I enter a invalid last name")
    public void iEnterAInvalidLastName() {

    }

    @And("I enter a invalid email")
    public void iEnterAInvalidEmail() {
    }

    @And("I enter no comment")
    public void iEnterNoComment() {

    }

    @And("The user should be notified of the problem")
    public void theUserShouldBeNotifiedOfTheProblem() {
    }

    @After()
    public void afterHook() {
        driver.quit();
    }
}
