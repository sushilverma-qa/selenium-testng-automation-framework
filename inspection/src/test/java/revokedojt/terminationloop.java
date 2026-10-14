package revokedojt;

import base.basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;


import java.time.Duration;

public class terminationloop extends basetest {

    @Test
    public void loginTest() {
        try {
            driver.get("https://betwabasin-ojt.mp.gov.in/WEB/Login/Login");

            // ✅ Create wait ONLY ONCE
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Username
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            username.sendKeys("mmsky.indore");

            // Password
            WebElement password =
                    driver.findElement(By.id("txtpassword"));
            password.sendKeys("TestUser@123");

            System.out.println("⚠ Please enter CAPTCHA manually");
            Thread.sleep(15000);

            // Login button
            WebElement loginBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@onclick='enc();']")
                    )
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginBtn);

            System.out.println("✅ Login button clicked");

            
                      // 🔹 Validate Dashboard
            wait.until(ExpectedConditions.urlContains("DirectorateDashboard"));

            String currentUrl1 = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl1);

            Assert.assertTrue(
                    currentUrl1.contains("DirectorateDashboard"),
                    "❌ Login failed: Dashboard not loaded"
            );

            System.out.println("✅ Login Dashboard opened.");

         // 🔹 Thoda wait taaki dashboard fully render ho jaye
            Thread.sleep(2000);

            // 🔹 Page scroll down (Y-axis)
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
           js2.executeScript("window.scrollBy(0, 800);");

            // 🔹 Sirf dekhne ke liye (optional)
            Thread.sleep(2000);

            System.out.println("✅ Page scrolled down");

                            
                 
                    WebElement terminationmenu =
                            wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//a[@data-toggle='collapse' and @data-target='#collapseUtilities3']")
                            ));
                    
                    
                    
                  //  ExpectedConditions.presenceOfElementLocated
                    JavascriptExecutor js13 = (JavascriptExecutor) driver;
                    js13.executeScript("arguments[0].click();", terminationmenu);

                    System.out.println("✅ termination Utilities menu1 expanded");
                    Thread.sleep(1500);
                    
                   
                    	 System.out.println("✅ termination clicked successfully");
                    
                    	 WebElement trequest =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//a[@href='/Web/TerminationDirectorate/Index']")
                                 ));
                         
                         
                         
                       
                         JavascriptExecutor js14 = (JavascriptExecutor) driver;
                         js14.executeScript("arguments[0].click();", trequest);
                         
                         

                         wait.until(ExpectedConditions.urlContains("TerminationDirectorate"));

                         String currentUrl3 = driver.getCurrentUrl();
                         System.out.println("Current URL: " + currentUrl3);

                         Assert.assertTrue(
                                 currentUrl3.contains("TerminationDirectorate"),
                                 "❌ Mapojt page not open"
                         );

                         System.out.println("✅ Termination request page opened.");

                      // 🔹 Thoda wait taaki dashboard fully render ho jaye
                         Thread.sleep(2000);

    
                 
                         
                         WebElement searchBtn = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		// By.xpath("//button[@id='btnAdd' and contains (@class, 'btn-primary' )]")
                                		 By.xpath("//button[contains (@class, 'btn-primary' )]")
                                 )
                         );

                         JavascriptExecutor js1 = (JavascriptExecutor) driver;
                         js1.executeScript("arguments[0].click();", searchBtn);

                         System.out.println("✅ search button clicked");
                         
                         Thread.sleep(1000);
                         
                        
                         
                       
                         
                         
                 //         WebElement viewDetails = wait.until(
                      //  		    ExpectedConditions.presenceOfElementLocated(
                        	//	        By.xpath("//button[contains(text(),'View Details')]")));
                        		    

                        	//	((JavascriptExecutor) driver).executeScript(
                        	//	    "arguments[0].scrollIntoView({block:'center',inline:'center'});",
                        	//	    viewDetails
                        	//	);
                         
                         
                        		//  viewDetails.click();
                         
                        		//System.out.println("✅ view details successfully");
                        		
                        	//	WebElement download = wait.until(
                        		   //     ExpectedConditions.elementToBeClickable(
                        		            //    By.xpath("//button[contains(@class,'btn-link') and normalize-space()='Download']")));
                        		        

                        		
                        		
                        		
                        	//	((JavascriptExecutor)driver)
                        		   //     .executeScript("arguments[0].click();", download);
                             		   
                        		
                        		
                        		// download.click();
                        		
                        		// System.out.println("✅ download successfully");
                         
                         
                         
                         
                         
                         List<WebElement> rows = wait.until(
                        		    ExpectedConditions.presenceOfAllElementsLocatedBy(
                        		        By.xpath("//table//tbody//tr")
                        		    )
                        		);
                         
                         
                         
                         
                         for (int i = 0; i < rows.size(); i++) {

                        	    // rows refresh safe way
                        	    rows = driver.findElements(By.xpath("//table//tbody//tr"));
                        	    WebElement row = rows.get(i);

                        	    // 1. View Details button (row-specific)
                        	    WebElement viewDetails = row.findElement(
                        	        By.xpath(".//button[contains(.,'View Details')]")
                        	    );

                        	    ((JavascriptExecutor) driver).executeScript(
                        	        "arguments[0].scrollIntoView({block:'center'});",
                        	        viewDetails
                        	    );

                        	    viewDetails.click();
                        	    System.out.println("✅ View Details clicked for row: " + (i+1));

                        	    // 2. dropdown wait
                        	    WebElement ddaction = wait.until(
                        	        ExpectedConditions.visibilityOfElementLocated(
                        	            By.id("ActionId")
                        	        )
                        	    );

                        	    Select select = new Select(ddaction);

                        	    List<WebElement> options = select.getOptions();

                        	    // optional: header/empty option remove (if any)
                        	    List<String> values = new ArrayList<>();

                        	    for (WebElement opt : options) {
                        	        String text = opt.getText().trim();
                        	        if (!text.isEmpty()) {
                        	            values.add(text);
                        	        }
                        	    }

                        	    // random selection
                        	    Random random = new Random();
                        	    String randomValue = values.get(random.nextInt(values.size()));

                        	    select.selectByVisibleText(randomValue);

                        	    System.out.println("🎯 Randomly selected: " + randomValue);
                        	    Thread.sleep(2000);

                        	    // 3. (IMPORTANT) back to table page
                        	  //  driver.navigate().back();

                        	    // wait for table again
                        	//    wait.until(ExpectedConditions.presenceOfElementLocated(
                        	 //       By.xpath("//table//tbody//tr")
                        	  //  ));
                        	}
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                        		
                        	
                        		 
                           		   Thread.sleep(2000);
                           		   
                           		   
                           		
                           		   
                           		WebElement Remarks = wait.until(
                                        ExpectedConditions.visibilityOfElementLocated(By.id("Remarks"))
                                );
                           		Remarks.sendKeys("ok test");

                           		
                           		   
                           	 
                                WebElement submit = wait.until(
                              		    ExpectedConditions.visibilityOfElementLocated(
                              		      //  By.xpath("//input[@id='btnTerminate')]")
                              		      By.xpath("//input[@id='btnTerminate']")
                              		    )
                              		);

                           		   
                                submit.click();

                                System.out.println("✅ Termination request submit successfully"); 
                           		   
                           		   
                           		   
                           		   
                           		   
                           		   
                           		   
                           		   
                        		 
                        		 
                         
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

                         