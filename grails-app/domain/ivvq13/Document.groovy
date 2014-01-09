package ivvq13

import groovy.lang.Category;

import java.util.ArrayList;

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
    }

}
