package com.automate.tests;

import com.automate.base.TestBase;
import com.automate.pages.PostAnAdvert;
import com.automate.pages.SignUp;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostAnAdvertTest extends TestBase {

    @Step
    @Description("Posting an advert")
    @Test(priority = 1)
    public void postAnSellAdvert() { // done
        PostAnAdvert postAnAdvert = new PostAnAdvert(driver);
        postAnAdvert.openAko();
        postAnAdvert.startSellAdvert();
        postAnAdvert.fillBasicDetails();
        postAnAdvert.fillSpecifications();
        postAnAdvert.fillFeatures();
        postAnAdvert.fillPriceSection();
        postAnAdvert.fillImagesSection();

    }
}
