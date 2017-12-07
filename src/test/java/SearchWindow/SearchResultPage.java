package SearchWindow;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    // Wyrażenie XPath pozwalające na zlokalizowanie wszystkich
    // tytułów na stronie rezultatów.

    private static final String SEARCH_RESULT_TITLES_XPATH = "//div[@class='details']/h3/a";

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver)
    {

        super();
        this.driver = driver;
    }

    public List<String> getSearchResultTitles() {
        // Elementy pobierać można również korzystając bezpośrednio z drivera

        List<WebElement> elements = driver.findElements(By.xpath(SEARCH_RESULT_TITLES_XPATH));

        // Wygodny sposób transformacji kolekcji obiektów z jednego typu
        // na drugi, dostępny w bibliotece Google Collections.
        List<String> results = Lists.transform(elements, new ExtractText());

        return results;
    }

    /**
     * 26
     * Klasa wykorzystana do transformacji obiektów klasy WebElement
     * 27
     * na String.
     * 28
     */

    private final class ExtractText implements Function<WebElement, String> {

        @Override

        public String apply(WebElement from) {
            return from.getText();

        }

    }
}
