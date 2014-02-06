package ivvq13

class DocumentController {

	
	UserService userService
	DocumentService documentService
	RatingService ratingService
	
	def create() {
		//create new document, then on submit, redirect to view
		def title_ = params.title
		def category_ = params.category
		def content_ = params.content
		def tags_ = params.tags
		def attachments_ = params.attachments		
		def user_ = session.user
		
		def res = documentService.serviceCreateDocument(
			title_,
			category_,
			content_,
			tags_,
			attachments_,
			user_)
		
		redirect(uri: res)
				
	}
	 
	def create_page() {
		//redirect to create page		
	}
	
	def view(Long id){
		//redirect to view page
		def doc = documentService.serviceGetById(id)
		[ d:doc, rate: ratingService.getRatingForDocument( doc.id)]
	}
	 
	
    def list() { 
		
		
		//redirect to list page		
		def user = session.user			
		def doclist = documentService.serviceGetAll()
		if ( doclist == null )	
		{
			[ l:"There are currently no documents in the system" , u: user ]
		}
		else 
		{
			[ l:doclist , u: user ]
		}
		
	}
}
