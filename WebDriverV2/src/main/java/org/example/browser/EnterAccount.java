package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterAccount {

    public EnterAccount() {
    }



    //@Test
    public void loginTest() {

        OpenBrowser openBrowser = new OpenBrowser();
        WebDriver driver = openBrowser.getDriver();
        WebDriverWait wait = openBrowser.getWait();


        LoginPage loginPage = new LoginPage(driver);
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        //String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        //Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

}
