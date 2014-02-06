package ivvq13

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestMixin(GrailsUnitTestMixin)
@Mock([Document,Attachment,Category,Message,Rating,Tag,User])
class DocumentServiceSpec extends Specification { 

	//The purpose of this class is to test the document service
	
	def setup() {
		
	}

	def cleanup() {
		
	}
	


	void "Document service unit test : serviceGetAll "() {
		setup:
		def myList = Document.all
		def serviceList = service.serviceGetAll()

		expect:
		myList.size() == serviceList.size()

	}
		
	void "Document service unit test : serviceCreateDocument success"() {
		setup:
		//persist a document, check it out
		def title_ = "title"
		def category_ = "category"
		def content_ = "my content"
		def tags_ = "a,b,c"
		def attachments_ = "attach"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()		
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
	 		
	
		expect:
		assert res == "/document/list"

	}
	
	
	
	void "Document service unit test : serviceGetById "() {
		setup:
		//persist a document, check it out
		def title_ = "title"
		def category_ = "category"
		def content_ = "my content"
		def tags_ = "a,b,c"
		def attachments_ = "attach"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()		
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)

		expect:
		assert service.serviceGetById(1) != null

	}
	
	void "Document service unit test : serviceGetByTitle "() {
		
		setup:
		//persist a document, check it out
		def title_ = "title"
		def category_ = "category"
		def content_ = "my content"
		def tags_ = "a,b,c"
		def attachments_ = "attach"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
		

		expect:
		//assert Document.findByTitle("title") != null
		assert service.serviceGetByTitle("title") != null

	}
	
}
