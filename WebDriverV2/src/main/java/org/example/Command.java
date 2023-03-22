package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.browser.LoginPage;
import org.example.browser.OpenChromeBrowser;
import org.example.csvRead.CsvRead;
import org.example.oldExel.WrightOldExelArticul;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Command {

    public Command() {
    }

    public void startProgram(String pathCSV) throws IOException, CsvException {

        long start = System.nanoTime();

        // Открываем браузер
        OpenChromeBrowser openBrowser = new OpenChromeBrowser();
        openBrowser.openChrome();
        WebDriver driver = openBrowser.getDriver();
        WebDriverWait wait = openBrowser.getWait();

        // авторизуемся
        new LoginPage(driver, wait);


        String articul = "ЧЕХОЛ НА ТАБУРЕТ НА РЕЗИНКЕ МЯГКИЙ";
        // читаем csv
        CsvRead csvRead = new CsvRead(pathCSV);
        Map<String, String> data = csvRead.readCSV();


        SearchGoods searchGoods = new SearchGoods(driver, wait);
        searchGoods.searchProduct(articul);

        List<String> list = new ArrayList<>();
        new WrightOldExelArticul(list);


        long end = System.nanoTime();
        long a = end - start;

        System.out.println();
        System.out.println("У С П Е Ш Н О");
        System.out.println("Время выполнения: " + a / 1000000000 + "сек");
        System.out.println("Оля молодец");
        System.out.println();
        System.out.println("Попей чайку");
        System.out.println();

    }

}
