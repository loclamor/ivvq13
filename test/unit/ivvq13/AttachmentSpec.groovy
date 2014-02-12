package ivvq13

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Attachment)
@Mock([Attachment, User])
class AttachmentSpec extends Specification {

	@Override
	def setup() {
    }

	@Override
    def cleanup() {
    }

    void "create attachment"() {
		setup:
		def attachment = new Attachment(url:"www.google.com")
		
		when:
		attachment.save()
		
		then: 
		assert attachment.validate()
    }
	
	void "persist attachment"() {
		setup:
		def attachment = new Attachment(url:"www.google.com")
		def size_of_table = Attachment.list().size()
		
		when:
		attachment.save()
		
		then:		
		assert size_of_table == Attachment.list().size()-1
	}
	
}
