package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Amazon {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "XYZ");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
//		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.amazon.mShop.android.shopping");
//		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.navigation.MainActivity");
//		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
//		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridLayout/android.widget.ImageView[1]")).click();
//		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"New to Amazon.in? Create an account\")")).click();
//		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Open Menu\")")).click();
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Manipal\\chromedriver.exe");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://amazon.in");
		driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']/i")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//*[@id='register_accordion_header']/i")).click();
		driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("MuhilSai");
		driver.findElement(By.xpath("//*[@id='ap_phone_number']")).sendKeys("9840530531");
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("welcome");
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='continue' and @type='submit']")).click();
		String Actual = driver.findElement(By.xpath("//*[@class='a-alert-content']/p")).getText();
		System.out.println(Actual);
		String Expected = "You indicated you are a new customer, but an account already exists with the mobile number";
		if(Actual.contains(Expected))
		{
			System.out.println("Mobile number already in use");
		}
		else
		{
			System.out.println("Account created");
		}
		
		
		
		
		

	}

}
