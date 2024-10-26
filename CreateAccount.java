package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.Base;

public class CreateAccount extends Base {
    // Locators
    private By firstname = By.xpath("//input[@id='firstname']");
    private By lastname = By.xpath("//input[@id='lastname']");
    private By emailAddress = By.xpath("//input[@id='email_address']");
    private By password = By.xpath("//input[@id='password']");
    private By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    private By createAccountButton = By.xpath("//button[@title='Create an Account']");

    // Constructor
    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public WebElement firstnameField() {
        return driver.findElement(firstname);
    }

    public WebElement lastnameField() {
        return driver.findElement(lastname);
    }

    public WebElement emailAddressField() {
        return driver.findElement(emailAddress);
    }

    public WebElement passwordField() {
        return driver.findElement(password);
    }

    public WebElement confirmPasswordField() {
        return driver.findElement(confirmPassword);
    }

    public WebElement createAccountButton() {
        return driver.findElement(createAccountButton);
    }

    public void createNewAccount(String firstName, String lastName, String email, String pwd, String confirmPwd) {
        firstnameField().sendKeys(firstName);
        lastnameField().sendKeys(lastName);
        emailAddressField().sendKeys(email);
        passwordField().sendKeys(pwd);
        confirmPasswordField().sendKeys(confirmPwd);
        createAccountButton().click();
    }
}
