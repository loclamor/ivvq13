package ivvq13

class MessageController {

    def add( Long id ) {
		def title = params.inputTitle
		def content = params.inputContent
		
		def message = new Message( title:title, content:content, author:session.user)
		if(!message.save(flush:true)){
			println("erreur enregistrement message");
			message.errors.allErrors.each( {e -> println (e) } )
		}
		else {
			def doc = Document.get( id )
			doc.addToMessages( message )
			if(!doc.save(flush:true)){
				println("erreur enregistrement document");
				doc.errors.allErrors.each( {e -> println (e) } )
			}
		}
		
		redirect( controller: "document", action:"view", id:id )
	}
}
