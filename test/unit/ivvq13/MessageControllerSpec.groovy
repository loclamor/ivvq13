package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MessageController)
@Mock([Document,DocumentService,Attachment,Category,Message,Rating, RatingService, MessageService,Tag,User])
class MessageControllerSpec extends Specification {

	def setup() {
		
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
		doc.save()
	}

	def cleanup() {
	}

	void "Message Controller : add message ok"() {
		setup:
		params.inputTitle = "Hi"
		params.inputContent = "How are you ?"
		def mid = Document.findByTitle("my title")
		
		when:
		controller.add(mid.id)
		
		then:
		assert response.redirectedUrl == "/document/view/1"
		
	}
//	
//	void "Message Controller : add message duplicate"() {
//		setup:
//		params.inputTitle = "Hi"
//		params.inputContent = "How are you ?"
//		def mid = Document.findByTitle("my title")
//		
//		when:
//		controller.add(mid.id)
//		controller.add(mid.id)
//		
//		then:
//		assert response.redirectedUrl == "/document/view/1"
//		
//	}
}
