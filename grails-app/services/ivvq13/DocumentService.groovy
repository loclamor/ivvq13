package ivvq13

import grails.transaction.Transactional

@Transactional
class DocumentService {

    def serviceCreateDocument() {
		

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
	
	
}
 