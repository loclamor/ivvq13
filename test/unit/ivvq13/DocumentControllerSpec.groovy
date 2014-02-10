package ivvq13

import java.lang.ProcessBuilder.Redirect;

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */

@TestFor(DocumentController)
@Mock([Document,DocumentService,Attachment,Category,Message,Rating, RatingService, MessageService, UserService,Tag,User])
class DocumentControllerSpec extends Specification {

	
	//The purpose of this class is to test the document controller. redirects only !
	//There is no point in testing whether the controller redirects to method name
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
		doc.setTitle("title")
		doc.setUser(user)
		doc.setCategory(category)
		doc.addToTags(tag1)
		doc.addToTags(tag2)
		doc.addToMessages(message)
		doc.setContent(contentDoc)
		doc.addToRatings(rating)
		doc.addToAttachments(attachment)
		doc.save()
		
		def categ = new Category(name:"OS")
		categ.save()
		
	}

	def cleanup() {
	}
	
	
	def "Document controller unit test: create -> redirect to list"()	{
		setup:
		
		controller.params.title = "title different from celui above"
		controller.params.category = "OS"
		controller.params.content = "my content"
		controller.params.tags = "a,b,c,d"
		controller.params.attachments = "from me"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()
		controller.session.user = user_
				
		controller.create()
		
		expect:
		assert response.redirectedUrl == "/document/list"
		//assert controller.response.status == 200
		
	}
	
	def "Document controller unit test: create -> redirect to create_page because of same title"()	{
		setup:
		//save a doc
		
		controller.params.title = "title"
		controller.params.category = "OS"
		controller.params.content = "my content"
		controller.params.tags = "a,b,c,d"
		controller.params.attachments = "from me"
		def user_ = new User(username: "alex", password: "alex", email:"a@a.c")
		user_.save()
		controller.session.user = user_				
		controller.create()
				
		expect:
		assert response.redirectedUrl == "/document/create_page"
		//assert controller.response.status == 200
		
	}
	
	def "Document controller unit test: view -> check rendering"()	{
		setup:
				
		def the_doc = Document.findByTitle("title")		
		def model = controller.view(the_doc.id)
		
		expect:
		//assert view == "/document/view"
		assert model.document == the_doc			
		
	}
	
	def "Document controller unit test: list -> docs exist in db"()	{
		setup:
				
		def model = controller.list()
		def doclist = Document.all
		
		expect:
		assert model.l == doclist
		
	}
	
		
	def "Document controller unit test: list -> there are no docs"()	{
		setup:
		def mydoc = Document.get(1)
		mydoc.delete()
		def model = controller.list()
		
		expect:
		assert model.l == "There are currently no documents in the system"
		//assert controller.response.status == 200
		
	}


	
}
