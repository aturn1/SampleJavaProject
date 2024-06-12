import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    public void testLoginSuccess() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("http://localhost:8080/login");

        // Find the username and password input fields
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Enter the username and password
        usernameInput.sendKeys("testuser");
        passwordInput.sendKeys("password");

        // Submit the login form
        passwordInput.submit();

        // Verify that the user is redirected to the home page
        String expectedUrl = "http://localhost:8080/home";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        // Close the browser
        driver.quit();
    }

    @Test
    public void testLoginFailure() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("http://localhost:8080/login");

        // Find the username and password input fields
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Enter an incorrect username and password
        usernameInput.sendKeys("invaliduser");
        passwordInput.sendKeys("invalidpassword");

        // Submit the login form
        passwordInput.submit();

        // Verify that the user stays on the login page and sees an error message
        String expectedUrl = "http://localhost:8080/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        WebElement errorMessage = driver.findElement(By.className("error-message"));
        assertEquals("Invalid username or password", errorMessage.getText());

        // Close the browser
        driver.quit();
    }
}