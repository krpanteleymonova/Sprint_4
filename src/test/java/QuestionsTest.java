import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static model.MainPage.*;

public class QuestionsTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookie();
    }

    @Test
    public void questionHowMuchCheckTest() {

        Assert.assertEquals("Вопрос некорректен!", "Сколько это стоит? И как оплатить?", driver.findElement(QUESTION_HOW_MUCH).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_HOW_MUCH).isDisplayed());
        driver.findElement(QUESTION_HOW_MUCH).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_HOW_MUCH).isDisplayed());
        Assert.assertEquals("Ответ не соответствует вопросу", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(ANSWER_HOW_MUCH).getText());
    }

    @Test
    public void questionWantSomeScootersCheckTest() {

        Assert.assertEquals("Вопрос некорректен!", "Хочу сразу несколько самокатов! Так можно?", driver.findElement(QUESTION_WANT_SOME_SCOOTERS).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_WANT_SOME_SCOOTERS).isDisplayed());
        driver.findElement(QUESTION_WANT_SOME_SCOOTERS).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_WANT_SOME_SCOOTERS).isDisplayed());
        Assert.assertEquals("Ответ не соответствует вопросу", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(ANSWER_WANT_SOME_SCOOTERS).getText());
    }

    @Test
    public void questionRentalTimeCheckTest() {

        Assert.assertEquals("Вопрос некорректен!", "Как рассчитывается время аренды?", driver.findElement(QUESTION_RENTAL_TIME).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_RENTAL_TIME).isDisplayed());
        driver.findElement(QUESTION_RENTAL_TIME).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_RENTAL_TIME).isDisplayed());
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(ANSWER_RENTAL_TIME).getText());
    }

    @Test
    public void questionOrderTodayCheckTest() {

        Assert.assertEquals("Вопрос некорректен!", "Можно ли заказать самокат прямо на сегодня?", driver.findElement(QUESTION_ORDER_TODAY).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_ORDER_TODAY).isDisplayed());
        driver.findElement(QUESTION_ORDER_TODAY).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_ORDER_TODAY).isDisplayed());
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(ANSWER_ORDER_TODAY).getText());
    }

    @Test
    public void questionReturnEarlyCheckTest() {

        Assert.assertEquals("Можно ли продлить заказ или вернуть самокат раньше?", driver.findElement(QUESTION_RETURN_EARLY).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_RETURN_EARLY).isDisplayed());
        driver.findElement(QUESTION_RETURN_EARLY).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_RETURN_EARLY).isDisplayed());
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(ANSWER_RETURN_EARLY).getText());
    }

    @Test
    public void questionChargeCheckTest() {

        Assert.assertEquals("Вы привозите зарядку вместе с самокатом?", driver.findElement(QUESTION_CHARGE).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_CHARGE).isDisplayed());
        driver.findElement(QUESTION_CHARGE).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_CHARGE).isDisplayed());
        Assert.assertEquals("Ответ не соответствует вопросу", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(ANSWER_CHARGE).getText());
    }

    @Test
    public void questionCancelOrderCheckTest() {

        Assert.assertEquals("Можно ли отменить заказ?", driver.findElement(QUESTION_CANCEL_ORDER).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_CANCEL_ORDER).isDisplayed());
        driver.findElement(QUESTION_CANCEL_ORDER).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_CANCEL_ORDER).isDisplayed());
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(ANSWER_CANCEL_ORDER).getText());
    }

    @Test
    public void questionBeyondMKADCheckTest() {

        Assert.assertEquals("Я жизу за МКАДом, привезёте?", driver.findElement(QUESTION_BEYOND_MKAD).getText());
        Assert.assertFalse("Ответ отображается", driver.findElement(ANSWER_BEYOND_MKAD).isDisplayed());
        driver.findElement(QUESTION_BEYOND_MKAD).click();
        Assert.assertTrue("Ответ не отображается", driver.findElement(ANSWER_BEYOND_MKAD).isDisplayed());
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(ANSWER_BEYOND_MKAD).getText());
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}



