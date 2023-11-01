package edu.practicum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private final WebDriver driver;

    // Поле Когда привезти самокат
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Календарь
    private  By calendarField = By.xpath(".//div[@aria-label='Choose среда, 1-е ноября 2023 г.']");
    // Поле Срок аренды
    private  By rentTimeField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Выпадающий список срока аренды
    private By rentDayDropDown = By.xpath(".//div[text()='трое суток']");
    // Чек-бокс Цвет самоката
    private  By colorCheckBox = By.xpath(".//div[text()='Цвет самоката']");
    // Цвет самоката "Черный"
    private  By colorBlack = By.xpath(".//input[@id='black']");
    //Поле Комментарий для курьера
    private  By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    private  By orderButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and  text()='Заказать']");
    // Кнопка Да
    private  By yesButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM') and  text()='Да']");
    // Сообщение об успешном оформлении заказа
    private By successfulMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }
    // Заполнить поле Когда привезти самокат
    public void inputDeliveryDateField() {
        driver.findElement(deliveryDateField).click();
        driver.findElement(calendarField).click();
    }
    //  Заполнить поле Срок аренды
    public void inputRentTimeField() {
        driver.findElement(rentTimeField).click();
        driver.findElement(rentDayDropDown).click();
    }
    // Выбрать Цвет самоката
    public void inputColorField() {
        driver.findElement(colorCheckBox).click();
        driver.findElement(colorBlack).click();
    }
    // Заполнить поле Комментарий для курьера
    public void inputCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Кликнуть на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Кликнуть на кнопку ДА
    public void clickYesButton () {
        driver.findElement(yesButton).click();
    }

    // Получить текст "Заказ оформлен" в всплывающем окне с сообщением об успешном создании заказа.
    public String getTextFromSuccessfulMessage () {
        return driver.findElement(successfulMessage).getText();
    }

    public void fillAboutRentForm(String comment) {
        inputDeliveryDateField();
        inputRentTimeField();
        inputColorField();
        inputCommentField(comment);
        clickOrderButton();
    }
}
