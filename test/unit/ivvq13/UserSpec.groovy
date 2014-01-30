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
    }
	
	def "testNoNullUserName"() {
		when:
		def obj = new User(username: null)
		obj.save()
	
		then:
		assert !obj.validate()
	}
	
	def "testNoBlankUserName"() {
		when:
		def obj = new User(name: "")
		obj.save()
	
		then:
		assert !obj.validate()
	}
	
	
	def "testChangeName"(){
		when:
		controller.changname()
		
		then:
		assert response.redirectedUrl == "/user/changename"
	}
	
	def "testChangeNameOk"(){
		when:
		controller.changnameOk()
		
		then:
		assert response.redirectedUrl == "/user/changenameOk"
	}
	
	
	
	

    def cleanup() {
    }

    void "test something"() {
    }
}
