package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*
        <dependency>
            <!-- jsoup HTML parser library @ https://jsoup.org/ -->
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.15.4</version>
        </dependency>
 */

public class EnotherWay {

    public static void main(String[] args) throws IOException {

        //Вводим артикул товара
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите артикул товара: ");
//        String articul = scanner.nextLine();
        String articul = "chehol-na-taburet-na-rezinke-myagkij";

        //Формируем URL-адрес для запроса
        //URL url = new URL("https://alfa812.ru/index.php?route=product/search&search=" + articul);
        URL url = new URL("https://alfa812.ru/products" + articul);

        //Отправляем GET-запрос на сайт и получаем HTML-код страницы
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        //Парсим страницу сайта и получаем URL-адрес товара
        Document doc = Jsoup.parse(sb.toString());
        Element productLink = doc.selectFirst(".product-list > div > div > h4 > a");
        String productUrl = productLink.attr("href");

        if (productUrl.isEmpty()) {
            System.out.println("Товар не найден");
        } else {
            //Отправляем POST-запрос на добавление товара в корзину
            URL addToCartUrl = new URL("https://alfa812.ru/ajax/cart/add");
            String payload = "product_id=" + productLink.attr("href").split("=")[1] + "&quantity=1";
            byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
            connection = (HttpURLConnection) addToCartUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(payloadBytes.length));
            connection.setDoOutput(true);
            connection.getOutputStream().write(payloadBytes);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            //Выводим результат
            System.out.println("Товар успешно добавлен в корзину");
        }

    }

}
