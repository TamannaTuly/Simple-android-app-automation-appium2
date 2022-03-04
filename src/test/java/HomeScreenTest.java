import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomeScreenTest extends BaseClass{
    By homePage = By.id("com.example.basicapp:id/titleText");
    By buttonHpage = By.id("com.example.basicapp:id/button1");

    By titleNpage = By.className("android.widget.TextView");
    @Test(priority = 1)
    public void doTest() throws InterruptedException{


        ExtentTest test = extent.createTest("Test Case 01", "Getting the value of the HOMEPAGE");
        test.log(Status.INFO, "Test Started Successfully");
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage)).getText();
        test.log(Status.PASS, "Getting the attribute of HOMEPAGE");

        Assert.assertEquals(text,"Welcome to Tamanna Testologie");
        test.log(Status.PASS, "Test Done");
//        System.out.println(text);
    }

    @Test(priority = 2)
    public void test2(){


        ExtentTest test = extent.createTest("Test Case 02", "Check the value of the Button");
        test.log(Status.INFO, "Test Started Successfully");
        String btnText = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonHpage)).getText();
        test.log(Status.PASS, "Getting the attribute of button");

        Assert.assertEquals(btnText,"TAKE ME TO NEXT PAGE");
        test.log(Status.PASS, "Test Done");
//        System.out.println(text);
    }

    @Test(priority = 3)
    public void goToNextPage(){
        ExtentTest test = extent.createTest("Test Case 03", "Go to Next page and check the value");
        test.log(Status.INFO, "Test Started Successfully");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonHpage)).click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleNpage)).getText();
        test.log(Status.INFO, "Checking the title of the page");


        try {
            Assert.assertEquals(title,"Base aapp");
            test.log(Status.PASS,"Got : "+ title+ "expected : Basic App");
        } catch ( AssertionError e) {
            System.out.println("failed");
            test.log(Status.FAIL,"Got : "+ title+ "expected : Basic App");
        }

    }



    @AfterClass
    public void qTest(){
        driver.quit();
    }
}
