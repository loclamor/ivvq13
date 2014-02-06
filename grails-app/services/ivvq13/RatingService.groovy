package ivvq13

import grails.transaction.Transactional

@Transactional
class RatingService {

    def getRatingForDocument(Long docId) {
		
		def doc = Document.get(docId)
		
		if( doc == null )
			return 0
			
		def rate = 0;
		def nbRate = 0;
		doc.ratings.each {
			rate += it.value
			nbRate++
		}
		return rate / nbRate
    }
}
