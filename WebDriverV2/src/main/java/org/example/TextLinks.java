package org.example;

public enum TextLinks {
    ADDRESS("https://alfa812.ru/"),
    CABINET("//*[@id=\"adapt-hdr\"]/div[2]/a[2]/span"), // поле Кабинет
    LOGINFIELD("//*[@id=\"content\"]/form/input[1]"),  // поле ввода логина
    PASSWORDFIELD("//*[@id=\"content\"]/form/input[2]"),  //поле ввода пароля
    ENTERACCOUNT("//*[@id=\"adapt-hdr\"]/div[2]/a[2]/span"),  //поле входа
    OPENFILEPATH("Downloads"),  //открываем и сохраняем папку по умолчанию
    COUNROWSCSV("количество строк в csv: "),
    SHEET("Sheet1"),
    NOARTICUL("Артикулы не найденые на сайте"),
    FILENAMESAVE("Alfa-812_No_Find"),  //имя файла с ненайденными артикулами
    TEXTSAVEFILE("Файл куда сохраняем ненайденные артикулы"),
    TEXTFILEOPEN("Файл исходник:"),
    CSV("csv");

    private final String string;

    TextLinks(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
