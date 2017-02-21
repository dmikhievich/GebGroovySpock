import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

baseUrl = "http://www.tut.by"
reportsDir = new File ("target/runtime_reports_dir")

waiting {
  timeout = 20
}

System.setProperty ("webdriver.gecko.driver", getFullPathToDriver("geckodriver.exe"))
System.setProperty ("webdriver.chrome.driver", getFullPathToDriver("chromedriver.exe"))
System.setProperty ("webdriver.ie.driver", getFullPathToDriver("IEDriverServer.exe"))

environments {

  chrome {
      driver = { new ChromeDriver () }
  }

  firefox = {
    driver = { new FirefoxDriver () }
  }

  ie {
    def capabilities = DesiredCapabilities.internetExplorer ()
    capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true)
    driver = { new InternetExplorerDriver (capabilities) }
  }
}

private static String getFullPathToDriver(String driverFileName) {
  new File ("driver${File.separatorChar}$driverFileName").absolutePath
}
