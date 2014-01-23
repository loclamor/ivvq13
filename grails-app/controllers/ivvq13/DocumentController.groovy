package ivvq13

class DocumentController {

	def create_page() {
		//create new document, then on submit, redirect to view
		def title_ = params.title
		def category_ = params.category
		def content_ = params.content
		def tags_ = params.tags
		def attachments_ = params.attachments		
		def user_ = session.user
		
		//if the title is already in the database, please retry		
		def doc = Document.findByTitleLike(title_)		
		if( doc ) {
			println "A doc with this title already exists in the database";
			//redirect(uri: "/document/create")
			return
		}
		
		//create new document and save in database 
		def document = new Document(title: title_, category:category_, 
			user:user_, tags:tags_, attachments:attachments_, messages:null, ratings:0,
			content: content_)
		if(!document.save(flush : true)) {
			println "Doc was not saved";
			document.errors.allErrors.each( {e -> println (e) } )
			//redirect(uri: "/document/create")
			return
		}
		
		println "Doc was saved"
		//redirect(controller: "document", action: "list")
		//redirect(uri: "/document/list")
	}
	
	def redirect_create_page(){
		redirect(uri: "/document/create_page")
	}
	
	def view(){
		
	}
	
	
    def list() { 
		
		String user = session.user.toString()
		[user: user]
				
		// list results, on click on document from list redirect to document view
		def doclist = Document.all
		doclist.each() { print " ${it}" }; println "";
		
		//redirect(uri: "/document/list")	
	}
}
