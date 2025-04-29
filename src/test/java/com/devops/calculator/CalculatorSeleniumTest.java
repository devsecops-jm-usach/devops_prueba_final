package com.devops.calculator;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

public class CalculatorSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Set the path for the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update this path
        WebDriverManager.chromedriver().setup();

        // Set Chrome options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU acceleration
        //options.addArguments("--window-size=1920x1080"); // Set window size (optional)
        options.addArguments("--disable-dev-shm-usage"); // Disable GPU acceleration
        options.addArguments("--no-sandbox"); // Disable GPU acceleration
        
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8080"); // URL of your Spring Boot application
    }

    @Test
    public void testAddition() {
        WebElement num1Input = driver.findElement(By.name("num1"));
        WebElement num2Input = driver.findElement(By.name("num2"));
        WebElement operationSelect = driver.findElement(By.name("operation"));
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));

        // Perform addition
        num1Input.sendKeys("5");
        num2Input.sendKeys("3");
        operationSelect.sendKeys("Add");
        calculateButton.click();

        // Verify the result
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        assertEquals("Result: 8.0", resultado.getText());
    }

    @Test
    public void testSubtraction() {
        WebElement num1Input = driver.findElement(By.name("num1"));
        WebElement num2Input = driver.findElement(By.name("num2"));
        WebElement operationSelect = driver.findElement(By.name("operation"));
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));

        // Perform subtraction
        num1Input.sendKeys("10");
        num2Input.sendKeys("4");
        operationSelect.sendKeys("Subtract");
        calculateButton.click();

        // Verify the result
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        assertEquals("Result: 6.0", resultado.getText());
    }

    @Test
    public void testMultiplication() {
        WebElement num1Input = driver.findElement(By.name("num1"));
        WebElement num2Input = driver.findElement(By.name("num2"));
        WebElement operationSelect = driver.findElement(By.name("operation"));
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));

        // Perform multiplication
        num1Input.sendKeys("3");
        num2Input.sendKeys("7");
        operationSelect.sendKeys("Multiply");
        calculateButton.click();

        // Verify the result
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        assertEquals("Result: 21.0", resultado.getText());
    }

    @Test
    public void testDivision() {
        WebElement num1Input = driver.findElement(By.name("num1"));
        WebElement num2Input = driver.findElement(By.name("num2"));
        WebElement operationSelect = driver.findElement(By.name("operation"));
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));

        // Perform division
        num1Input.sendKeys("8");
        num2Input.sendKeys("2");
        operationSelect.sendKeys("Divide");
        calculateButton.click();

        // Verify the result
        WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        assertEquals("Result: 4.0", resultado.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}