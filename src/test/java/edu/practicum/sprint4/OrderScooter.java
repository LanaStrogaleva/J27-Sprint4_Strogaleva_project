package edu.practicum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderScooter {
    TestData testData1 = new TestData(
            "Анна",
            "Иванова",
            "ул. Ленина, д.8",
            "Бульвар Рокоссовского",
            "+79224581635",
            "Позвонить за полчаса до приезда"
            );
    TestData testData2 = new TestData(
            "Иван",
            "Петров",
            "ул. Есенина, д.8",
            "Черкизовская",
            "+79224556842",
            "Позвонить за час до приезда"
    );
    private static final String EXPECTED_MESSAGE = "Заказ оформлен";

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.open();

    }

    @Test
    public void orderScooterByHeaderButton() {
         MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        //Кликнуть на кнопку Заказать в шапке
        mainPage.clickHeaderOrderButton();
        // Заполнить форму заказа
        orderFormPage.fillOrderForm(testData1.name, testData1.surname, testData1.address, testData1.station, testData1.phoneNumber);
        // Заполнить форму Про аренду
        aboutRentPage.fillAboutRentForm(testData1.comment);
        // Кликнуть на кнопку ДА
        aboutRentPage.clickYesButton();
        // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
        assertEquals("Не появилось всплывающее окно с сообщением об успешном создании заказа", EXPECTED_MESSAGE, aboutRentPage.getTextFromSuccessfulMessage());

    }

    @Test
    public void orderScooterByLowerButton() {
        MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        //Кликнуть на кнопку нижнюю кнопку Заказать
        mainPage.clickLowerOrderButton();
        // Заполнить форму заказа
        orderFormPage.fillOrderForm(testData2.name, testData2.surname, testData2.address, testData2.station, testData2.phoneNumber);
        // Заполнить форму Про аренду
        aboutRentPage.fillAboutRentForm(testData2.comment);
        // Кликнуть на кнопку ДА
        aboutRentPage.clickYesButton();
        // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
        assertEquals("Не появилось всплывающее окно с сообщением об успешном создании заказа", EXPECTED_MESSAGE, aboutRentPage.getTextFromSuccessfulMessage());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

