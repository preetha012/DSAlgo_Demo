package pageObjects_DSAlgo;


import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PF_ArrayPage {
	private WebDriver ldriver;
	public PF_ArrayPage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="//a[@href='array']")@CacheLookup WebElement GetStart_array;
	@FindBy(linkText = "Arrays in Python") @CacheLookup WebElement arrays_in_python;
	@FindBy(linkText = "Arrays Using List") @CacheLookup WebElement arrays_list;
	@FindBy(linkText = "Basic Operations in Lists") @CacheLookup WebElement arrays_basicOptnList;
	@FindBy(linkText = "Applications of Array") @CacheLookup WebElement array_applicatnBtn;
	
	@FindBy(linkText = "Practice Questions") @CacheLookup WebElement array_PracticeQuestn;
	@FindBy(linkText = "Search the array") @CacheLookup WebElement array_search;
	@FindBy(linkText = "Max Consecutive Ones") @CacheLookup WebElement array_Max;
	@FindBy(linkText="Find Numbers with Even Number of Digits") @CacheLookup WebElement array_evenDigits;
	//@FindBy(linkText = "Squares of  a Sorted Array") @CacheLookup WebElement array_squares_sort;
	@FindBy(xpath="/html/body/div[5]/a") @CacheLookup WebElement array_squares_sort;
	
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement Code_tryArea;
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement Arrays_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	//@FindBy(xpath="//input[@value='Submit']") @CacheLookup WebElement Submit_btn;
	//@FindBy(xpath="//*[@id='answer_form']/input[2]") @CacheLookup WebElement Submit_btn;
	@FindBy(xpath="//input[@class='button']") @CacheLookup WebElement Submit_btn;
	
	@FindBy(xpath="//*[@id='output']")  WebElement output_runMsg;
	@FindBy(xpath="//pre[@id='output']")  WebElement output_submitMsg;

	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void getStartArray() {
		GetStart_array.click();
	}
	public void array_PythonFn() {
		arrays_in_python.click();
	}
	public void array_tryHere() {
		Arrays_TryhereBtn.click();
	}
	public void array_usingList() {
		arrays_list.click();
	}
	public void array_BasicOperation() {
		arrays_basicOptnList.click();
	}
	public void Applictn_array() {
		array_applicatnBtn.click();
	}
	public void Array_PracticeQuestn() {
		array_PracticeQuestn.click();
	}
	public void setRunButton() throws InterruptedException {
		Run_button.click();		
	}
	public void setSubmit() throws InterruptedException {
		Submit_btn.click();
	}
	public void Search_Array() {
		array_search.click();
	}
	public void array_maxConsctvOnes() {
		array_Max.click();
	}
	public void array_EvenDigits() {
		array_evenDigits.click();
	}
	public void array_squareSorted() {
		array_squares_sort.click();
	}
	public void Array_validPythonCode(String pythoncode) throws InterruptedException {
		Actions action = new Actions(ldriver);
		action.click(Code_tryArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(Code_tryArea,pythoncode).build().perform();
		
	}
	public String getRunResult() {
		String outMsg;		
		outMsg= output_runMsg.getText();
		//ldriver.navigate().refresh();
		return outMsg;
		
	}
	public String getSubmitResult() {
		String message;
		message=output_submitMsg.getText();	
		System.out.println("**Sbmit msg--"+message);
		//ldriver.navigate().refresh();
		return message;
	
	}
	public void Array_InvalidPythonCode(String pythoncode) throws InterruptedException {
		Actions action = new Actions(ldriver);
		action.click(Code_tryArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(Code_tryArea,pythoncode).build().perform();
	}
	public String alertmsgforInvalid() throws InterruptedException {	
		Alert alert = ldriver.switchTo().alert();
		String alertmessage= alert.getText();
		alert.accept();
		return alertmessage;
	}
	/*public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        ldriver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
	*/
	
	
	
	
	
}
