package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Card3Form extends Form {
    public Card3Form() {
        super(By.xpath("//div[contains(@class,'toggle-button') and contains(@class,'toggle-button--left') and contains(@class, 'selected')]"), "Male gender button");
    }
}