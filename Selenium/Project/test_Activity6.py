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

driver.find_element(By.LINK_TEXT, "My Account").click()
pageTitle = driver.getTitle

assert pageTitle == "My Account – Alchemy LMS"

driver.findElement(By.LINK_TEXT, "Login").click()

driver.findElement(By.ID, "user_login").sendKeys("root")
driver.findElement(By.ID, "user_pass").sendKeys("pa$$w0rd")

driver.findElement(By.NAME, "wp-submit").click()

textEle = driver.findElement(By.CSS_SELECTOR, ".ld-section-heading > h3").getText()

assert textEle == "Your Courses"
