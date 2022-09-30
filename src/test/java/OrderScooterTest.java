import io.github.bonigarcia.wdm.WebDriverManager;
import model.CustomerDataPage;
import model.MainPage;
import model.RentPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

import static model.MainPage.ORDER_BUTTON;
import static model.MainPage.ORDER_BUTTON_MIDDLE;


@RunWith(Parameterized.class)
public class OrderScooterTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final int day;
    private final String comment;
    private final String colour;
    private final By xpath;

    protected WebDriver driver;

    public OrderScooterTest(String name, String surname, String address, String metro, String phone, int day, String colour, String comment, By xpath) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.day = day;
        this.comment = comment;
        this.colour = colour;
        this.xpath = xpath;
    }


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //    WebDriverManager.firefoxdriver().setup();
      //    driver = new FirefoxDriver();
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {

        return new Object[][]{

                {"Сергей", "Хрюкин", "Мира 89", "Котельники", "89080000001", 2, "black", "Очень жду!", ORDER_BUTTON},
                {"Жанна", "Кактус", "Бочкова 35", "Южная", "89080000002", 4, "grey", "", ORDER_BUTTON_MIDDLE},
                {"Вася", "Пупкин", "Витте 1", "Спартак", "89080000003", 6, "black", "Не торопитесь!", ORDER_BUTTON},
        };
    }


    @Test
    public void OrderCheckTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookie();
        mainPage.clickOrderButton(xpath);

        CustomerDataPage customerDataPage = new CustomerDataPage(driver);
        customerDataPage.enterName(name);
        customerDataPage.enterSurname(surname);
        customerDataPage.enterAddress(address);
        customerDataPage.enterMetro(metro);
        customerDataPage.enterPhone(phone);
        customerDataPage.clickNextButton();

        RentPage rentPage = new RentPage(driver);
        rentPage.enterDate(day);
        rentPage.clickRentTime();
        rentPage.clickColourCheckbox(colour);
        rentPage.enterComment(comment);
        rentPage.clickOrderButton();
        rentPage.assertOrderMassage();
        rentPage.clickYesButton();
        rentPage.assertFinishMassage();
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

