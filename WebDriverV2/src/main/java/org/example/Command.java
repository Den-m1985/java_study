package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.browser.*;
import org.example.csvRead.CsvRead;
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

        // Open browser
        OpenChromeBrowser openBrowser = new OpenChromeBrowser();
        openBrowser.openChrome();
        WebDriver driver = openBrowser.getDriver();
        WebDriverWait wait = openBrowser.getWait();

        // Open website
        new OpenWebSite(driver);

        // авторизуемся
        new LoginPage(wait);

        // читаем csv
        int cellName = 0;   // Cell with name or articular
        int cellItem = 3;   // Cell with item to order
        CsvRead csvRead = new CsvRead(pathCSV);
        Map<String, String> data = csvRead.readCSV(cellName, cellItem);

        //Map<String, String> data2 = new HashMap<>();
        //data2.put("BESTWAY Круг для плавания, 56см, ПВХ, дизайнерский", "5");

        for (Map.Entry<String, String> goods: data.entrySet()) {

            SearchGoods searchGoods = new SearchGoods(wait);
            searchGoods.searchProduct(goods.getKey());
            /*
            добавить проверку на отсутствие товара
             */
            AddGoods addGoods = new AddGoods(wait);
            addGoods.addGoods(goods.getValue());

        }

        List<String> list = new ArrayList<>();
        //new WrightOldExelArticul(list);

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
