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

//	void "Document unit test : service which gets all documents"() {
//		setup:
//		def myList = Document.all
//		def serviceList = service.serviceGetAll()
//		
//		expect:
//		myList.size() == serviceList.size()
//		
//	}
	
	void "Document unit test : document creation test"() {
		setup:
		def contentDoc = "Test document"
		def contentMes = "Test message"
		def tag1 = new Tag(name:"tag 1")
		tag1.save()
		def tag2 = new Tag(name:"tag 2")
		tag2.save()
		def category = new Category(name:"Grails")
		category.save()
		def attachment = new Attachment(name: "www.google.com")
		attachment.save()
		def user = new User(username: "alex", password: "a", email:"alex@a.com")
		user.save()
		def rating = new Rating(author: user, value: 10)
		rating.save()
		def message = new Message(content: contentMes, title:"Hello", author:user)
		message.save()
		def doc = new Document()
		doc.setTitle("my title")
		doc.setUser(user)
		doc.setCategory(category)
		doc.addToTags(tag1)
		doc.addToTags(tag2)
		doc.addToMessages(message)
		doc.setContent(contentDoc)
		doc.addToRatings(rating)
		doc.addToAttachments(attachment)
		
		when:
		doc.save()
		
		then:
		assert doc.validate() == true
	}
	
	void "Document unit test : test database persistance"() {
		setup:
		def contentDoc = "Test document"
		def contentMes = "Test message"
		def tag1 = new Tag(name:"tag 1")
		tag1.save()
		def tag2 = new Tag(name:"tag 2")
		tag2.save()
		def category = new Category(name:"Grails")
		category.save()
		def attachment = new Attachment(name: "www.google.com")
		attachment.save()
		def user = new User(username: "alex", password: "a", email:"alex@a.com")
		user.save()
		def rating = new Rating(author: user, value: 10)
		rating.save()
		def message = new Message(content: contentMes, title:"Hello", author:user)
		message.save()
		def doc = new Document()
		doc.setTitle("my title")
		doc.setUser(user)
		doc.setCategory(category)
		doc.addToTags(tag1)
		doc.addToTags(tag2)
		doc.addToMessages(message)
		doc.setContent(contentDoc)
		doc.addToRatings(rating)
		doc.addToAttachments(attachment)
		
		def size_of_doc_db = Document.list().size()
		
		when:
		doc.save()
		
		then:
		assert size_of_doc_db == Document.list().size()-1
		
		}

	
}
