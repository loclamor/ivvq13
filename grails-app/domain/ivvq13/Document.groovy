package ivvq13

class Document {

	String title
	String content
	Category category
	User user
	
	static hasMany = [
		messages : Message,
		tags : Tag,
		ratings : Rating,
		attachments : Attachment
		]
  
	static constraints = {
	  content type:'text'
	}

	 
}
