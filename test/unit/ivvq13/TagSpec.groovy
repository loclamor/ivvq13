package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tag)
class TagSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
	def "testCreation"() {
		setup:
		def tag = new Tag(name: "test")
		def tags = [
				new Tag(name: "foo"),
				new Tag(name: "bar")]
		
		when:
		tag.save()
		tags*.save()
		
		then:
		Tag.list().size() == 3
	}
	
	def "testNoDouble"() {
		setup:
		Tag t1 = new Tag(name: "foo");
		Tag t2 = new Tag(name: "foo");
		
		when:
		t1.save()
		t2.save()
		
		then:
		Tag.list().size() == 1
	}
	
	def "testNoBlankName"() {
		Tag t1= new Tag(name: "");
		
	}
}
