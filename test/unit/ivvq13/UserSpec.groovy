package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }
	
	def "changenameTest"(){
		when:
		controller.changeusername()
		
		then:
		assert response.redirectedUrl == "/user/changename"
	}

    def cleanup() {
    }

    void "test something"() {
    }
}
