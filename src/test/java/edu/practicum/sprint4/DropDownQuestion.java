package edu.practicum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DropDownQuestion {

    private static final String[] EXPECTED_TEXT = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
    };
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void clickArrowTextAppear() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();

        //Проскроллить вниз до раздела "Вопросы о важном"
        mainPage.scrollToQuestionsBlock();

        // Кликнуть на каждый вопрос, получить ответ и сравнить его с соответствующим текстом
        for (int i = 0; i < EXPECTED_TEXT.length; i++) {
            mainPage.clickQuestion(i);
            assertEquals(
                    "Не показан текст ответа на вопрос " + (i+1),
                    EXPECTED_TEXT[i],
                    mainPage.getAnswers(i)
            );
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
