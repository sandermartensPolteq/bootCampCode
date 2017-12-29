using System;
using System.Drawing;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCamp
{
    [TestClass]
    public class UnitTest1
    {
        ChromeDriver driver;
        string url = "https://techblog.polteq.com/testshop/index.php";
        string mail = "sander.martens+webshop1@polteq.com";
        string password = "Test1234!";

        [TestMethod]
        public void TestMethod1()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl(url);

            findElementByClassNameClick("login");                                   //driver.FindElement(By.ClassName("login")).Click();
            findElementByIdSendKeys("email", mail);                                 //driver.FindElement(By.Id("email")).SendKeys(mail);
            findElementByIdSendKeys("passwd", password);                            //driver.FindElement(By.Id("passwd")).SendKeys(password);
            findElementByIdClick("SubmitLogin");                                    //driver.FindElement(By.Id("SubmitLogin")).Click();
            IWebElement userName = driver.FindElement(By.ClassName("account"));     //WebElement opvragen
            highlightScreenShot(userName);                                          //WebElement highlighten (rode omkadering)
            Assert.AreEqual(userName.Text, "Sander Martens");                       //Assertion toevoegen
            driver.Quit();
        }

        //Methodes om elementen op te benaderen, highlighten & klikken
        public void highlightScreenShot( IWebElement element)
        {
            String dateStamp = DateTime.Now.ToString("dd-MM-yyyy-hh-mm-ss");
            var javaScriptDriver = (IJavaScriptExecutor)driver;
            string highlightJavascript = @"arguments[0].style.cssText = ""border-width: 5px; border-style: solid; border-color: red"";";
            javaScriptDriver.ExecuteScript(highlightJavascript, new object[] { element });
            Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
            ss.SaveAsFile("../test.png", ScreenshotImageFormat.Png);
        }
        public void findElementByClassNameClick(string id)
        {
            IWebElement element = driver.FindElement(By.ClassName(id));
            var javaScriptDriver = (IJavaScriptExecutor)driver;
            string highlightJavascript = @"arguments[0].style.cssText = ""border-width: 5px; border-style: solid; border-color: red"";";
            javaScriptDriver.ExecuteScript(highlightJavascript, new object[] { element });
            element.Click();
        }
        public void findElementByIdClick(string id)
        {
            IWebElement element = driver.FindElement(By.Id(id));
            var javaScriptDriver = (IJavaScriptExecutor)driver;
            string highlightJavascript = @"arguments[0].style.cssText = ""border-width: 5px; border-style: solid; border-color: red"";";
            javaScriptDriver.ExecuteScript(highlightJavascript, new object[] { element });
            element.Click();
        }
        public void findElementByClassNameSendKeys(string id, string key)
        {
            IWebElement element = driver.FindElement(By.ClassName(id));
            var javaScriptDriver = (IJavaScriptExecutor)driver;
            string highlightJavascript = @"arguments[0].style.cssText = ""border-width: 5px; border-style: solid; border-color: red"";";
            javaScriptDriver.ExecuteScript(highlightJavascript, new object[] { element });
            element.SendKeys(key);
        }
        public void findElementByIdSendKeys(string id, string key)
        {
            IWebElement element = driver.FindElement(By.Id(id));
            var javaScriptDriver = (IJavaScriptExecutor)driver;
            string highlightJavascript = @"arguments[0].style.cssText = ""border-width: 5px; border-style: solid; border-color: red"";";
            javaScriptDriver.ExecuteScript(highlightJavascript, new object[] { element });
            element.SendKeys(key);
        }
    }
}
