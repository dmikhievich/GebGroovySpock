package page.tut

import geb.Page

class TutMainPage extends Page {

  static at = {
    title == 'Белорусский портал TUT.BY'
  }

  static content = {
    enterButton { $ ('.enter') }
    loginField { $ ('[name="login"]') }
    passwordField { $ ('[name="password"]') }
    submitButtom { $ ('.button.auth__enter') }
    userNameSpan { $ ('.uname') }
    searchField { $ ('#search_from_str') }
    searchButton(to: SearchResultsPage) { $ ("input[name='search']") }
  }

  def login(username, password) {
    enterButton.click ()
    loginField = username
    passwordField = password
    submitButtom.click ()
  }

  def search(String searchCriteria) {
    searchField << searchCriteria
    searchButton.click ()
  }
}
