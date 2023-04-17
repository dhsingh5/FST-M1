# Import webdriver from selenium
import selenium
from selenium import webdriver

selenium.webdriver.common.by
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/lms")
    srtTitle = driver.title
    assert "Alchemy LMS – An LMS Application" == srtTitle

# Close the browser
driver.quit()
