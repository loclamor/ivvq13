package ivvq13

import java.lang.ProcessBuilder.Redirect;
import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(DocumentController)
@Mock([Document,Attachment,Category,Message,Rating,Tag,User])
class DocumentControllerSpec extends Specification {

	
	//The purpose of this class is to test the document controller. redirects only !
	//There is no point in testing whether the controller redirects to method name
	def setup() {
		
	}

	def cleanup() {
	}
	
	
		
//	def "Document controller unit tests: list get id -> view page"() {
//		setup:
//		def docService = Mock(DocumentService)
//		
//		
//		when:
//		
//		controller.view(0)
//		
//		then:		
//		
//	}
	
	def "Document controller unit tests: create -> list page"() {
			when:	
			controller.create()
	
			then:
			assert response.redirectedUrl == "/document/create_page"
	
	}
	
	def "Document controller unit tests: create fail title -> create_page page"() {
		when:
		controller.create()

		then:
		assert response.redirectedUrl == "/document/create_page"

	}
	
	
}
