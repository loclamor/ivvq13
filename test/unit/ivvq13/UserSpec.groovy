package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

	def user

	def setup() {
		mockForConstraintsTests(User, [new User(name: "123456789")])
		user = new User(name:"thisIsAUser")
	}
	
	def "testUserCreation"() {
		setup:
		def user = new User(username: "Name1",password :"password1",email :"email1")
		def users = [
				new User(username: "Name2",password :"password2",email :"email2"),
				new User(username: "Name3",password :"password3",email :"email3")]
		
		when:
		user.save()
		users*.save()
		
		then:
		assert User.list().size() == 3
	}
	
	def "testNotTwiceUserName"() {
		when:
		def user1 = new User(username: "UserTiti",password :"password2",email :"email2")
		user1.save(flush: true)
		
		User user2 = new User(username: "UserTiti")
		user2.save(flush: true)
				
		then:
		assert user1.validate()
		assert !user2.validate()
		assert User.list().size() == 1
	}
	

	def "testNoNullUserName"() {
		when:
		def user0 = new User(username: "okName",password :"password0",email :"email0")	
		def user1 = new User(username: null,password :"password0",email :"email0")
		
		user0.save()
		user1.save()
	
		then:
		assert user0.validate()
		assert !user1.validate()
	}
	

	def "testNoBlankUserName"() {
			when:
		def user0 = new User(username: "okName",password :"password0",email :"email0")		
		def user1 = new User(username: "",password :"password0",email :"email0")
		def user2 = new User(username: "\t",password :"password0",email :"email0")
		def user3 = new User(username: "\r",password :"password0",email :"email0")
		
		user0.save()
		user1.save()
		user2.save()
		user3.save()
	
		then:
		assert user0.validate()
		assert !user1.validate()
		assert !user2.validate()
		assert !user3.validate()
	}

	
	def cleanup() {
	}

	void "test something"() {
	}
}
