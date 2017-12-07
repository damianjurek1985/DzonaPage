import SearchWindow.SearchResultPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DzonaHomePage {



    private static final String DZONE_PAGE = "http://dzone.com";

    // Pole typu WebDriver umożliwia interakcję z wyświetlanymi przez
    // przeglądarkę stronami.

    private final WebDriver driver;
    // Element odpowiadający polu tekstowemu zlokalizowany będzie po ID

    @FindBy(how = How.ID, using = "mh_searchQuery")

    private WebElement searchBox;

    // Element odpowiadający przyciskowi uruchamiającemu wyszukiwanie zlokalizowany
    // będzie po ID

    @FindBy(how = How.ID, using = "mh_searchSubmit")

    private WebElement searchButton;

    public DzonaHomePage(WebDriver driver) {

        this.driver = driver;

        // Strona http://dzone.com zostanie załadowana przez przeglądarkę
        driver.get(DZONE_PAGE);
    }

    public SearchResultPage searchFor(String query) {

        searchBox.sendKeys(query);
        searchButton.click();
        // Wyszukiwarka przenosi nas na stronę z rezultatami. Dzięki
        // PageFactory mamy dostęp do instancji klasy DzoneSearchResultPage,
        // której pola WebElement zostały właściwie zainicjalizowane.
        return PageFactory.initElements(driver, SearchResultPage.class);
    }
}
