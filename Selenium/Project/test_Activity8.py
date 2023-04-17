# Import webdriver from selenium
from threading import Thread

import selenium
from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/lms")

driver.findElement(By.XPATH, "//a[@href='https://alchemy.hguy.co/lms/contact/']").click()

driver.findElement(By.XPATH, "//input[@name='wpforms[fields][0]']").sendKeys("apurvi" + Keys.TAB)
driver.findElement(By.XPATH, "//input[@name='wpforms[fields][1]']").sendKeys("apurvi@qq.com" + Keys.TAB)
driver.findElement(By.XPATH, "//input[@name='wpforms[fields][3]']").sendKeys("data science" + Keys.TAB)
driver.findElement(By.XPATH, "//textarea[@name='wpforms[fields][2]']").sendKeys("Please enquire" + Keys.TAB)
driver.findElement(By.XPATH, "//*[@id='wpforms-submit-8']").sendKeys(Keys.ENTER)
Thread.sleep(3000);
message = driver.findElement(By.XPATH, "//*[@id='wpforms-confirmation-8']").getAttribute("innerText")
print(message)
