package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Message)
@Mock([Document,Attachment,Category,Message,Rating,Tag,User])
class MessageSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "create message"() {
		setup:
		def content_ = "Hello"
		def title_ = "Response to Hello"
		def author_ = new User(username: "alex", password: "a", email:"alex@a.com")
		author_.save()
		def message = new Message(content: content_, title:title_, author:author_)
		
		when:
		message.save()
		
		then:
		assert message.validate()
    }
	
	void "persist message"() {
		
		setup:
		def content_ = "Hello"
		def title_ = "Response to Hello"
		def author_ = new User(username: "alex", password: "a", email:"alex@a.com")
		author_.save()
		def message = new Message(content: content_, title:title_, author:author_)		
		def size_of_table = Message.list().size()
		
		when:
		message.save()
		
		then:		
		assert size_of_table == Message.list().size()-1
	}
}
