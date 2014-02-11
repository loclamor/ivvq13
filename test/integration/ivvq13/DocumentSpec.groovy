package ivvq13


import org.codehaus.groovy.grails.test.support.GrailsTestTransactionInterceptor


class DocumentSpec extends IVVQIntegrationSpec {

	static transactional = false
	def ratingService = new RatingService()
	def messageService = new MessageService()
	def userService = new UserService()
	def documentService = new DocumentService()
	
	def setup() {
		def categ = new Category(name:"OS")
		categ.save()	
		
	}
	
	
//	def cleanup() {
//		perMethodRequestEnvironmentInterceptor?.destroy()
//		destroyTransaction(perMethodTransactionInterceptor)
//	  }
	  
	def cleanup() {}	  
	

	void "Integrate document with message test"() {
		//create a doc, add a message, assert
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
		def rating = new Rating(author: user, value: 1)
		rating.save()		
		def doc = new Document()
		doc.setTitle("my title")
		doc.setUser(user)
		doc.setCategory(category)
		doc.addToTags(tag1)
		doc.addToTags(tag2)
		doc.setContent(contentDoc)
		doc.addToRatings(rating)
		doc.addToAttachments(attachment)
		doc.save()
		
		def contentMes2 = "Hello form john "
		def contentMes3 = "Hello from alex "		
		
		def d = Document.get(1)
		def message = new Message(content: contentMes, title:"Hello", author:user)
		def message2 = new Message(content: contentMes2, title:"Hello", author:user)
		def message3 = new Message(content: contentMes3, title:"Hello2", author:user)
	
		when:
		message.save()
		message2.save()
		message3.save()		
		d.addToMessages(message)
		d.addToMessages(message2) 
		d.addToMessages(message3)		
		d.save()
		def s = d.messages.size()
		//def m = messageService.getMesagesFromDocument(d.id)
		//now !
		then:
		assert d.messages.size() == s
		assert d.messages.contains(message) == true
		assert d.messages.contains(message2) == true
		assert d.messages.contains(message3) == true
	}
	
	void "Integrate document with tags test"() {
		//create a doc, add a message, assert
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
		doc.save()
		
		
		def d = Document.get(1)
		def rating2 = new Rating(author: user, value: 5)
				
		when:		
		rating2.save()
		d.addToRatings(rating2)
		
		then:
		assert d.ratings.contains(rating2)
		
		
	}
	
	void "Integrate document with ratings test"() {
		//create a doc, add a message, assert
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
		doc.save()
		
		
		def d = Document.get(1)
		def tag3 = new Tag(name:"tag 3")
		def tag4 = new Tag(name:"tag 4")
		
		when:
		
		tag3.save()
		tag4.save()
		d.addToTags(tag1)
		d.addToTags(tag2)
		d.save()
		tag3.addToDocuments(d)
		tag4.addToDocuments(d)
		tag3.save()
		tag4.save()
		def s = d.tags.size()
		
		then:
		assert d.tags.size() == s
		assert d.tags.empty == false
		assert Tag.all.size() != 0
		assert tag3.documents.contains(d) == true
		assert tag4.documents.contains(d) == true
		assert d.tags.contains(tag3)
		assert d.tags.contains(tag4)
		
	}
	

	void "Integrate document with message and rating test"() {
		//create a doc, add a message, assert
			
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
		def rating = new Rating(author: user, value: 1)
		rating.save()
		def doc = new Document()
		doc.setTitle("title")
		doc.setUser(user)
		doc.setCategory(category)
		doc.addToTags(tag1)
		doc.addToTags(tag2)
		doc.setContent(contentDoc)
		doc.addToRatings(rating)
		doc.addToAttachments(attachment)
		doc.save()
		
		def contentMes2 = "Hello form john "
		def contentMes3 = "Hello from alex "
		
		def d = Document.findByTitle("title")//documentService.serviceGetById(doc.id)
		def message2 = new Message(content: contentMes2, title:"Hello", author:user)
		def message3 = new Message(content: contentMes3, title:"Hello2", author:user)
	
		def rating2 = new Rating(author: user, value: 5)
		
		when:
		
		message2.save()
		message3.save()
		rating2.save()
		d.addToRatings(rating2)
		d.addToMessages(message2)
		d.addToMessages(message3)
		d.save()
		def s = d.messages.size()
		//def m = messageService.getMesagesFromDocument(d.id)
		//now !
				
		then:
		assert d.messages.size() == s
		assert d.messages.contains(message2) == true
		assert d.messages.contains(message3) == true
		assert d.ratings.contains(rating2) == true
	}
	
//	void "Integrate document using services" () {
//		setup:
//		
//		def a = ratingService.getRatingForDocument(1)
//		expect:
//		assert a == 3
//	}

	
	
	//to do : USE SERVICES
	
//	void destroyTransaction(GrailsTestTransactionInterceptor interceptor){
//		if (interceptor?.isTransactional(this)) interceptor.destroy()
//		
//	  }
}
