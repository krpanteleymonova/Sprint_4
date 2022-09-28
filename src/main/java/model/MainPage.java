package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    //URL Страницы
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка "да все привыкли"
    public static final By COOKIE_CLICK = By.id("rcc-confirm-button");
    //Кнопка "Заказать"
    public static final By ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать"  середине экрана
    public static final By ORDER_BUTTON_MIDDLE = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Вопросы о важном
    public static final By QUESTION_HOW_MUCH = By.id("accordion__heading-0");
    public static final By QUESTION_WANT_SOME_SCOOTERS = By.id("accordion__heading-1");
    public static final By QUESTION_RENTAL_TIME = By.id("accordion__heading-2");
    public static final By QUESTION_ORDER_TODAY = By.id("accordion__heading-3");
    public static final By QUESTION_RETURN_EARLY = By.id("accordion__heading-4");
    public static final By QUESTION_CHARGE = By.id("accordion__heading-5");
    public static final By QUESTION_CANCEL_ORDER = By.id("accordion__heading-6");
    public static final By QUESTION_BEYOND_MKAD = By.id("accordion__heading-7");
    // Ответы на вопросы о важном
    public static final By ANSWER_HOW_MUCH = By.id("accordion__panel-0");
    public static final By ANSWER_WANT_SOME_SCOOTERS = By.id("accordion__panel-1");
    public static final By ANSWER_RENTAL_TIME = By.id("accordion__panel-2");
    public static final By ANSWER_ORDER_TODAY = By.id("accordion__panel-3");
    public static final By ANSWER_RETURN_EARLY = By.id("accordion__panel-4");
    public static final By ANSWER_CHARGE = By.id("accordion__panel-5");
    public static final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    public static final By ANSWER_BEYOND_MKAD = By.id("accordion__panel-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void open() {
        driver.get(PAGE_URL);

    }

    public void clickCookie() {
        driver.findElement(COOKIE_CLICK).click();

    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();

    }

    public void clickOrderButtonMiddle() {
        driver.findElement(ORDER_BUTTON_MIDDLE).click();

    }

}
