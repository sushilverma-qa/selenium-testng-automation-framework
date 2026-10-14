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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

public class candidatedashboard extends basetest {

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
            username.sendKeys("Directorate");

            // Password
            WebElement password =
                    driver.findElement(By.id("txtpassword"));
            password.sendKeys("Audit@12345");

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
            
            Thread.sleep(2000);
            
            
         // 🔹 candidate Dashboard Tab Check
            WebElement candidateDashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'Candidate Dashboard')]")
                )
            );

            Assert.assertTrue(
            		candidateDashboard.isDisplayed(),
                "❌ Candidate Dashboard tab is NOT visible"
            );
            System.out.println("✅ Candidate Dashboard tab is visible");
            
            
            
            
            
            
            
            

            WebElement candidatetab = wait.until(
           		    ExpectedConditions.visibilityOfElementLocated(
           		      //  By.xpath("//input[@id='btnTerminate')]")
           		      By.xpath("//button[@id='candidate-tab']")
           		    )
           		);

        		   
            candidatetab.click();       	
        	
            
            
            
            
            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
           js1.executeScript("window.scrollBy(0, 300);");
            
           
            
         // Pehle element visible hone ka wait karo
            WebElement Candidatesregistered = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("Candidates_registered")
                )
            );

            // Phir text lo
            String rawText = Candidatesregistered.getText().trim();
            System.out.println("Raw Text = " + rawText);

            int registeredCount = Integer.parseInt(rawText);
            System.out.println("Registered candidate Count = " + registeredCount);

            Assert.assertTrue(
                registeredCount > 0,
                "Registered Candidate count should be greater than 0"
            );
          
            
            
            
            int registeredCount1 = Integer.parseInt(
            	    driver.findElement(
            	        By.id("Candidates_registered")
            	    ).getText().trim()
            	);

            	System.out.println(
            	    "Registered Candidate Count = " + registeredCount1
            	);

            	Assert.assertTrue(
            	    registeredCount1 > 0,
            	    "Registered Candidate count should be greater than 0"
            	);
            
            
            
            
            
            	
            	 WebElement cregistration =
                         wait.until(ExpectedConditions.elementToBeClickable(
                                 By.xpath("//a[@href='/Web/CandidateReport/AllCandidateRegisteredDtl']")));
                 
            	 cregistration.click();
                 System.out.println("✅ Clicked on candidate registration");
                 
            	
            	
            	
                 WebElement search = wait.until(
                		    ExpectedConditions.visibilityOfElementLocated(
                		      //  By.xpath("//input[@id='btnTerminate')]")
                		      By.xpath("//button[@id='btnSearch']")
                		    )
                		);

             		   
                 search.click();       	
             	
                  Thread.sleep(8000);
            
            
            
                  JavascriptExecutor js2 = (JavascriptExecutor) driver;
                  js2.executeScript("window.scrollBy(0, 600);");
                  
                  Thread.sleep(8000);
                  
                  
                  JavascriptExecutor js22 = (JavascriptExecutor) driver;
                  js22.executeScript("window.scrollBy(0, -600);");
                  
                  
            
           
                  WebElement back = wait.until(
              		    ExpectedConditions.visibilityOfElementLocated(
              		      //  By.xpath("//input[@id='btnTerminate')]")
              		      By.xpath("//button[@id='btnback']")
              		    )
              		);

           		   
               back.click();       	
           	
                Thread.sleep(8000);
                  
                  
                  
               
                // 🔹 candidate Dashboard Tab Check
                WebElement candidateDashboard1 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[contains(text(),'Candidate Dashboard')]")
                    )
                );

                Assert.assertTrue(
                		candidateDashboard1.isDisplayed(),
                    "❌ Candidate Dashboard tab is NOT visible"
                );
                System.out.println("✅ Candidate Dashboard tab is visible");
                
            
                WebElement candidatetab1 = wait.until(
               		    ExpectedConditions.visibilityOfElementLocated(
               		      //  By.xpath("//input[@id='btnTerminate')]")
               		      By.xpath("//button[@id='candidate-tab']")
               		    )
               		);

            		   
                candidatetab1.click();       	
            	
                
                System.out.println("✅ Candidate Dashboard tab is clicked");
                
                
                
              JavascriptExecutor js4 = (JavascriptExecutor) driver;
               js4.executeScript("window.scrollBy(0, 600);");
                
                
               Thread.sleep(8000);
              
               int cpcomplete = Integer.parseInt(
               	    driver.findElement(
               	        By.id("Candidates_registered_and_completed_profile")
               	    ).getText().trim()
               	);

               	System.out.println(
               	    "Registered Candidate Count = " + cpcomplete
               	);

               	Assert.assertTrue(
               			cpcomplete > 0,
               	    "candidate profile complete count should be greater than 0"
               	);
               
               
               
              
               
               
               
               
               
               
               
               
               
                
            
            	
            	
            	
                	
                	int trgpm = Integer.parseInt(
                    	    driver.findElement(
                    	        By.id("Candidates_indicated_their_preferred_TRG_programs")
                    	    ).getText().trim()
                    	);

                    	System.out.println(
                    	    "non epf Count = " + trgpm
                    	);

                    	Assert.assertTrue(
                    			trgpm > 0,
                    	    "trgpm Count should be greater than 0"
                    	);
                	
                	
                	

                    	int TCA = Integer.parseInt(
                        	    driver.findElement(
                        	        By.id("Total_Candidates_Applied")
                        	    ).getText().trim()
                        	);

                        	System.out.println(
                        	    "VACANCIES CREATED (TOTAL) = " + TCA
                        	);

                        	Assert.assertTrue(
                        			TCA > 0,
                        	    "TCA Count should be greater than 0"
                        	);
                    	
                    	
                    	
                          	WebElement cregistration1 =
                                    wait.until(ExpectedConditions.elementToBeClickable(
                                            By.xpath("//a[@href='/Web/CandidateReport/AllCandidateRegisteredDtl']")));
                            
                       	 cregistration1.click();
                            System.out.println("✅ Clicked on candidate registration");
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                       	
                             
                        	
                        	
                        	
                        	
                        	
                            
                             
                             
                    	
                             
                             // yadi madhya pradesh lena ho tab
                                 
                              // Dropdown open
                               //  WebElement stateDropdown = wait.until(
                                   //      ExpectedConditions.elementToBeClickable(
                                         //        By.id("select2-StateDropDown-container")));

                               //  stateDropdown.click();

                                 // Search box
                               //  WebElement searchBox = wait.until(
                                    //     ExpectedConditions.visibilityOfElementLocated(
                                            //     By.xpath("//input[@class='select2-search__field']")));

                             //    searchBox.sendKeys("MADHYA PRADESH");

                                 // Option select
                             //    wait.until(ExpectedConditions.elementToBeClickable(
                                    //     By.xpath("//li[text()='MADHYA PRADESH']"))).click();
                                 
                                 
                                
                                 
                                 
                                 
                                 
                              // Jis state ko select karna hai
                                 String stateName = "MADHYA PRADESH";    // Ya "MADHYA PRADESH"

                                 // Dropdown open
                                 WebElement stateDropdown = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.id("select2-StateDropDown-container")));

                                 stateDropdown.click();

                                 // Search box
                                 WebElement searchBox = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                                 By.xpath("//input[@class='select2-search__field']")));

                                 searchBox.clear();
                                 searchBox.sendKeys(stateName);

                                 // Option select
                                 WebElement option = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.xpath("//li[normalize-space()='" + stateName + "']")));

                                 option.click();

                                 System.out.println("✅ Selected State : " + stateName);
                                 
                                 
                                 
                                 
                                 
                                 
                                 // Jis Division ko select karna hai
                                 String divisionName = "Bhopal";    // Ya "MADHYA PRADESH me bhopal"

                                 // Dropdown open
                                 WebElement divisionDropdown = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.id("select2-DivisionDropDown-container")));

                                 divisionDropdown.click();

                                 // Search box
                                 WebElement searchBoxd = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                                 By.xpath("//input[@class='select2-search__field']")));

                                 searchBoxd.clear();
                                 searchBoxd.sendKeys(divisionName);

                                 // Option select
                                 WebElement optiond = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.xpath("//li[normalize-space()='" + divisionName + "']")));

                                 optiond.click();

                                 System.out.println("✅ Selected division : " + divisionName);
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                              // Jis District ko select karna hai
                                 String districtName = "BHOPAL";    // Ya "MADHYA PRADESH me bhopal"

                                 // Dropdown open
                                 WebElement districtDropdown = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.id("select2-DistrictDropDown-container")));

                                 districtDropdown.click();

                                 // Search box
                                 WebElement searchBoxdis = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                                 By.xpath("//input[@class='select2-search__field']")));

                                 searchBoxdis.clear();
                                 searchBoxdis.sendKeys(districtName);

                                 // Option select
                                 WebElement optiondis = wait.until(
                                         ExpectedConditions.elementToBeClickable(
                                                 By.xpath("//li[normalize-space()='" + districtName + "']")));

                                 optiondis.click();

                                 System.out.println("✅ Selected district : " + districtName);
                                 
                                 
                                 
                                 
                                 WebElement fromDate = wait.until(
                                		    ExpectedConditions.visibilityOfElementLocated(
                                		        By.id("FromDate")
                                		    )
                                		);

                                		fromDate.sendKeys("12-06-2023");

                                		
                                		// Current value पढ़ें
                                		String selectedDate = fromDate.getDomProperty("value");

                                		System.out.println("From Date = " + selectedDate);
                                 
                                 
                                 
                                 
                                 
                                 
                                		    WebElement ToDate = wait.until(
                                        		    ExpectedConditions.visibilityOfElementLocated(
                                        		        By.id("ToDate")
                                        		    )
                                        		);

                                		    ToDate.sendKeys("11-06-2024");

                                		    System.out.println(
                                		            "To Date = " + ToDate.getDomProperty("value")
                                		    );
                                 
                                 
                                 
                                 
                                 
                                 
                                 WebElement searchBtn = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                                // By.xpath("//button[@onclick='IOMapChange()']")
                                        		 By.id("btnSearch")));
                                         
                                 
                                 searchBtn.click();
                                 System.out.println("✅ search button clicked");
                                 
                                 
                                 
                                 Thread.sleep(8000);
                                 
                                 
                                 
                                 
                                 
                                 
                                 WebElement table = wait.until(
                                	        ExpectedConditions.visibilityOfElementLocated(
                                	                By.id("TBLReport_wrapper")));

                                	Assert.assertTrue(table.isDisplayed());

                                	System.out.println("✅ Table displayed successfully");
                                 
                                 
                                 
                                	// Data verify
                                	List<WebElement> rows = driver.findElements(
                                	        By.xpath("//table[@id='TBLReport']/tbody/tr"));

                                	Assert.assertTrue(rows.size() > 0,
                                	        "❌ Table me koi data nahi hai");

                                	System.out.println("✅ Table contains " + rows.size() + " rows.");
                                 
                                 
                                	
                                	
                                	
                                	JavascriptExecutor js9 = (JavascriptExecutor) driver;
                                    js9.executeScript("window.scrollBy(0, 800);");
                                	
                                	
                                	
                                	WebElement info = wait.until(
                                	        ExpectedConditions.visibilityOfElementLocated(
                                	                By.id("TBLReport_info")));

                                	String text = info.getText();

                                	System.out.println(text);
                                 
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	// Table visible hai
                                	WebElement table1 = wait.until(
                                	        ExpectedConditions.visibilityOfElementLocated(
                                	                By.id("TBLReport")));

                                	Assert.assertTrue(table1.isDisplayed(), "❌ Table is not displayed");

                                	// Header elements
                                	List<WebElement> headers = driver.findElements(
                                	        By.xpath("//table[@id='TBLReport']/thead/tr/th"));

                                	// Expected Header Names
                                	String[] expectedHeaders = {
                                	        "Sr. No.",
                                	        "OJT State",
                                	        "OJT Division",
                                	        "OJT District",
                                	        "Establishment Name",
                                	        "Establishment ID",
                                	        
                                	        "Department Name",
                                	        
                                	        "Authorized Person Mobile Number",
                                	        "OJT Address",
                                	        "OJT Location",
                                	        "Establishment Type",
                                	        "EPF Number",
                                	        "Trainee Name",
                                	        "Samagra ID",
                                	        "Father Name",
                                	        "Mother Name",
                                	        "Gender",
                                	        "District",
                                	        "Trainee Address",
                                	        "Mobile Number",
                                	        "WhatsApp Number",
                                	        "Trainee Email",
                                	        "Trainee Category",
                                	        "Trainee Status",
                                	        "CONTRACT REFRENCE ID",
                                	        "DBT Enabled",
                                	        "Aadhar Linked With Bank",
                                	        "Sector Name",
                                	        "Course Name",
                                	        "JOINING STATUS",
                                	        "Approved Date",
                                	        "CONTRACT APPROVED DATE",
                                	        "JOINING DATE",
                                	        "TRAINING DURATION",
                                	        "COMPLETION DATE",
                                	        "Termination Date",
                                	        "Qualification Type",
                                	        "BOCW",
                                	        "Assessment Eligibility",
                                	        "Attendance Percentage",
                                	        "Certificate Status",
                                	        
                                	        
                                	};

                                	// Count verification
                                	Assert.assertEquals(headers.size(), expectedHeaders.length,
                                	        "❌ Header count mismatch");

                                	// Name + Order verification
                                	for (int i = 0; i < expectedHeaders.length; i++)
                                	{
                                	    String actualHeader = headers.get(i).getText().trim().replace("\n", " ");

                                	    System.out.println("Column " + (i + 1)
                                	            + " | Expected : " + expectedHeaders[i]
                                	            + " | Actual : " + actualHeader);

                                	    Assert.assertEquals(actualHeader,
                                	            expectedHeaders[i],
                                	            "❌ Header mismatch at column " + (i + 1));
                                	}

                                	System.out.println("✅ All column names and order verified successfully.");
                                 
                                	
                                	
                                	
                                	// Search box
                                	WebElement searchBox1 = wait.until(
                                	        ExpectedConditions.visibilityOfElementLocated(
                                	                By.xpath("//input[@type='search']")));

                                	searchBox1.clear();
                                	searchBox1.sendKeys("BHOPAL");
                                	
                                	Thread.sleep(2000);   // Table refresh hone ka wait
                                	
                                	
                                	List<WebElement> rows1 = driver.findElements(
                                	        By.xpath("//table[@id='TBLReport']/tbody/tr"));

                                	Assert.assertTrue(rows1.size() > 0, "No records found");

                                	for (int i = 1; i <= rows1.size(); i++)
                                	{
                                	    String establishmentName = driver.findElement(
                                	            By.xpath("//table[@id='TBLReport']/tbody/tr[" + i + "]/td[4]"))
                                	            .getText();

                                	    System.out.println(establishmentName);

                                	    Assert.assertTrue(
                                	            establishmentName.toUpperCase().contains("BHOPAL"),
                                	            "Search validation failed at row " + i);
                                	}

                                	System.out.println("✅ Search Result Validation Passed");
                                	
                                 
            
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	// 1. Click header   sort karne ke liye
                                //	WebElement stateHeader = wait.until(
                                	      //  ExpectedConditions.elementToBeClickable(
                                	            //    By.xpath("//table[@id='TBLReport']/thead/tr/th[2]")));

                                //	stateHeader.click();

                                	// 2. Read table values
                                	//List<WebElement> stateElements = driver.findElements(
                                	      //  By.xpath("//table[@id='TBLReport']/tbody/tr/td[2]"));

                                	//List<String> actualList = new ArrayList<>();

                                //	for (int i = 0; i < stateElements.size(); i++)
                                	//{
                                	   // actualList.add(stateElements.get(i).getText().trim());
                                	//}

                                	// 3. Create expected sorted list
                                	//List<String> expectedList = new ArrayList<>(actualList);

                                //	Collections.sort(expectedList);

                                	// 4. Validate
                                //	Assert.assertEquals(actualList, expectedList,
                                	        //"Ascending sorting failed");

                                	//System.out.println("✅ Ascending sorting validation passed");
                                	
                                	
                                	
                                	
                                	
                                	
                           // sort karne ke liye easy method
                                	
                                	// First row ka OJT State click se pehle
                                	String beforeSort = driver.findElement(
                                	        By.xpath("//table[@id='TBLReport']/tbody/tr[1]/td[2]"))
                                	        .getText().trim();

                                	System.out.println("Before Sorting : " + beforeSort);

                                	// OJT State Header par click
                                	WebElement stateHeader = wait.until(
                                	        ExpectedConditions.elementToBeClickable(
                                	                By.xpath("//table[@id='TBLReport']//th[normalize-space()='OJT State']")));

                                	stateHeader.click();

                                	System.out.println("✅ OJT State Header clicked");

                                	// Table refresh hone ka wait
                                	Thread.sleep(2000);

                                	// First row ka OJT State click ke baad
                                	String afterSort = driver.findElement(
                                	        By.xpath("//table[@id='TBLReport']/tbody/tr[1]/td[2]"))
                                	        .getText().trim();

                                	System.out.println("After Sorting : " + afterSort);

                                	// Validation
                                	if (!beforeSort.equals(afterSort))
                                	{
                                	    System.out.println("✅ Sorting is working.");
                                	}
                                	else
                                	{
                                	    System.out.println("⚠ Sorting may not have changed the first row.");
                                	}

                                	Assert.assertNotEquals(beforeSort, afterSort,
                                	        "❌ Sorting is not working.");
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
                                	
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

