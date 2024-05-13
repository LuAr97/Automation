package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login {
    private WebDriver driver;

    @Before("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the {string} page")
    public void i_access_url_page(String url){
        driver.get(url);
    }

    @When("I enter {word} username")
    public void enter_username(String username){
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }

    @And("I enter a {word} password")
    public void enter_password(String valid){
        String password = valid.toLowerCase().equals("valid") ? "webdriver123" : "webdriver000";
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click Login button")
    public void click_button(){
       driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @Then("A pop with {word} login message should appear")
    public void validate_pop(String result){
        Alert alert = driver.switchTo().alert();
        if (result.equals("successful")){
            Assert.assertEquals(alert.getText(),"validation succeeded");
        }else if (result.equals("unsuccessful")){
            Assert.assertEquals(alert.getText(),"validation failed");
        }else{
            System.out.println("A pop with successful/unsuccessful login message should appear. [Input "+result+" not accepted]");
            Assert.assertEquals(0,1);
        }

    }


}
