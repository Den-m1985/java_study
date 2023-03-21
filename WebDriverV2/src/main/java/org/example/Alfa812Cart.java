package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Alfa812Cart {

    private WebDriver driver;
    private WebDriverWait wait;

    public Alfa812Cart() {
        // установливаем зависимость, определяющую путь к chomedriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\denis\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Den\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, 10);

        /*
        Таким образом, если элемент не найден, то драйвер будет ждать его появления
        в течении заданного времени (10 секунд) и шагом в 500 мс.
        Как только элемент будет найден, драйвер продолжит работу, однако,
        в противном случае тест упадем по истечению времени
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();  // не работает на полный экран
    }

    public void searchProduct(String article) {
        driver.get("https://alfa812.ru/");

        //WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search\"]/form/input[2]")));
        String a = "//*[@id=\"search\"]/form/input[2]";
        WebElement search = xPath(a);
        search.click();
        search.sendKeys(article);

        //WebElement buttonSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search\"]/form/input[1]")));
        String b = "//*[@id=\"search\"]/form/input[1]";
        WebElement buttonSearch = xPath(b);
        buttonSearch.click();

        //WebElement clickBay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div[2]/form/div/p/a")));
        String c = "//*[@id=\"content\"]/div/div[2]/form/div/p/a";
        WebElement clickBay = xPath(c);
        clickBay.click();

    }
    WebElement xPath(String str){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
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
