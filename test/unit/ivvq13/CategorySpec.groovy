package ivvq13

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategorySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "create category"() {
		setup:
		def category = new Category(name:"Java")
		
		when:
		category.save()
		
		then:
		assert category.validate()
    }
	
	void "persist category"() {
		setup:
		def category = new Category(name:"Java")
		def size_of_table = Category.list().size()
		
		when:
		category.save()
		
		then:		
		assert size_of_table == Category.list().size()-1
	}
}
