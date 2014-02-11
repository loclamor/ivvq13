package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([Document,DocumentService,Attachment,Category,Message,Rating, RatingService, MessageService,Tag,User])

class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "User Controller test : signIn"() {
		setup:
		params.inputUsernameIn = "alex"
		params.inputPasswordIn = "a"
		
		when:
		controller.signin()
		
		then:
		assert response.redirectedUrl == "/"
	   
    }
	
	void "User Controller test : signUp"() {
		setup:
		params.inputUsernameUp = "a"
		params.inputPasswordUp = "b"
		params.inputEmailUp = "a@a.c"
		
		when:
		controller.signup()
		
		then:
		assert response.redirectedUrl == "/document/list"
	   
	}
	
	void "User Controller test : change password"() {
		setup:
		params.inputNewPasswordIn = "abc"
		def user = new User(username: "alex", password: "a", email:"alex@a.com")
		user.save()
		session.user = user
		
		when:
		controller.changepwdOk()
		
		then:
		assert session.user.password == params.inputNewPasswordIn
	   
	}
	
	void "User Controller test : change name"() {
		setup:
		params.inputNewUsernameIn = "abc"
		def user = new User(username: "alex", password: "a", email:"alex@a.com")
		user.save()
		session.user = user
		
		when:
		controller.changenameOk()
		
		then:
		assert session.user.username == params.inputNewUsernameIn
	   
	}
	
	void "User Controller test : send mail ok"() {
		setup:
		params.inputUserEmailUp = "differentmail@a.c"
		def user = new User(username: "alex", password: "a", email:"alex@a.com")
		user.save()
		session.user = user
		
		when:
		def a = controller.sendEmail()
		
		then:
		assert response.redirectedUrl == "/user/havetosignup"
	   
	}
	
	//
	/*def "testChangeName"(){
		when:
		controller.changename()
		
		then:
		assert response.redirectedUrl == "/user/changename"
	}
	
	def "testChangeNameOk"(){
		when:
		controller.changenameOk()
		
		then:
		assert response.redirectedUrl == "/user/changenameOk"
	}*/
	
	
	
}
