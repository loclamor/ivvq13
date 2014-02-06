package ivvq13

class RatingController {

	RatingService ratingService
	
    def rate( Long id ) {
		
		def rateValue = params.userRate
		
		def doc = Document.get( id )
		
		if( doc == null ) {
			redirect( controller:"document", action:"view", id:id)
			return
		}
		
		def rate = new Rating( value:rateValue, author: session.user )
		
		ratingService.rateOnDocument(doc, rate)
		
		redirect( controller:"document", action:"view", id:id)
		return
		
	}
}
