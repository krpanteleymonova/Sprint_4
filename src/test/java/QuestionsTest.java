import io.github.bonigarcia.wdm.WebDriverManager;
import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static model.MainPage.*;

@RunWith(Parameterized.class)
public class QuestionsTest {
    private final String question;
    private final String answer;
    private final By questionSelector;
    private final By answerSelector;

    protected WebDriver driver;

    public QuestionsTest(String question, String answer, By questionSelector, By answerSelector) {
        this.question = question;
        this.answer = answer;
        this.questionSelector = questionSelector;
        this.answerSelector = answerSelector;
    }

    @Before
    public void setUp() {

          WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
      //  WebDriverManager.firefoxdriver().setup();
     //   driver = new FirefoxDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCookie();
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {

        return new Object[][]{

                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", QUESTION_HOW_MUCH, ANSWER_HOW_MUCH},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", QUESTION_WANT_SOME_SCOOTERS, ANSWER_WANT_SOME_SCOOTERS},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", QUESTION_RENTAL_TIME, ANSWER_RENTAL_TIME},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", QUESTION_ORDER_TODAY, ANSWER_ORDER_TODAY},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", QUESTION_RETURN_EARLY, ANSWER_RETURN_EARLY},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", QUESTION_CHARGE, ANSWER_CHARGE},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", QUESTION_CANCEL_ORDER, ANSWER_CANCEL_ORDER},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", QUESTION_BEYOND_MKAD, ANSWER_BEYOND_MKAD},
        };
    }

    @Test
    public void questionCheckTest() {

        Assert.assertEquals("Такого вопроса нет!", question, driver.findElement(questionSelector).getText());
        Assert.assertFalse("Ответ отображается,а не должен!", driver.findElement(answerSelector).isDisplayed());
        driver.findElement(questionSelector).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(answerSelector));
        Assert.assertTrue("Ответ не отображается, а должен!", driver.findElement(answerSelector).isDisplayed());
        Assert.assertEquals("Ответ не соответствует вопросу!", answer, driver.findElement(answerSelector).getText());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}



