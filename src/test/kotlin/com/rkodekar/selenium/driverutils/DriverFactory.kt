package com.rkodekar.selenium.driverutils

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver
import java.util.concurrent.TimeUnit

object DriverFactory {
    val browser: WebDriver
        get() {
            val _driver: WebDriver
            val _browserName = System.getProperty("browser", DriverTypes.CHROME.toString()).toUpperCase()
            val _driverType = DriverTypes.valueOf(_browserName)

            when(_driverType) {
                DriverTypes.CHROME -> {
                    WebDriverManager.chromedriver().setup()
                    _driver = ChromeDriver()
                }

                DriverTypes.FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup()
                    _driver = FirefoxDriver()
                }

                DriverTypes.OPERA -> {
                    WebDriverManager.operadriver().setup()
                    _driver = OperaDriver()
                }

                DriverTypes.EDGE -> {
                    WebDriverManager.edgedriver().setup()
                    _driver = EdgeDriver()
                }

                DriverTypes.IE -> {
                    WebDriverManager.iedriver().setup()
                    _driver = InternetExplorerDriver()
                }
            }

            _driver.manage().window().maximize()
            _driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS)

            return _driver
        }
}