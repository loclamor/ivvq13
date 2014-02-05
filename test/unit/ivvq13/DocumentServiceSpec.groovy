package ivvq13

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([Document])
class DocumentServiceSpec extends Specification {

	//The purpose of this class is to test the document service
	
	def setup() {
		
	}

	def cleanup() {
	}

	void "test service which gets all documents"() {
		setup:
		def myList = Document.all
		def serviceList = service.serviceGetAll()
		
		expect:
		myList.size() == serviceList.size()
		
	}
	
//	void "test service which gets document by title"() {
//		setup:
//		//create doc
//		def doc = service.serviceGetByTitle("spock")
//		
//		expect:
//		
//		
//	}
	
//	void "test service which gets document by title"() {
//		setup:
//		
//		when:
//		
//		then:
//		
//		
//	}
//	
}
