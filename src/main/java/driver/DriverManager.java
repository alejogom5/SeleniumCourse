package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    public static WebDriver driver;

    // Metodo para obtener instancia del driver
    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // 🔎 Detectar si está corriendo en Jenkins/CI
            if (System.getenv("JENKINS_HOME") != null || System.getenv("CI") != null) {
                System.out.println("Ejecutando en Jenkins → Usando Chrome en modo headless");
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");
            } else {
                System.out.println("Ejecutando en local → Usando Chrome normal");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");
            }

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
