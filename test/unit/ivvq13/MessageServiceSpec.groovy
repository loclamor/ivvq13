package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MessageService)
@Mock([Document,Category,Message,User])
class MessageServiceSpec extends Specification {

	def setup() {
		def user = new User(username: "alex", password: "alex", email:"a@a.c")
		user.save()
		def theUser = User.findByUsername("alex")
		def categ = new Category(name:"CATEG")
		categ.save()
		def theCateg = Category.findByName("CATEG")
		def document = new Document(category:theCateg, user:theUser, title:"the title", content:"the content")
		document.save()
	}

	@Override
	def cleanup() {
	}

	void "Message service unit test : getMesagesFromDocument success"() {
		setup:

		def user = User.findByUsername("alex")
		//add a message to the document
		def mess = new Message(title:"messTitle", content: "messContent", author:user)
		mess.save();
		
		def theDoc = Document.findByTitle("the title")
		def theMess = Message.findByTitle("messTitle")
		theDoc.addToMessages( theMess)
		theDoc.save()
		
		def messArray = service.getMesagesFromDocument( theDoc.id )
		expect:
		assert messArray.isEmpty() == false
		assert messArray.size() == 1
	}
}
