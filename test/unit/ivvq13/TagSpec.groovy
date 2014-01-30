package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tag)
class TagSpec extends Specification {
	
	def tag

    def setup() {
		//mock a person with some data (put unique violations in here so they can be tested, the others aren't needed)
		mockForConstraintsTests(Tag, [new Tag(name: "123456789")])
		tag = new Tag(name:"thisIsATag")
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
	
	def "testNotTwiceSameTag"() {
		setup:
		Tag t1 = new Tag(name: "foo");
		Tag t2 = new Tag(name: "foo");
		
		when:
		t1.save()
		t2.save()
		
		then:
		assert !t1.validate()
		assert !t2.validate()
	}
	
	def "testNoBlankName"() {
		when:
		def obj = new Tag(name: "")
		obj.save()
	
		then:
		assert !obj.validate()
	}
	
	def "testNoNullName"() {
		when:
		def obj = new Tag(name: null)
		obj.save()
	
		then:
		assert !obj.validate()
	}
	
	def "testSizeName"() {
		when:
		def obj = new Tag(name: "1")
		def obj2 = new Tag(name: "012345678901234567890")
		obj.save()
		obj2.save()
	
		then:
		assert !obj.validate()
		assert !obj.validate()
	}
}
