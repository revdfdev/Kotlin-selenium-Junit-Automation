package com.rkodekar.selenium.tests

import com.rkodekar.selenium.driverutils.DriverFactory
import com.rkodekar.selenium.entities.Environment
import com.rkodekar.selenium.pageObjects.HomePage
import com.rkodekar.selenium.pageObjects.LandingPage
import com.rkodekar.selenium.pageObjects.ShopPage
import com.rkodekar.selenium.yamlutils.YamlUtils
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver
import java.io.File

class RunTests {

    private var driver: WebDriver? = null
    private var environment: Environment? = null
    private var landingPage: LandingPage? = null
    private var homePage: HomePage? = null
    private var shopPage: ShopPage? = null

    @Before
    fun setUp() {
        driver = DriverFactory.browser
        setUpEnvironment()
        landingPage = LandingPage(driver!!, environment!!)
        shopPage = ShopPage(driver!!, environment!!)
        homePage = HomePage(driver!!, environment!!)
    }

    @Test
    fun testHomePageWithThreeSlidersOnly() {
        landingPage?.openLandingPage()
        assertEquals(true, landingPage?.checkIfShopButtonIsDisplayed())
        landingPage?.clickOnShopButton()
        assertEquals(true, shopPage?.checkIfShopPageIsDisplayed())
        assertEquals(true, shopPage?.checkIfHomeButtonIsDisplayed())
        shopPage?.clickOnHomeButton()
        assertEquals(true, homePage?.isSliderContainerDisplayed())
        assertEquals(3, homePage?.sliders()?.size)
    }

    @After
    fun tearDown() {
        driver?.quit()
    }


    private fun setUpEnvironment() {
        val filename = "src/test/resources/environment.yaml"
        val file = File(filename)
        environment = YamlUtils(file).use {
            it.compute()
        }
    }
}