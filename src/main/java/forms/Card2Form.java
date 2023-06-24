package forms;

import utils.ImageUtils;
import aquality.selenium.forms.Form;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import static utils.TestDataUtility.numberOfCheckboxes;

public class Card2Form extends Form {
    private final ICheckBox unselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']//span[contains(@class, 'icon') and contains(@class, 'icon-check') and contains(@class, 'checkbox__check')]"), "Uncheck Unselect All box");
    private final IButton uploadImageBtn = getElementFactory().getButton(By.xpath("//a[normalize-space()='upload']"), "Upload image button");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//button[normalize-space()='Next']"), "Next button");

    public Card2Form() {
        super(By.xpath("//div[@class='avatar-and-interests__avatar-box']"), "User avatar");
    }

    public void unCheckAllBoxes() {
        unselectAll.check();
    }

    public void selectRandomBoxes() {
        List<ILabel> checkBoxList = getElementFactory().findElements(By.xpath("//span[@class='checkbox__box' and not(ancestor::label[@for='interest_unselectall'] or ancestor::label[@for='interest_selectall'])]"), ElementType.LABEL, ElementsCount.MORE_THAN_ZERO, ElementState.EXISTS_IN_ANY_STATE);

        Random random = new Random();

        int checkBoxCount = checkBoxList.size();
        Set<Integer> randomIndices = new HashSet<>();
        while (randomIndices.size() < numberOfCheckboxes) {
            randomIndices.add(random.nextInt(checkBoxCount));
        }
        for (int index : randomIndices) {
            ILabel randomBox = checkBoxList.get(index);
            randomBox.clickAndWait();
        }
    }

    public void clickUploadBtnAndUploadImg() throws AWTException {
        uploadImageBtn.click();
        ImageUtils.uploadImage();
    }

    public void clickNextBtn() {
        nextBtn.getJsActions().isElementOnScreen();
        nextBtn.click();
    }
}