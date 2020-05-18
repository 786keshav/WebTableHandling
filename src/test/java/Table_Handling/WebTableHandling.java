package Table_Handling;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTableHandling extends Base{
    @Test(priority=1)
	public void webtableHandling() {	
	WebElement mytable =driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody"));	
	List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
	System.out.println("No.of rows are:" +rows_table.size());
	List<WebElement> cols_table = mytable.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	System.out.println("No.of cols are:" +cols_table.size());
	System.out.println("-----------*------------------*------------*---------*------------*---------------");
	  //To calculate no of rows In table.
	  int rows_count = rows_table.size();
	for (int row=0; row<rows_count; row++){
		   //To locate columns(cells) of that specific row.
		   List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		   //To calculate no of columns(cells) In that specific row.
		   int columns_count = Columns_row.size();
		   WebElement Col_Heading=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		   System.out.println("Number of cells In Row "+row+" are "+columns_count);
		   
		   //Loop will execute till the last cell of that specific row.
		   for (int column=0; column<columns_count; column++){
		    //To retrieve text from that specific cell.
		    String celtext = Columns_row.get(column).getText();
		   
		    System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext+"of Col"+Col_Heading);
		    
		   }
		   System.out.println("-----------*------------------*------------*---------*------------*---------------");
	}
    }
}
