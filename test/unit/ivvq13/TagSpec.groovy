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
		when:
		Tag tag1 = new Tag(name: "foo");
		Tag tag2 = new Tag(name: "foo");
		
		tag1.save()
		tag2.save()
		
		then:
		assert tag1.validate()
		assert !tag2.validate()
	}
	
	def "testNoBlankName"() {
		when:
		def tag0 = new Tag(name: "okName")
		def tag1 = new Tag(name: "")
		def tag2 = new Tag(name: "\t")
		def tag3 = new Tag(name: "\r")
		
		tag0.save()
		tag1.save()
		tag2.save()
		tag3.save()
	
		then:
		assert tag0.validate()
		assert !tag1.validate()
		assert !tag2.validate()
		assert !tag3.validate()
	}
	
	def "testNoNullName"() {
		when:
		def tag0 = new Tag(name: "okName")
		def tag1 = new Tag(name: null)
		
		tag0.save()
		tag1.save()
	
		then:
		assert tag0.validate()
		assert !tag1.validate()
	}
	
	def "testSizeName"() {
		when:
		def tag0 = new Tag(name: "okName")
		def tag1 = new Tag(name: "")
		def tag2 = new Tag(name: "012345678901234567890123456789")
		
		tag0.save()
		tag1.save()
		tag2.save()
		
		then:
		assert tag0.validate()
		assert !tag1.validate()
		assert !tag2.validate()
	}
}
