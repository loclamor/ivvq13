import geb.spock.GebReportingSpec
  
class LoginSpec extends GebReportingSpec {
    def "go to page"() {
        when:
        go "http://www.grails.org.mx"
  
        then:
        title == "GrailsMX | Groovy y Grails en tu idioma"
    }
}