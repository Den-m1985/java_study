package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    private WebDriver driver;
    private WebDriverWait wait;

    public OpenBrowser() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void openChrome() {
        // установливаем зависимость, определяющую путь к chomedriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\denis\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
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

}
