package edu.practicum.sprint4;

import org.openqa.selenium.*;

public class OrderFormPage {

    private final WebDriver driver;

    // Поле Имя
    private  By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Поле Фамилия
    private  By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле адрес
    private  By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле метро
    private  By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле Телефон
    private  By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private  By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }
    // Заполнить поле Имя
    public void inputNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    // Заполнить поле Фамилия
    public void inputSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    // Заполнить поле адрес
    public void inputAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    // Заполнить поле метро
    public void inputMetroStationField(String station) {
        driver.findElement(metroStationField).sendKeys(station + Keys.ARROW_DOWN + Keys.ENTER);
    }
    //Заполнить поле Телефон
    public void inputPhoneField(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    // Кликнуть на кнопку Далее и перейти на страницу Про Аренду
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Заполнить форму заказа
    public void fillOrderForm(String name, String surname, String address, String station, String phoneNumber){
        inputNameField(name);
        inputSurnameField(surname);
        inputAddressField(address);
        inputMetroStationField(station);
        inputPhoneField(phoneNumber);
        clickNextButton();
    }


}
