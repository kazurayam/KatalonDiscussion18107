import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**
 * reproducing the Example.1 in
 * https://www.katalon.com/resources-center/tutorials/handle-web-tables/
 *
 * using arrays rather than List
 */
WebUI.openBrowser('')
WebUI.setViewPortSize(703, 347)
WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/18107_testbed.html')

WebDriver driver = DriverFactory.getWebDriver()

// To locate table
WebElement table = driver.findElement(By.xpath('//table/tbody'))

// To locate rows of table it will capture all the rows available in the table
WebElement[] rowsInTable = table.findElements(By.tagName('tr')) as WebElement[]

// To calculate number of rows in the table
int rowsCount = rowsInTable.length
WebUI.comment("rowsCount=${rowsCount}")

// Iterate over all the rows of the table
for (int r = 0; r < rowsCount; r++) {

	// To locate columns(cells) of that specific row
	WebElement[] columnsInRow = rowsInTable[r].findElements(By.tagName('td')) as WebElement[]
	
	// To calculate number of columns in that specific row
	int columnsCount = columnsInRow.length
	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
	
	// Iterate over the cells of that specifc row
	for (int c = 0; c < columnsCount; c++) {
		// Retrieve text from each cell
		String cellText = columnsInRow[c].getText()
		//WebUI.comment("Cell value of (${r},${c}) is '${cellText}'")
	} 
}

WebUI.closeBrowser()

