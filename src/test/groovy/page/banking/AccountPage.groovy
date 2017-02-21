package page.banking

import geb.Page

/**
 * Created by Dzmitry_Mikhievich
 */
class AccountPage extends Page {

  static at = { title == "Protractor practice website - Banking App" }

  static content = {
    userName { $ ('strong span.fontBig') }

    message(wait: true) { $('span[ng-show="message"]') }

    transations { $ ("button[ng-click='transactions()']") }

    depositTab { $ ("button[ng-click='deposit()']") }
    depositeForm (wait: true) { $ ('form[ng-submit="deposit()"]') }
    depositInput { depositeForm.find ('input[ng-model="amount"]') }
    submitDeposit { depositeForm.find ('button[type="submit"]') }

    withdraw { $ ("button[ng-click='withdrawl()']") }
  }

  def refillDeposit(amount) {
    depositTab.click ()
    depositInput = amount
    submitDeposit.click ()
  }
}
