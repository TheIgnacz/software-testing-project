package com.epam.ta.uni.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.epam.ta.uni.factory.WebDriverFactory;

import java.util.Map;

@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://vimeo.com/";

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/header/div/div/div[2]/div/div[2]/div/div[1]/button[2]/div")
    private WebElement joinButton;

    @FindBy(css = "#modal-root > div.sc-76ujyu-0.kELeVB > div.at68q6-0.kdHbbu > form.at68q6-4.gOpkQK > button > div")
    private WebElement joinWithEmailButton;

//    @FindBy(id = "onetrust-accept-btn-handler")
//    private WebElement cookieDisclaimer;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Enter your name.", nameInput,
            "Enter your email.", emailInput,
            "Create password.", passwordInput
    );


    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage() {
        navigateToUrl(HOME_PAGE_URL);
    }

    public void clickOnJoinButton() {
        waitForElementToBeClickable(joinButton);
        joinButton.click();
        waitForPageReadiness();
    }

    public void clickOnJoinWithEmailButton() {
        waitForElementToBeClickable(joinWithEmailButton);
        joinWithEmailButton.click();
        waitForPageReadiness();
    }


    public WebElement getInputFieldByName(final String name) {
        waitForPageReadiness();
        return inputFieldsMap.get(name);
    }

//    public void clickOnCookieDisclaimer() {
//        waitForElementToBeClickable(cookieDisclaimer);
//        clickWithJsExecutor(cookieDisclaimer);
//    }
}
