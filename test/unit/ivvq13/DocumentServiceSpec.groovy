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
		def categ = new Category(name:"OS")
		categ.save()
		
		def title_ = "title"
		def category_ = "OS"
		def content_ = "my content"
		def tags_ = "a,b,c"
		def attachments_ = "attach"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()
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
		
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
	 		
	
		expect:
		assert res == true

	}
	
	void "Document service unit test : serviceCreateDocument fail (same title) "() {
		setup:
		//persist a document, check it out
		
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
				
		def title2_ = "title"
		def category2_ = "OS"
		def content2_ = "my content"
		def tags2_ = "a,b,c"
		def attachments2_ = "attach"
		def user2_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user2_.save()
		def res2 = service.serviceCreateDocument(
			title2_,
			category2_,
			content2_,
			tags2_,
			attachments2_,
			user2_)
			 
	
		expect:
		assert res == true
		assert res2 == false

	}
	

	void "Document service unit test : serviceGetById success"() {
		setup:
		//persist a document, check it out
		
		def res = service.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
		
		def fd = Document.findByTitle("title")
		
		def doc = service.serviceGetById(fd.id)
		
		expect:
		assert doc.title == "title"

	}
	
}
