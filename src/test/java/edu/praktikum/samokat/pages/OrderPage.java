package edu.praktikum.samokat.pages;

import org.openqa.selenium.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;


public class OrderPage {
    private WebDriver driver;
    // Верхней кнопки заказать
    private By orderButtonUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[1]");
    // Нижней кнопки заказать
    private By orderButtonDown = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    //Кнопка куки
    private By cookieButton = By.id("rcc-confirm-button");
    //Поле имя
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле фамилия
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адреса
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Метро
    private By metroField = By.className("select-search__input");
    //Номер телефона
    private By phoneNumField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопки далее на экране заказа
    private By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    //Дата доставки самоката
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды самоката
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //Выьбор цвета
    private By colorField = By.xpath("//*[contains(@class,'Order_Checkboxes')]");
    //Поле для комментариев
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать на второй странице оформления заказа
    private By orderButtonInOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Подтвердить заказ
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Информация о заказе
    private By orderInfo = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    //Принятия куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //Нажатие верхней кнопки заказать
    public void clickOrderButton(boolean isUp) {
        if(isUp)
            clickOrderButtonUp();
        else clickOrderButtonDown();
    }
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }
    //Прокрутка до нижней кнопки заказать и нажатие на нее
    public void clickOrderButtonDown() {
        WebElement button = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(orderButtonDown).click();
    }
    //Заполнение поля имя
    public void setFirstNameField (String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //Заполнение поля фамилия
    public void setLastNameField (String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    //Заполнение поля адрес
    public void setAddressNameField (String addressName) {
        driver.findElement(addressField).sendKeys(addressName);
    }
    //Заполнение поля метро
    public void clickMetroField(String metro) {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//button[@value='"+metro+"']")).click();
    }
    //Заполнение поля номер телефона
    public void setPhoneNumField (String number) {
        driver.findElement(phoneNumField).sendKeys(number);
    }
    //Заполнение данных в певой странице оформления заказа
    public void login (String firstName, String lastName, String addressName, String number) {
        setFirstNameField(firstName);
        setLastNameField(lastName);
        setAddressNameField(addressName);
        setPhoneNumField(number);
    }
    //Нажатие кнопки далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //Заполнение поля дата доставки
    public void setDeliveryDateField() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        driver.findElement(deliveryDateField).click();
        driver.findElement(deliveryDateField).sendKeys(formatter.format(date));
        driver.findElement(deliveryDateField).sendKeys(Keys.ENTER);
    }
    //Заполнение поля срок аренды
    public void setRentalPeriodField(int rentTime) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodField).findElement(By.xpath("(//*[@class='Dropdown-menu']/div)[" + rentTime + "]")).click();
    }
    //Заполнение поля цвета самоката
    public void setColorField(String color) {
        driver.findElement(colorField);
        driver.findElement(By.xpath("//*[@id=\""+color+"\"]")).click();
    }
    //Заполнение поля комментарии
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //Нажатие кнопки заказать
    public void clickOrderButtonInOrder() {
        driver.findElement(orderButtonInOrder).click();
    }
    //Нажатия кнопки да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    //Проверка заказа
    public void checkOrderInfo() {
        String text = driver.findElement(orderInfo).getText();
        String textPart = "Заказ оформлен";
        assertTrue(text.contains(textPart));
    }
}
