package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /*
    Метод «setup()» пометим аннотацией Junit «@BeforeClass»,
    которая указывает на то, что метод будет выполняться
    один раз до выполнения всех тестов в классе.
     */

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {

        //определение пути до драйвера и его настройка
        //установить зависимость, определяющую путь к chomedriver
        // (в ОС семейства Windows дополнительно необходимо указывать расширение .exe)
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        System.out.println(ConfProperties.getProperty("chromedriver"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver = new ChromeDriver();

        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 10 сек.
        /*
        Случается, что элементы на страницах доступны не сразу,
        и необходимо дождаться появления элемента. Для этого существуют ожидания.
        Они бывают двух видов: явные и неявные. В примере будет использовано
        неявное ожидание Implicitly Wait, которое задается вначале теста
        и будет работать при каждом вызове метода поиска элемента:
        Таким образом, если элемент не найден, то драйвер будет ждать
        его появления в течении заданного времени (10 секунд) и шагом в 500 мс.
        Как только элемент будет найден, драйвер продолжит работу, однако,
        в противном случае тест упадем по истечению времени.
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }


    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
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
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user); }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); }

}
