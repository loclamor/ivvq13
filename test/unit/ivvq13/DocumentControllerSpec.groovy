package ivvq13

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class DocumentControllerSpec extends Specification {

	def setup() {
		
	}

	def cleanup() {
	}

	void "test something"() {
	}
	
	def "document create should redirect to create page"() {
		when:
		controller.create()

		then:
		response.redirectedUrl == "/document/create"
		
	}
}
