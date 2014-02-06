
package ivvq13

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
	
	
}
