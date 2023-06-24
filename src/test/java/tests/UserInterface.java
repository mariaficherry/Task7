package tests;

import forms.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.awt.*;
import static utils.TestDataUtility.time;

public class UserInterface extends BaseTest  {
    HomePage homePage;
    Card1Form card1;
    Card2Form card2;
    Card3Form card3;

    @Test (priority = 1)
    public void testCase1() throws AWTException {
        homePage = new HomePage();
        card1 = new Card1Form();
        card2 = new Card2Form();
        card3 = new Card3Form();
        Assert.assertTrue(homePage.state().isDisplayed(),
                "Welcome page is not open");
        homePage.clickOnHereToGo();
        Assert.assertTrue(card1.state().isDisplayed(),
                "The '1' card is not open");
        card1.setPassword();
        card1.setEmail();
        card1.setRandomDomain();
        card1.uncheckTermsAndConditionsBox();
        card1.clickNextBtn();
        Assert.assertTrue(card2.state().isDisplayed(),
                "The '2' card is not open");
        card2.unCheckAllBoxes();
        card2.selectRandomBoxes();
        card2.clickUploadBtnAndUploadImg();
        card2.clickNextBtn();
        Assert.assertTrue(card3.state().isDisplayed(),
                "The '3' card is not open");
    }

    @Test (priority = 2)
    public void testCase2() {
        homePage = new HomePage();
        card1 = new Card1Form();
        Assert.assertTrue(homePage.state().isDisplayed(),
                "Welcome page is not open");
        homePage.clickOnHereToGo();
        card1.clickHelpFormBtn();
        Assert.assertTrue(card1.isHelpFormSentToBottom(),
                "The Help form is still visible");
    }

    @Test (priority = 3)
    public void testCase3() {
        homePage = new HomePage();
        card1 = new Card1Form();
        Assert.assertTrue(homePage.state().isDisplayed(),
                "Welcome page is not open");
        homePage.clickOnHereToGo();
        card1.clickCookiesBtn();
        Assert.assertFalse(card1.isCookiesFormClosed(),
                "The Cookies form is still visible");
    }

    @Test (priority = 4)
    public void testCase4() {
        homePage = new HomePage();
        card1 = new Card1Form();
        Assert.assertTrue(homePage.state().isDisplayed(),
                "Welcome page is not open");
        homePage.clickOnHereToGo();
        String currentTime = card1.getTime();
        Assert.assertEquals(time, currentTime, "Timer does not start from '00:00'");
    }
}