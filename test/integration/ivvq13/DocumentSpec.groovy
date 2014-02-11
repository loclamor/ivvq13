package ivvq13

import grails.plugin.spock.IntegrationSpec


class DocumentSpec extends IntegrationSpec {

	static transactional = false
	
	def setup() {

	}
	
	
//	void cleanup() {
//		perMethodRequestEnvironmentInterceptor?.destroy()
//		destroyTransaction(perMethodTransactionInterceptor)
//	  }
	  
	void cleanup() {}	  
	

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
		def message2 = new Message(content: contentMes, title:"Hello", author:user)
	
		def message3 = new Message(content: contentMes, title:"Hello2", author:user)
	
		when:
		message2.save()
		message3.save()
		
		d.addToMessages(message2)
		d.addToMessages(message3)		
		d.save()
		def s = d.messages.size()
		
		then:
		assert d.messages.size() == s
	}
	
//	void destroyTransaction(GrailsTestTransactionInterceptor interceptor){
//		if (interceptor?.isTransactional(this)) interceptor.destroy()
//		
//	  }
}
