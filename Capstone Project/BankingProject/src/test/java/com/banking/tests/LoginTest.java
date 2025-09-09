package com.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyTitleContainsParaBank() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("ParaBank"), "❌ Title does not match!");
    }
}
