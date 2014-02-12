package ivvq13

import grails.transaction.Transactional

@Transactional
class DocumentService {

    def serviceCreateDocument(title_,category_,content_,tags_,attachments_,user_) {
		def res
		
		//if the title is already in the database, please retry
		def doc = Document.findByTitle(title_)
		if( doc ) {
			println "A doc with this title already exists in the database";
			res = false
			return res
		}
	
		//creation d'un document
		def st = tags_.trim()
		def list_of_tags = st.split(",")
		list_of_tags.each {
			def tag1 = new Tag( name : it )
			if(!tag1.save(flush:true)){
				println("erreur enregistrement tag");
				tag1.errors.allErrors.each( {e -> println (e) } )
			}
		}
//		def ra = new Rating(value: 0, author: user_)
//		ra.save()
		def theUser = User.findByUsername(user_.username)
		def theCat = Category.findByName(category_)
		def doc1 = new Document(
			title: title_,
			category: theCat,
			user:theUser,
			content: content_,	
			attachments: attachments_
		//	rating: ra	
		)
		
		list_of_tags.each {
			def theTag = Tag.findByName( it )
			doc1.addToTags( theTag )
		}
				
		if(!doc1.save(flush:true)){
			println("erreur enregistrement doc1");
			doc1.errors.allErrors.each( {e -> println (e) } )
			res = false
			return res
		}
		
		list_of_tags.each {
			def theTag = Tag.findByName( it )
			theTag.addToDocuments( doc1 );
			if(!theTag.save(flush:true)){
				println("erreur enregistrement theTag");
				theTag.errors.allErrors.each( {e -> println (e) } )
			}
		}
		
		res = true
		return res
		
		

    }
	
	def serviceGetAll() {
		def doclist = Document.all
		doclist.each() { print " ${it}" }; println "";
		return doclist
	}
	
//	def serviceGetByTitle(title) {
//		def doc = Document.findByTitle(title)
//				print doc.title
//				return doc
//	}
	
	def serviceGetById(docId) {
		def doc = Document.get(docId)
		return doc
	}
	
	
}
 