package com.gmail.testscripts;

import org.testng.annotations.Test;

import com.gmail.generics.BaseTest;
import com.gmail.generics.ReadExcel;
import com.gmail.pompages.HomePage;
import com.gmail.pompages.LoginPage;

public class SendEmail extends BaseTest {
	LoginPage loginPage = null;
	HomePage homePage = null;

	@Test
	public void tc_01_sendEmail() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		try {
			String[][] credentials = ReadExcel.getData(inputData, "Login");
			for (int i = 1; i < credentials.length; i++) {
				String email = credentials[i][0];
				String password = credentials[i][1];

				loginPage.enterEmail(email);
				loginPage.clickNext();
				loginPage.enterPassword(password);
				loginPage.clickNext();
				loginPage.verifyTitle("Inbox");

				String[][] emails = ReadExcel.getData(inputData, "SendEmail");

				for (int j = 1; j < emails.length; j++) {
					String subject = emails[j][0];
					String body = emails[j][1];

					homePage.clickComposeButton();
					homePage.enterTo(email);
					homePage.enterSubject(subject);
					homePage.enterBody(body);
					homePage.clickSendButton();
					Thread.sleep(3000);
					homePage.clickProfileButton();
					homePage.clickSignoutButton();
				}

			}
			// Assert.assertTrue(status)
			log.info("tc_01_sendEmail has passed");
		} catch (Exception e) {
			log.error("Testcase failed " + e);
		}
	}

}