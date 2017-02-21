package test.tut

import geb.spock.GebReportingSpec
import page.tut.SearchResultsPage
import page.tut.TutMainPage
import spock.lang.Issue
import spock.lang.Unroll

@Issue(["Search issue"])
class TutBySearchSpec extends GebReportingSpec {

  @Unroll
  def "Search works at main page based on the criteria: #searchCriterion"(String searchCriterion, List resultFragments) {

   given: "Main page is opened"
    to TutMainPage

   when: "enter search criteria"
    search (searchCriterion)

   then: "Page with search results appears"
    at SearchResultsPage

   and: "the page contains criteria previously defined in search input"
    searchInput.value () == searchCriterion

   and: "links found by the criteria actually contain criteria in name"
    getResultLinkDescriptions ().each { description ->
      assert resultFragments.any { description.contains (it) }, "Description [$description] doesn't contain any fragment"
    }

   where:
    searchCriterion | resultFragments
    'Minsk'         | ['Minsk', "Минск", "МИНСК", 'путеводитель']
  }
}