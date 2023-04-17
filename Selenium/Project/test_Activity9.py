# Import webdriver from selenium
from threading import Thread

import selenium
from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webelement import WebElement
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")

driver.findElement(By.XPATH, "//a[@href='https://alchemy.hguy.co/lms/all-courses/']").click()

driver.findElement(By.XPATH,
                   "//img[@src='https://alchemy.hguy.co/lms/wp-content/uploads/2019/05/course-1-free-img-400x223.jpg']").click()
driver.findElement(By.XPATH, "//a[@href='https://alchemy.hguy.co/lms/lessons/developing-strategy/']").click()

courseTitle = driver.title
print(courseTitle)
