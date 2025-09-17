package tests;

import com.github.javafaker.Faker;
import org.example.CheckOutPage;
import org.example.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver.DriverManager;

import java.sql.Driver;
import java.time.Duration;


public class HomeTest {
    private HomePage homePage;
    private CheckOutPage checkOutPage;

    @BeforeMethod
    public void setUp(){
        DriverManager.getDriver().get("http://logofree.esy.es/");
        homePage = new HomePage();
    }



    @Test
    public void testGoToCheckout(){
        Faker faker = new Faker();
        String nombre = String.valueOf(faker.name());
        // Agregamos produtco
        homePage.addProductToCart();

        //Vamos al carrito
        checkOutPage = homePage.goToCart();

        //VamosAlCheckout
        checkOutPage.proceedToCheckout();

        // Completamos los campos
        checkOutPage.enterFirstName(nombre);
        checkOutPage.enterLastName("Gomez");
        checkOutPage.enterBillingCompany("Lone Wolf");
        checkOutPage.selectCountry("Colombia");


    }



    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }

}
