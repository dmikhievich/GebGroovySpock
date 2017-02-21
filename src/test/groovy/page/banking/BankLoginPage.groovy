package page.banking

import geb.Page

class BankLoginPage extends Page {
  static url = "http://www.way2automation.com/angularjs-protractor/banking/#/login"
  static at = { title == "Protractor practice website - Banking App" }

  static content = {
    customerLoginButton(wait:true) { $ ("button[ng-click='customer()']") }
    userSelect(wait:true) { $ ("#userSelect") }
    yourNameSelectOp { "#userSelect option" }
    loginButton(wait:true, to:AccountPage) { $ ("form[name='myForm'] .btn.btn-default") }
    userNameSpan { $ (".fontBig.ng-binding") }
  }

  void login(username) {
    customerLoginButton.click ()
    waitFor { userSelect.displayed }
    userSelect.value (username)
    loginButton.click ()
    waitFor { userNameSpan.text () == username }
  }
}
