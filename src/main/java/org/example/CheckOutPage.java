package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class CheckOutPage {
    private WebDriver driver;

    //Localizadores
    private By proceedToCheckoutButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    private By firstNameField = By.xpath("//input[@name='billing_first_name']");
    private By lastNameField = By.xpath("//input[@name='billing_last_name']");
    private By billingCompanyField = By.xpath("//input[@name='billing_company']");
    private By dropDownCountry = By.id("billing_country");

    // Constructor
    public CheckOutPage(){
        this.driver = DriverManager.getDriver();
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterBillingCompany(String billingCompany){
        driver.findElement(billingCompanyField).sendKeys(billingCompany);
    }

    public void selectCountry(String country){
        WebElement dropdown = driver.findElement(dropDownCountry);
        Select select = new Select(dropdown);
        select.selectByVisibleText(country);
    }

    public void proceedToCheckout(){
        driver.findElement(proceedToCheckoutButton).click();
    }

}
