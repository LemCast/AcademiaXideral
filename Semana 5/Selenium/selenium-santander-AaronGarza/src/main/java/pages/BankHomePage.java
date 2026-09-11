package pages;

import base.BasePage;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankHomePage extends BasePage {

    private static final By MENU_ITEM_CANDIDATES = By.cssSelector(
            "nav a, nav span, nav button, header a, header span, header button");

    private static final long DELAY_MS = Long.parseLong(System.getProperty("menuDelayMs", "1000"));

    public BankHomePage(WebDriver driver) {
        super(driver);
    }

    public void openTopMenu(String menuLabel) {
        WebElement item = driver.findElements(MENU_ITEM_CANDIDATES).stream()
                .filter(e -> e.getText().trim().equalsIgnoreCase(menuLabel))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "No se encontro el item de menu principal: '" + menuLabel
                                + "'. Revisa el <nav> real del sitio y ajusta el selector."));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", item);
        item.click();
    }

    public void clickSubmenuLink(String hrefEndsWith) {
        click(By.cssSelector("a[href$='" + hrefEndsWith + "']"));
    }

    public void goToMenuItem(String topMenuLabel, String hrefEndsWith, String expectedUrlFragment) {
        openTopMenu(topMenuLabel);
        pause(DELAY_MS);
        clickSubmenuLink(hrefEndsWith);
        wait.until(ExpectedConditions.urlContains(expectedUrlFragment));
    }

    public void goToDirectMenuLink(String hrefEndsWith, String expectedUrlFragment) {
        pause(DELAY_MS);
        clickSubmenuLink(hrefEndsWith);
        wait.until(ExpectedConditions.urlContains(expectedUrlFragment));
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
