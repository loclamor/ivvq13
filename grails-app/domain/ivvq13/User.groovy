package ivvq13

class User {

	String username
	String password
	
	static hasMany = [
		interests : Category,
		publications : Document,
		messages : Message
		]
	
    static constraints = {
    }
	
}
