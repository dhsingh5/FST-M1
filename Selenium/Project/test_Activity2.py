# Import webdriver from selenium
import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")

# Get the page Heading
strHeading = driver.find_element(By.CLASS_NAME, "uagb-ifb-title").text;
# Assertion
assert strHeading == "Learn from Industry Experts"
# Close the browser
driver.quit()
