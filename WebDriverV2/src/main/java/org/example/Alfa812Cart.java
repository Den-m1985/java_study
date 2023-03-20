package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Alfa812Cart {

    private WebDriver driver;
    private WebDriverWait wait;

    public Alfa812Cart() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\denis\\chromedriver_win32\\chromedriver.exe"); // Укажите путь к драйверу браузера
        driver = new ChromeDriver();
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void searchProduct(String article) {
        driver.get("https://alfa812.ru/");
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(article);
        searchBox.submit();
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'catalog-item-link')]")));
        productLink.click();
    }

    public void addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'js-add-to-cart')]")));
        addToCartButton.click();
    }

    public static void main(String[] args) {
        Alfa812Cart cart = new Alfa812Cart();
        String articul = "ЧЕХОЛ НА ТАБУРЕТ НА РЕЗИНКЕ МЯГКИЙ";
        cart.searchProduct(articul); // Укажите артикул товара
        //cart.addToCart();
        //cart.driver.quit();
    }

}
