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
		def c = new Category(name:category_);
		def a = new Attachment(url:attachments_)
		def m = new Message(content:"Welcome", author:user_, title:"Post messages here")
//		def r = new Rating(value:-1, author:user_)
		def t = new Tag(name:"default")
		//if category does not exist, save it, this is just for testing purposes
		if(c.save(flush : true)) { 
			println "We have a new category !";			
		}
		else {
			println "Category already exists ";
		}
		//divide into tags
		def list_of_tags = tags_.split(",")
		
		list_of_tags.each {
			println "dans la boucle de list of tags each: "+it
			def tt = new Tag(name:it)
			//if tag is not in db, save
			def tt2 = Tag.findByName(it)
			if (!tt2) {
				if(!tt.save(flush:true)){
					println("erreur enregistrement tag tt");
					tt.errors.allErrors.each( {e -> println (e) } )
				}
			}				
			else {
				print "tag already existed: " + tt.name
			}		
		}
									
		//if the title is already in the database, please retry		
		def doc = Document.findByTitleLike(title_)		
		if( doc ) {
			println "A doc with this title already exists in the database";
			redirect(uri: "/document/create_page") 
			return
		}
		else {			
			//create new document and save in database
			def document = new Document(
				title:title_,
				category:c,
				user:user_,
				tags:t,
				attachments:a,
				messages:m,
	//			ratings:r,
				content: content_
			)
			list_of_tags.each  {
				println "second list of tags each boucle"
				def theTag = Tag.findByName(it)
				if (theTag) {
					
					theTag.addToDocuments(document );
					if(!theTag.save(flush:true)){
						println("erreur enregistrement theTag");
						theTag.errors.allErrors.each( {e -> println (e) } )
					}
					theTag = Tag.findByName(it)
					document.addToTags(theTag)
					
				}//else do nothing
				
			}					
			if(document.save(flush : true)) {
				println "Doc was saved"
				println "Title and tags : "+document.title
				document.tags.each {
				println "Tag "+it.name
				}
				redirect(uri: "/document/list")
				return
			}
			else {
				println "Doc was not saved";
				document.errors.allErrors.each( {e -> println (e) } )
				redirect(uri: "/document/create_page")
				return
			}
		
		}	
			
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
