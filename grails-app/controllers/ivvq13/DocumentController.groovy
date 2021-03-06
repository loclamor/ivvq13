package ivvq13

class DocumentController {


	DocumentService documentService
	RatingService ratingService
	MessageService messageService

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
		
		if (res == true) {
			redirect(uri: "/document/list")
		}
		else {
			redirect(uri: "/document/create_page")
		}
		
				
	}
	
	@Override
	def create_page() {
		//redirect to create page		
	}
	
	def view(Long id){
		//redirect to view page
		def doc = documentService.serviceGetById(id)
		[ 
			document: doc,
			tags: doc.tags,
			rate: ratingService.getRatingForDocument( doc.id),
			messages: messageService.getMesagesFromDocument(doc.id)
		]
	}
	 
	
    def list() { 
		
		
		//redirect to list page		
		def user = session.user			
		def doclist = documentService.serviceGetAll()
		if ( doclist.size() == 0 )	
		{
			[ l:"There are currently no documents in the system" , u: user ]
		}
		else 
		{
			def rates = []
			doclist.each {
				rates.add( ratingService.getRatingForDocument( it.id ) )
			}
			[ l:doclist , u: user, rates:rates ]
		}
		
	}
}
