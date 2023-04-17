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
driver.find_element(By.XPATH, "//a[@href='https://alchemy.hguy.co/lms/all-courses/']").click();

courseTitle = driver.find_element(By.XPATH, "//*[@id='post-71']/div[2]/h3").text;
assert courseTitle == "Email Marketing Strategies"
driver.quit();
