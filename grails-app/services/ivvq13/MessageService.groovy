package ivvq13

import grails.transaction.Transactional

@Transactional
class MessageService {

    	
	def getMesagesFromDocument ( Long docId ) {
		
		def doc = Document.get(docId)
		if( doc == null )
			return []
		
		return doc.messages
	}
}
