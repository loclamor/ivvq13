package ivvq13

class Tag {

	String name;
	
	static hasMany = [documents: Document]
	static belongsTo = Document
	
    static constraints = {
		name size: 1..20, blank: false, unique: true, nullable: false
    }
	
}
