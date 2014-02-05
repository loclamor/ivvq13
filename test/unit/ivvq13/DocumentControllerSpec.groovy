
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
	
	def setup() {
		
	}

	def cleanup() {
	}
	
	def "list function should redirect to list page"() {
	
		given:
		//this shit returns null because there is nothing in DB !
		def model = controller.list() 

	    expect:
	    response.status == 200
	    model.view == '/document/list'		
			
	}
	
	def "create function should redirect to list page"() {
		
	}
	
	def "create_page function should redirect to create page view"() {
		
		given:
		def model = controller.create_page()

	    expect:
	    response.status == 200
	    modelAndView == '/document/create_page'		
		
	}
	
	
}
