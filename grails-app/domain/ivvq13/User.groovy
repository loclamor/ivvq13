package ivvq13

class User {

	String username
	
	static hasMany = [
		interests : Category,
		publications : Document,
		messages : Message
		]
	
    static constraints = {
    }
	
}
