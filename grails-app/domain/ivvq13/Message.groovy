package ivvq13

class Message {

	
	String content
	String title
	User author
	
    static constraints = {
    }
	
	static mapping = {
		content type: 'text'
	 }
	
}
 