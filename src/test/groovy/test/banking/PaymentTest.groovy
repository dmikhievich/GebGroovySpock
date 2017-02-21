package test.banking

import geb.spock.GebReportingSpec
import page.banking.BankLoginPage

class PaymentTest extends GebReportingSpec {

  private static final int POSITIVE_AMOUNT = 100

  def "User perform the payment operation"() {
   given: "Login page is opened"
    to BankLoginPage

   when: "user performs login"
    login ("Harry Potter")

   and: "refills the deposit"
    refillDeposit (POSITIVE_AMOUNT)

   then: "success message should appear"
    message.text() == 'Deposit Successful'
  }
}
