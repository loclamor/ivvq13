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
		
		if( nbRate == 0)
			return 0
		
		rate = rate / nbRate
		
		return Math.round( rate.floatValue() )
    }
	
	def rateOnDocument( Document doc, Rating rate) {
		def user = rate.author
		
		doc.ratings.each {
			if( it.author.id == user.id )
				return false
		}
		
		//here the user have not rate the doc
		rate.save(flush:true)
		doc.addToRatings( rate )
		doc.save(flush:true)
		return true
	}
	
}
