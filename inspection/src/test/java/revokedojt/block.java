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

public class block extends basetest {

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
            username.sendKeys("mmsky.bhopal");

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

            System.out.println("✅ Login. Dashboard opened.");

         // 🔹 Thoda wait taaki dashboard fully render ho jaye
            Thread.sleep(2000);

            // 🔹 Page scroll down (Y-axis)
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
           js2.executeScript("window.scrollBy(0, 800);");

            // 🔹 Sirf dekhne ke liye (optional)
            Thread.sleep(2000);

            System.out.println("✅ Page scrolled down");

                            
                 
                 //   WebElement blockmenu =
                         //   wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    //By.xpath("//a[@data-toggle='collapse' and @data-target='#collapseUtilities1']")
                          //  ));
                    
                    
                    
                  //  ExpectedConditions.presenceOfElementLocated
                  //  JavascriptExecutor js13 = (JavascriptExecutor) driver;
                   // js13.executeScript("arguments[0].click();", blockmenu);

                  //  System.out.println("✅ Utilities menu1 expanded");
                  //  Thread.sleep(1500);
                    
                   
                    //	 System.out.println("✅ Inspection clicked successfully");
                    
                    	 WebElement blockmenu =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//a[@href='/Web/BlockEstablishmentTrainee/Index']")
                                 ));
                         
                         
                         
                       
                         JavascriptExecutor js14 = (JavascriptExecutor) driver;
                         js14.executeScript("arguments[0].click();", blockmenu);
                         
                         

                         wait.until(ExpectedConditions.urlContains("BlockEstablishmentTrainee"));

                         String currentUrl3 = driver.getCurrentUrl();
                         System.out.println("Current URL: " + currentUrl3);

                         Assert.assertTrue(
                                 currentUrl3.contains("BlockEstablishmentTrainee"),
                                 "❌ block page not open"
                         );

                         System.out.println("✅ Block Establishment Trainee page opened.");

                      // 🔹 Thoda wait taaki dashboard fully render ho jaye
                         Thread.sleep(2000);

    
                         
                         WebElement establishment = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.xpath("//input[@id='rdoEstablishment']")
                                 )
                         );
                         
                         
                         
                         WebElement student = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.xpath("//input[@id='rdoTrainee']")
                                 )
                         );
                         
                         
                         if (establishment.isSelected()) {
                             System.out.println("Establishment radio already selected .");

                             // Step 2: "Deselect" karne ke liye doosra radio select karo
                             student.click();
                         
                         
                             System.out.println("Establishment radio deselected");
                         } else {
                             System.out.println("Establishment radio is not already selected");
                         }

                         // Step 3: Ab wapas Establishment radio select karo
                         establishment.click();
                         System.out.println("Establishment radio successfully selected.");
        
                         
                         
                         WebElement selectdist =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//input[@id='txtDistrict']")
                                 ));
                    	 
                    	// Select select = new Select(selectdist);
                    	 
                    	// 1️⃣ Default value check
                    	 String selectedDistrict = selectdist.getAttribute("value").trim();
                    	 Assert.assertEquals(selectedDistrict, "BHOPAL",
                    	         "Default district is not BHOPAL!");

                    	// (Optional) Verify ki field editable nahi hai
                    	 Assert.assertFalse(selectdist.isEnabled(), "District field editable hai, jabki disabled hona chahiye!");
                    	
                    	 System.out.println("✅ Block BHOPAL");
                    	 
                         
                         
                         WebElement seraches = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(By.id("txtSearch"))
                         );
                         seraches.sendKeys("me2300000088");
                         System.out.println("me2300000088 successfully entered.");
                         
                         
                         
                        
                         WebElement searchBtn = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.xpath("//button[@id='btnBlockEstablishmentTrainee' and contains (@class, 'btn-primary' )]")
                                 )
                         );

                         JavascriptExecutor js1 = (JavascriptExecutor) driver;
                         js1.executeScript("arguments[0].click();", searchBtn);

                         System.out.println("✅ search button clicked");
                         
                         Thread.sleep(1000);
                         
                         
                         
                         
                         // 🔹 Page scroll down (Y-axis)
                         JavascriptExecutor js3 = (JavascriptExecutor) driver;
                        js3.executeScript("window.scrollBy(0, 500);");

                         // 🔹 Sirf dekhne ke liye (optional)
                         Thread.sleep(2000);

                         System.out.println("✅ Page scrolled down");
                         
                         
                         
                         
                         WebElement vps = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.xpath("//input[@id='EditID' and contains (@class, 'btn btn-primary editButton' )]")
                                 )
                         );
                         
                         vps.click();
                         
                         
                         WebElement closeBtn = wait.until(
                        		    ExpectedConditions.elementToBeClickable(
                        		        By.xpath("//input[@name='Cancel' and @value='CLOSE']")
                        		    )
                        		);
                        		closeBtn.click();
                         
                         
                         
                         
                         // 🔹 Page scroll down (Y-axis)
                         JavascriptExecutor js8 = (JavascriptExecutor) driver;
                        js8.executeScript("window.scrollBy(0, 500);");
                         
                        
                         
                   //     WebElement dropdown = wait.until(
                       // 	    ExpectedConditions.visibilityOfElementLocated(
                        	      //  By.xpath("//select[@id='ddlBlockReason']")));
                        	   
                        	
                         
                         
                         
                        int reasonNo = 5;

                        WebElement dropdown = wait.until(
                            ExpectedConditions.elementToBeClickable(By.id("ddlBlockReason"))
                        );

                        Select select = new Select(dropdown);
                        select.selectByIndex(reasonNo);

                        // Confirm karne ke liye (optional)
                        System.out.println("Selected: " + select.getFirstSelectedOption().getText());
                        
                        
                        
                        
                         
                        
                        
                        WebElement remark = wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("txtRemark"))
                        );
                        remark.sendKeys("please approved the request");
                        
                        
                        
                         
                           ;
                        
                        
                           WebElement fileInput = wait.until(
                        		    ExpectedConditions.presenceOfElementLocated(By.id("flUpload_src"))
                        		);

                        		fileInput.sendKeys("C:\\Users\\sushi\\Downloads\\10401_21082023045633_CONT_Signed.pdf");
                        
                        		 System.out.println("✅ file uploaded successfully");
                        
                        
                        

                        		  WebElement block = wait.until(
                                          ExpectedConditions.visibilityOfElementLocated(
                                                 // By.xpath("//button[@onclick='IOMapChange()']")
                                         		 By.xpath("//input[@id='btnBlockRequestConfirmBox']")
                                          )
                                  );
                        
                        
                        		  block.click();
                        		 
                        		 
                        	
                        		  
                        		  
                        		  WebElement bconfirmation = wait.until(
                                          ExpectedConditions.visibilityOfElementLocated(
                                                 // By.xpath("//button[@onclick='IOMapChange()']")
                                         		 By.xpath("//input[@id='btnBlockRequest']")
                                          )
                                  );
                        
                        
                        		  bconfirmation.click();
                        		  
                        		  
                        		  
                        		  
                        		  
                        		  
                        		  
                 
                 
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

            
            
            
            


            
            
