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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void orderScooterByHeaderButton() {
        MainPage mainPage = new MainPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        mainPage.open();

        //Кликнуть на кнопку Заказать в шапке
        mainPage.clickHeaderOrderButton();
        // Заполнить поле Имя
        orderFormPage.inputNameField(testData1.name);
        // Заполнить поле Фамилия
        orderFormPage.inputSurnameField(testData1.surname);
        // Заполнить поле адрес
        orderFormPage.inputAddressField(testData1.address);
        // Заполнить поле метро
        orderFormPage.inputMetroStationField(testData1.station);
        //Заполнить поле Телефон
        orderFormPage.inputPhoneField(testData1.phoneNumber);
        // Кликнуть на кнопку Далее и перейти на страницу Про Аренду
        orderFormPage.clickNextButton();

        // Заполнить поле Когда привезти самокат
        aboutRentPage.inputDeliveryDateField();
        // Заполнить поле Срок аренды
        aboutRentPage.inputRentTimeField();
        // Выбрать Чек-бокс Цвет самоката
        aboutRentPage.inputColorField();
        // Заполнить поле Комментарий для курьера
        aboutRentPage.inputCommentField(testData1.comment);
        // Кликнуть на кнопку Заказать
        aboutRentPage.clickOrderButton();
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

        mainPage.open();

        //Кликнуть на кнопку нижнюю кнопку Заказать
        mainPage.clickLowerOrderButton();
        // Заполнить поле Имя
        orderFormPage.inputNameField(testData2.name);
        // Заполнить поле Фамилия
        orderFormPage.inputSurnameField(testData2.surname);
        // Заполнить поле адрес
        orderFormPage.inputAddressField(testData2.address);
        // Заполнить поле метро
        orderFormPage.inputMetroStationField(testData2.station);
        //Заполнить поле Телефон
        orderFormPage.inputPhoneField(testData2.phoneNumber);
        // Кликнуть на кнопку Далее и перейти на страницу Про Аренду
        orderFormPage.clickNextButton();

        // Заполнить поле Когда привезти самокат
        aboutRentPage.inputDeliveryDateField();
        // Заполнить поле Срок аренды
        aboutRentPage.inputRentTimeField();
        // Выбрать Чек-бокс Цвет самоката
        aboutRentPage.inputColorField();
        // Заполнить поле Комментарий для курьера
        aboutRentPage.inputCommentField(testData2.comment);
        // Кликнуть на кнопку Заказать
        aboutRentPage.clickOrderButton();
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

