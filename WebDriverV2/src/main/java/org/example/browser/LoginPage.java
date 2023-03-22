package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    private final WebDriverWait wait;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;

        signAccount();
    }

    void signAccount() {

        TextLinks textLinks = TextLinks.ADDRESS;
        driver.get(textLinks.getString());

        // поле Кабинет
        TextLinks LinksCabinet = TextLinks.CABINET;
        String cabinet =LinksCabinet.getString();
        WebElement clickBay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cabinet)));
        clickBay.click();

        // поле ввода логина
        TextLinks LinksLogin = TextLinks.LOGINFIELD;
        String strLogin =LinksLogin.getString();
        WebElement loginField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLogin)));
        loginField.click();
        loginField.sendKeys(ConfProperties.getProperty("login"));

        // поле ввода пароля
        TextLinks LinksPassword = TextLinks.PASSWORDFIELD;
        String strPassword =LinksPassword.getString();
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strPassword)));
        passwordField.click();
        passwordField.sendKeys(ConfProperties.getProperty("password"));

        // поле Enter
        TextLinks LinksEnter = TextLinks.ENTERACCOUNT;
        String enter =LinksEnter.getString();
        WebElement enterField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(enter)));
        enterField.click();
    }


}
