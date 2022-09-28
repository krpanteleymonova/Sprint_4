package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class RentPage {

    //Поле "Дата"
    public static final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле "Срок аренды"
    public static final By RENT_TIME_INPUT = By.xpath(".//span[@class='Dropdown-arrow']");
    //1 сутки в поле "Срок аренды"
    public static final By RENT_TIME_ONE_DAY_INPUT = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //Поле "Комментарий для курьера"
    public static final By COMMENT_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    public static final By ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Окно "Хотите оформить заказ?"
    public static final By ORDER_MESSAGE = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //Окно "Заказ оформлен"
    public static final By ORDER_FINISH_MESSAGE = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //Кнопка "Да"
    public static final By YES_BUTTON = By.xpath(".//button[text()='Да']");


    private final WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterDate(int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
        String date = LocalDate.now().plusDays(day).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
        driver.findElement(DATE_INPUT).sendKeys(date);
        driver.findElement(DATE_INPUT).sendKeys(Keys.ENTER);
    }

    public void enterComment(String message) {
        driver.findElement(COMMENT_INPUT).sendKeys(message);

    }


    public void clickColourCheckbox(String colour) {

        By BLACK_CHECKBOX = By.xpath(String.format(".//input[@id='%s']",colour));
        System.out.println(BLACK_CHECKBOX);
        driver.findElement(BLACK_CHECKBOX).click();

    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();

    }

    public void clickRentTime() {
        driver.findElement(RENT_TIME_INPUT).click();
        driver.findElement(RENT_TIME_ONE_DAY_INPUT).click();

    }

    public void clickYesButton() {
        driver.findElement(YES_BUTTON).click();

    }

    public void assertOrderMassage() {
        String actualString = driver.findElement(ORDER_MESSAGE).getText();
        assertTrue(actualString.contains("Хотите оформить заказ?"));


    }
    public void assertFinishMassage() {
        String actualString = driver.findElement(ORDER_FINISH_MESSAGE).getText();
        assertTrue(actualString.contains("Заказ оформлен"));
        System.out.println(actualString);


    }

}
