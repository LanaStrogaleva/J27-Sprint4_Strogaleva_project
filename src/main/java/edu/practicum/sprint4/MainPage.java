package edu.practicum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;
    //Блок "Вопросы о важном"
    private By questionsBlock = By.xpath(".//div[text()='Вопросы о важном']");
    //Кнопка Заказать в шапке
    private  By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Место для скролла до нижней кнопки "Заказать"
    private  By lowerOrderButtonPoint = By.xpath(".//div[text()='Когда аренда заканчивается']");
    //Кнопка Заказать нижняя
    private  By lowerOrderButton = By.xpath(".//button[text()='Заказать']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Открыть главную страницу
    public void open() {
        driver.get(URL);
    }
    // Проскроллить до блока "Вопросы о важном"
    public void scrollToQuestionsBlock() {
        WebElement element = driver.findElement(questionsBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Кликнуть на вопрос
    public void clickQuestion(int index) {
        By question = By.xpath(".//div[@class = 'accordion']/div[" + index +"]");
        driver.findElement(question).click();
    }
    // Получить текст ответа на вопрос
    public String getAnswers(int index) {
        By answer = By.xpath(".//div[@class = 'accordion']/div[" + index +"]//p");
        return driver.findElement(answer).getText();
    }
    //кликнуть на верхнюю кнопку "Заказать" в шапке
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    //проскроллить и кликнуть на нижнюю кнопку заказать
    public void clickLowerOrderButton() {
        WebElement element = driver.findElement(lowerOrderButtonPoint);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowerOrderButton).click();
    }
}
