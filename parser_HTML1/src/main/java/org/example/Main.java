package org.example;

import  org.jsoup.Jsoup;

/*
Добавляем зависимости в pom.xml в <dependencies> org.jsoup
https://www.youtube.com/watch?v=wSucpFh7ouk
*/

public class Main {
    public static void main(String[] args) {
        try {
            // получение контента html страницы
            var document = Jsoup.connect("https://devmark.ru/").get();
            // выбираем заголовки с тэгом h3
            var titleElements = document.select("h3");
            // выводим на печать через цикл
            for (var element: titleElements) {
                System.out.println(element.text());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
