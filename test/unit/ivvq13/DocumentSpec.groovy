package ivvq13

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([Document,Attachment,Category,Message,Rating,Tag,User])
class DocumentSpec extends Specification {

	//The purpose of this class is to test the document
	
	def setup() {
	}

	def cleanup() {
	}

	
}
