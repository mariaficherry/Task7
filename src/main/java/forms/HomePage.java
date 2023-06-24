package forms;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private final IButton onHereToGo1 = getElementFactory().getButton(By.xpath("//a[normalize-space()='HERE']"), "Please click HERE to GO to the next page button");

    public HomePage() {
        super(By.xpath("//button[normalize-space()='NO']"), "NO button");
    }

    public void clickOnHereToGo() {
        onHereToGo1.getJsActions().click();
    }
}