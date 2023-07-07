package pageObjects_DSAlgo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_HomePage {

	private WebDriver ldriver;
	public PF_HomePage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(linkText="Get Started") @CacheLookup WebElement btngetstart;
	@FindBy(xpath="//div[@id='navbarCollapse']//div[2]//ul/a[3]") @CacheLookup WebElement Home_signin;
	@FindBy(xpath="//div[@id='navbarCollapse']//div[2]//ul/a[2]")@CacheLookup  WebElement Home_register;
	@FindBy(xpath = "//div[@class='navbar-nav']//ul/a[3]")  WebElement Logout_btn;
	
	@FindBy(xpath="//div[@class='alert alert-primary']") @CacheLookup WebElement DS_clickErrormsg;
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[1]")@CacheLookup WebElement Drop_array;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[2]")@CacheLookup WebElement Drop_linklist;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[3]")@CacheLookup WebElement Drop_stack;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[4]")@CacheLookup WebElement Drop_queue;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[5]")@CacheLookup WebElement Drop_tree;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[6]")@CacheLookup WebElement Drop_graph;
	
	
	@FindBy(xpath="//a[@href='data-structures-introduction']")@CacheLookup WebElement GetStart_intro;
	@FindBy(xpath="//a[@href='array']")@CacheLookup WebElement GetStart_array;
	@FindBy(xpath="//a[@href='linked-list']")@CacheLookup WebElement GetStart_liknklst;
	@FindBy(xpath="//a[@href='stack']")@CacheLookup WebElement GetStart_stack;
	@FindBy(xpath="//a[@href='queue']")@CacheLookup WebElement GetStart_queue;
	@FindBy(xpath="//a[@href='tree']")@CacheLookup WebElement GetStart_tree;
	@FindBy(xpath="//a[@href='graph']")@CacheLookup WebElement GetStart_graph;
	
	
	public void to_home_getstart()
	{
		btngetstart.click();
	}
	public void SignFunction()
	{
		Home_signin.click();
	}
	public void RegisterFunction()
	{
		Home_register.click();
	}
	public void logout_fn() {
		Logout_btn.click();
	}

	public String getHomePageTitle() {
		return ldriver.getTitle();
	}
	public String DS_GetstartwithoutLogin(String DSName) throws InterruptedException {
		
		String ds_errormsg="";
		
		if(DSName.equalsIgnoreCase("Datastructures")) {
			GetStart_intro.click();
			// ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Arrays")) {
			GetStart_array.click();
			//ds_errormsg=DS_clickErrormsg.getText();
			//System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Linkedlist")) {
			GetStart_liknklst.click();
			 //ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Stack")) {
			GetStart_stack.click();
			 //ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Queue")) {
			GetStart_queue.click();
			// ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Tree")) {
			GetStart_tree.click();
			 //ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else if(DSName.equalsIgnoreCase("Graph")) {
			GetStart_graph.click();
			// ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}else {
			System.out.println("--->+didnt get value");
			//System.out.println("getstartError -->>> "+ds_errormsg+" for ---"+DSName);
		}	
			ds_errormsg=DS_clickErrormsg.getText();		
			return ds_errormsg;
		}
		
	public String dropdown_withoutLogin(String dsname) throws InterruptedException {
		String ds_errormsg="";
		Ds_dropdownBtn.click();
		
		
		if(dsname.equalsIgnoreCase("Arrays")) {
			Drop_array.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			// System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else if(dsname.equalsIgnoreCase("Linkedlist")) {
			Drop_linklist.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			// System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else if(dsname.equalsIgnoreCase("Stack")) {
			Drop_stack.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else if(dsname.equalsIgnoreCase("Queue")) {
			Drop_queue.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else if(dsname.equalsIgnoreCase("Tree")) {
			Drop_tree.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			 //System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else if(dsname.equalsIgnoreCase("Graph")) {
			Drop_graph.click();
			 ds_errormsg=DS_clickErrormsg.getText();
			// System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}else {
			System.out.println("Drop down value not selected correctly");
			//System.out.println("drop down Error -->>> "+ds_errormsg+" for ---"+dsname);
		}
		//System.out.println("dropdownError-->>> "+ds_errormsg);
		return ds_errormsg;	
	}

	
}
