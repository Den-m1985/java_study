package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoods {
    public WebDriver driver;
    private final WebDriverWait wait;

    public SearchGoods(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }


    public void searchProduct(String article) {
        //driver.get("https://alfa812.ru/");

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
}
