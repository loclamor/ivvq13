package ivvq13

class DocumentController {

	def create() {
		//create new document, then on submit, redirect to view
		def title_ = params.title
		def category_ = params.category
		def content_ = params.content
		def tags_ = params.tags
		def attachments_ = params.attachments		
		def user_ = new User(username:"alex",password:"a", email:"a@a.c");
		user_.save()
		def c = new Category(name:category_);
		def a = new Attachment(url:attachments_)
		def m = new Message(content:"Welcome", author:user_, title:"Post messages here")
		def r = new Rating(value:-1, author:user_)
		def t = new Tag(name:"mytag")
		//if category does not exist, save it, this is just for testing purposes
		if(c.save(flush : true)) { 
			println "We have a new category !";			
		}
		else {
			println "Category already exists ";
		}
		//divide into tags
//		def list_of_tags = tags_.split(",")
//		println "List of tags: "+list_of_tags;
			
		//if the title is already in the database, please retry		
		def doc = Document.findByTitleLike(title_)		
		if( doc ) {
			println "A doc with this title already exists in the database";
			redirect(uri: "/document/create_page") 
			return
		}	
				
		//create new document and save in database 
		def document = new Document(
			title:title_, 
			category:c, 
			user:user_, 
			tags:t, 
			attachments:a, 
			messages:m, 
			ratings:r,
			content: content_
			)
		
		if(document.save(flush : true)) {
			println "Doc was saved"
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
	
	def create_page() {
		//redirect to create page
	}
	
	def view(){
		redirect(uri: "/document/create_page")
	}
	
	
    def list() { 
		
		def user = session.user;
//		print u
//		[user: u]
		
				
		// list results, on click on document from list redirect to document view
		def doclist = Document.all
		doclist.each() { print " ${it}" }; println "";
		[ l:doclist , u: user ]
		//redirect(uri: "/document/list")	
	}
}
