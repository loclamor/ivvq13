package ivvq13

import grails.transaction.Transactional

@Transactional
class DocumentService {

    def serviceCreateDocument(title_,category_,content_,tags_,attachments_,user_) {
//		def res
//		
//		def c = new Category(name:category_);
//		def a = new Attachment(url:attachments_)
//		a.save()
//		def m = new Message(content:"Welcome", author:user_, title:"Post messages here")
//		m.save()
////		def r = new Rating(value:1000, author:user_)
////		r.save()
//		def t = new Tag(name:"default")
//		if(c.save(flush : true)) {
//			println "We have a new category !";
//		}
//		else {
//			println "Category already exists ";
//		}
//		//divide into tags
//		def list_of_tags = tags_.split(",")
//		def tagList = []
//		list_of_tags.each {
//			def tt = new Tag(name:it)			
//			tagList.add(tt)
//				if(!tt.save()){
//					println("erreur enregistrement tag tt");
//					tt.errors.allErrors.each( {e -> println (e) } )
//				}
//		}	
//		
//										
//		//if the title is already in the database, please retry
//		def doc = Document.findByTitleLike(title_)
//		if( doc ) {
//			println "A doc with this title already exists in the database";
//			res = "/document/create_page"
//			return res
//		}
//		else {
//			//create new document and save in database
//			def document = new Document(
//				title:title_,
//				category:c,
//				user:user_,
//				tags:t,
//				attachments:a,
//				messages:m,
//				//ratings:r,
//				content: content_
//			)
//			//add the tags
//			println "PULA: "+tagList
//			tagList.each  {								
//				
//				document.addToTags(it)
//				
//							
//			}
//			
//			if(document.save()) {				
//				tagList.each  {
////				def ttt = Tag.findByName(it.name)
////					if(ttt) {
////						ttt.addToDocuments(document)
////						ttt.save()
////					}	
//					it.addToDocuments(document)
//					//it.save()			
//				}
//				println "Doc was saved"
//				res = "/document/list"
//				return res
//			}
//			else {
//				println "Doc was not saved"
//				res = "/document/create_page"
//				return res
//			}
//		
//		}
		def res
		
		//if the title is already in the database, please retry
		def doc = Document.findByTitleLike(title_)
		if( doc ) {
			println "A doc with this title already exists in the database";
			res = "/document/create_page"
			return res
		}
	
		//creation d'un document
		def list_of_tags = tags_.split(",")
		list_of_tags.each {
			def tag1 = new Tag( name : it )
			if(!tag1.save(flush:true)){
				println("erreur enregistrement tag");
				tag1.errors.allErrors.each( {e -> println (e) } )
			}
		}
		def theUser = User.findByUsername(user_.username)
		def theCat = Category.findByName(category_)
		def doc1 = new Document(
			title: title_,
			category: theCat,
			user:theUser,
			content: content_			
		)
		
		list_of_tags.each {
			def theTag = Tag.findByName( it )
			doc1.addToTags( theTag )
		}
				
		if(!doc1.save(flush:true)){
			println("erreur enregistrement doc1");
			doc1.errors.allErrors.each( {e -> println (e) } )
		}
		
		list_of_tags.each {
			def theTag = Tag.findByName( it )
			theTag.addToDocuments( doc1 );
			if(!theTag.save(flush:true)){
				println("erreur enregistrement theTag");
				theTag.errors.allErrors.each( {e -> println (e) } )
			}
		}
		
		res = "/document/list"
		return res
		
		

    }
	
	def serviceGetAll() {
		def doclist = Document.all
		doclist.each() { print " ${it}" }; println "";
		return doclist
	}
	
	def serviceGetByTitle(title) {
		def doc = Document.findByTitle(title)
				print doc.title
				return doc
	}
	
	def serviceGetById(docId) {
		def doc = Document.get(docId)
		print doc.title
		return doc
	}
	
	
}
 