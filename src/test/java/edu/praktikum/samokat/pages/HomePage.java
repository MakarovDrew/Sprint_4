package edu.praktikum.samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //Списка вопросов
    private By questionList = By.className("accordion");
    //Кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //Принятия куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //Прокрутка до списка вопросов
    public void scrollToQuestionList() {
        WebElement element = driver.findElement(questionList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //Нажатие на кнопки с вопросами
    public void clickQuestions(int index) {
        driver.findElement(By.id("accordion__heading-" + index)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //Получение текста
    public String getAnswer(int index) {
        return driver.findElement(By.id("accordion__panel-"+index)).getText();
    }

}
