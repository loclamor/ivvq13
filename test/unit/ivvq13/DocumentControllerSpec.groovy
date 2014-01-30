
package ivvq13

import org.springframework.web.servlet.view.RedirectView;

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(DocumentController)
@Mock([Document,Attachment,Category,Message,Rating,Tag,User])
class DocumentControllerSpec extends Specification {

	def setup() {
		
	}

	def cleanup() {
	}
	
	/*def "run DocumentController tests"() {
		when:
		def model = controller.list()
		
		then:
		assert controller.modelAndView == null
		assert response.redirectedUrl == null
	}
	*/
	
/*	def "create document"(){
		
		
		when:		
		controller.create()
		
		then:
		assert response.status == 200
		assert response.redirectedUrl == "/document/create_page"
	}
	
	def "show document list with documents"(){
		
		
		when:
		def model = controller.list()
		
		then:
		assert response.status == 200
		assert response.redirectedUrl == "/document/list"
	}*/
	
	/*def "intent to create new document should redirect to create page"() {
		given:
					
			
		//expect:
			//view = "/document/create_page"
	}*/
	
	/*def "document creation should redirect to list page when creating a true document"(){
		when:
		controller.create()

		then:
		assert view == "/document/list"
	}*/
	
	/*def "document list should redirect to document list page"() {
		when:
		controller.list()

		then:
		assert view == "/document/list"
	}
	
	def "document view should redirect to view page"() {
		when:
		controller.view()

		then:
		assert view == "/document/view"
	}*/
	
	/*void testQuery() {
		def books = [
				new Book(title: "The Stand"),
				new Book(title: "The Shining")]
		books*.save()
		assertEquals 2, Book.list().size()
	}*/
	
	
}
