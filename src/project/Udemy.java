package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Udemy {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "XYZ");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "SplashActivity");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.id("com.udemy.android:id/browse_button")).click();
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
		driver.findElement(MobileBy.id("com.udemy.android:id/search_bar_text")).click();
		driver.findElement(MobileBy.id("com.udemy.android:id/search_bar_text")).sendKeys("Selenium");
		driver.hideKeyboard();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"selenium\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Selenium WebDriver with Java -Basics to Advanced+Frameworks\")")).click();
		TouchAction act = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1=width/2;
		int y1 = 4*height/5;
		int x2= width/2;
		int y2=height/5;
		
		driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe "+x1+" "+y1+"  "+x2+" "+y2));
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Please sign in to add items to your cart.\")")).isDisplayed();
		System.out.println("Message throws to Sign in");
		
		

	}

}
