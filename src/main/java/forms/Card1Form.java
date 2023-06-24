package forms;

import utils.RandomUtils;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class Card1Form extends Form {
    private final ITextBox passwordBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Choose Password");
    private final ITextBox emailBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Choose Email");
    private final ITextBox domainBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Choose Domain");
    private final IComboBox domainDropdown = getElementFactory().getComboBox(By.xpath("//div[@class='dropdown__opener']"), "Domain dropdown button");
    private final ICheckBox termsAndConditionsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'icon') and contains(@class, 'icon-check') and contains(@class, 'checkbox__check')]"), "Uncheck Terms & Conditions box");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//a[normalize-space()='Next']"), "Click Next button");
    private final ITextBox timer = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'timer') and contains(@class, 'timer--white') and contains(@class, 'timer--center')]"), "Timer count");
    private final IButton helpFormBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button') and contains(@class, 'button--solid') and contains(@class, 'button--blue') and contains(@class, 'help-form__send-to-bottom-button')]"), "Help form button");
    private final ITextBox helpFormHidden = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'help-form') and contains(@class, 'is-hidden')]"), "Help Form is hidden");
    private final IButton cookiesFormBtn = getElementFactory().getButton(By.xpath("//button[normalize-space()='Not really, no']"), "Cookies accept button");

    public Card1Form() {
        super(By.xpath("//div[contains(@class, 'timer') and contains(@class, 'timer--white') and contains(@class, 'timer--center')]"), "Timer count");
    }

    public void setPassword() {
        passwordBox.clearAndType(RandomUtils.createRandomPassword());
    }

    public void setEmail() {
        emailBox.clearAndType(RandomUtils.createRandomEmail());
        domainBox.clearAndType(RandomUtils.createRandomDomain());
        domainDropdown.getJsActions().clickAndWait();
    }

    public void setRandomDomain() {
        List<ILabel> domainOptions = getElementFactory().findElements(By.xpath("//div[@class='dropdown__list']/div[not(@class='dropdown__list-item selected')]"), ElementType.LABEL, ElementsCount.MORE_THAN_ZERO, ElementState.EXISTS_IN_ANY_STATE);
        Random random = new Random();
        int randomIndex = random.nextInt(domainOptions.size());
        ILabel randomOption = domainOptions.get(randomIndex);
        randomOption.click();
    }

    public void uncheckTermsAndConditionsBox() {
        termsAndConditionsCheckBox.check();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void clickHelpFormBtn() {
        helpFormBtn.click();
    }

    public boolean isHelpFormSentToBottom() {
        return helpFormHidden.state().waitForDisplayed();
    }

    public void clickCookiesBtn() {
        cookiesFormBtn.click();
    }

    public boolean isCookiesFormClosed() {
        return cookiesFormBtn.state().isDisplayed();
    }

    public String getTime() {
        return timer.getText();
    }
}