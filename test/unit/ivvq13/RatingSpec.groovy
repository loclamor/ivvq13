package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rating)
class RatingSpec extends Specification {

	@Override
    def setup() {
    }

	@Override
    def cleanup() {
    }

    def "create rating"() {
		setup:
		def rating = new Rating(value: 3, author: null)
		
		when:
		rating.save(flush: true)
		
		then:
		assert rating.validate()
	}
	
	def "testRatingRange"() {
		when:
		def rating0 = new Rating(value: -1)
		def rating1 = new Rating(value: 1)
		def rating2 = new Rating(value: 5)
		def rating3 = new Rating(value: 6)
		
		rating0.save()
		rating1.save(flush: true)
		rating2.save()
		rating3.save(flush: true)
		
		then:
		assert !rating0.validate()
		assert rating1.validate()
		assert rating2.validate()
		assert !rating3.validate()

	}
}
