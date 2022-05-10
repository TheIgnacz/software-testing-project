package team_b.vimeo.pageobjects;

import team_b.vimeo.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HomePage extends CommonPageObject {
    private static final String HOME_PAGE_URL = "https://vimeo.com/";

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/header/div/div/div[2]/div/div[2]/div/div[1]/button[2]/div")
    private WebElement joinButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/header/div/div/div[2]/div/div[2]/div/div[1]/button[1]")
    private WebElement loginButton;

    @FindBy(css = "#modal-root > div.sc-76ujyu-0.kELeVB > div.at68q6-0.kdHbbu > form.at68q6-4.gOpkQK > button > div")
    private WebElement joinWithEmailButton;

    @FindBy(css = "#modal-root > div.sc-76ujyu-0.kELeVB > div.at68q6-0.kdHbbu > form.at68q6-4.gOpkQK > button > div")
    private WebElement logInWithEmailButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/header/div/div/div[2]/div/div[1]/div[4]/a")
    private WebElement watchButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/header/div/div/div[2]/div/div[1]/div[5]/a")
    private WebElement pricingButton;

    @FindBy(css = "#modal-root > div.sc-76ujyu-0.kELeVB > div.at68q6-0.kdHbbu > form.at68q6-4.gOpkQK > div > a")
    private WebElement forgotYourPasswordLink;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password")
    private WebElement passwordLogInInput;

    private final Map<String, WebElement> inputFieldsMap = Map.of(
            "Enter your name.", nameInput,
            "Enter your email.", emailInput,
            "Create password.", passwordInput,
            "Enter your password.", passwordInput
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

    public void clickOnLogInButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        waitForPageReadiness();
    }

    public void clickOnJoinWithEmailButton() {
        waitForElementToBeClickable(joinWithEmailButton);
        joinWithEmailButton.click();
        waitForPageReadiness();
    }

    public void clickOnLogInWithEmailButton() {
        waitForElementToBeClickable(logInWithEmailButton);
        logInWithEmailButton.click();
        waitForPageReadiness();
    }

    public void clickWatchButton() {
        waitForElementToBeClickable(watchButton);
        watchButton.click();
        waitForPageReadiness();
    }

    public void clickPricingButton() {
        waitForElementToBeClickable(pricingButton);
        pricingButton.click();
        waitForPageReadiness();
    }

    public void clickForgotYourPasswordLink() {
        waitForElementToBeClickable(forgotYourPasswordLink);
        forgotYourPasswordLink.click();
        waitForPageReadiness();
    }

    public WebElement getInputFieldByName(final String name) {
        waitForElementToBeClickable(inputFieldsMap.get(name));
        return inputFieldsMap.get(name);
    }
}
