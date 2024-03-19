package LibraryPractice.Page;

import LibraryPractice.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class basePage {
    public basePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement LibraryButton;

    @FindBy(xpath = "(//li//a[@class='nav-link'])[1]")
    public WebElement BooksButton;

    @FindBy(xpath = "(//li//a[@class='nav-link'])[2]")
    public WebElement BorrowingBooksButton;

    @FindBy(xpath = "//a[@id='navbarDropdown']")
    public  WebElement  userButton;


}
