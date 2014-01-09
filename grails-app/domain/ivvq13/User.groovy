package ivvq13

class User {

	/*
		+ id: long
		+ username: String 
		+ interests: Category[] 
		+ publications: Document[] 
		+ messages : Message[] 
	 */
	String username
	static hasMany = [
		interests : Category,
		publications : Document,
		messages : Message]
	
    static constraints = {
    }
	
}
