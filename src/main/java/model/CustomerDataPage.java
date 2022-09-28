package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CustomerDataPage {
    //Кнопка "Далее"
    public static final By NEXT_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле "Имя"
    public static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    public static final By SURNAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Метро"
    public static final By METRO_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле "Метро"
    public static final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final WebDriver driver;

    public CustomerDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();

    }

    public void enterName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);

    }

    public void enterSurname(String surname) {
        driver.findElement(SURNAME_INPUT).sendKeys(surname);

    }

    public void enterAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);

    }

    public void enterMetro(String metro) {

        driver.findElement(METRO_INPUT).click();
        driver.findElement(METRO_INPUT).sendKeys(metro);
        driver.findElement(METRO_INPUT).sendKeys(Keys.DOWN);
        driver.findElement(METRO_INPUT).sendKeys(Keys.ENTER);

    }

    public void enterPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);

    }
}
