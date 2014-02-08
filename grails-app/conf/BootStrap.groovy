import ivvq13.User
import ivvq13.Tag
import ivvq13.Category
import ivvq13.Document

class BootStrap {
	
	
    def init = { servletContext ->
		
		//replissage de la base seulement si elle est vide ;
		// on considère que si il n'y a aucun user, la base est vide
		if(User.count() == 0) {
			println("### initializing...")
			//creation d'utilisateurs de test
			def user1 = new User(username : "toto", password : "tata", email : "toto@yopmail.com" )
			if(!user1.save(flush:true)){
				println("erreur enregistrement user1");
				user1.errors.allErrors.each( {e -> println (e) } )
			}
			
			def user2 = new User(username : "a", password : "a", email : "aaaa@yopmail.com" )
			if(!user2.save(flush:true)){
				println("erreur enregistrement user2");
				user2.errors.allErrors.each( {e -> println (e) } )
			}
			
			def user3 = new User(username : "Paolo", password : "Polo", email : "Paolo@yopmail.com" )
			if(!user3.save(flush:true)){
				println("erreur enregistrement user3");
				user3.errors.allErrors.each( {e -> println (e) } )
			}
			
			def user4 = new User(username : "Silvana", password : "Rolland", email : "Rolland@yopmail.com" )
			if(!user4.save(flush:true)){
				println("erreur enregistrement user4");
				user4.errors.allErrors.each( {e -> println (e) } )
			}
			 
			
			println("	### Users 'toto'/'tata' # 'Paolo'/'Polo' # 'Rolland'/'Silvana' and 'a'/'a' created")
			
			//creation de tags
			def tag1 = new Tag( name : "Groovy-Grails" )
			if(!tag1.save(flush:true)){
				println("erreur enregistrement tag1");
				tag1.errors.allErrors.each( {e -> println (e) } )
			}
			def tag2 = new Tag( name : "tag2" )
			if(!tag2.save(flush:true)){
				println("erreur enregistrement tag2");
				tag2.errors.allErrors.each( {e -> println (e) } )
			}
			println("	### Tags 'tag1' and 'tag2' created")
			
			def tag3 = new Tag( name : "Unix" )
			if(!tag3.save(flush:true)){
				println("erreur enregistrement tag3");
				tag3.errors.allErrors.each( {e -> println (e) } )
			}
			def tag4 = new Tag( name : "Linux" )
			if(!tag4.save(flush:true)){
				println("erreur enregistrement tag4");
				tag4.errors.allErrors.each( {e -> println (e) } )
			}
			println("	### Tags 'tag1' 'tag2' 'tag3' and 'tag4' created")
			
			//creation de categories
			def cat1 = new Category( name : 'J2EE' )
			if(!cat1.save(flush:true)){
				println("erreur enregistrement cat1");
				cat1.errors.allErrors.each( {e -> println (e) } )
			}
			
			def cat2 = new Category( name : 'cat2' )
			if(!cat2.save(flush:true)){
				println("erreur enregistrement cat2");
				cat2.errors.allErrors.each( {e -> println (e) } )
			}
			
			def cat3 = new Category( name : 'OS' )
			if(!cat3.save(flush:true)){
				println("erreur enregistrement cat3");
				cat3.errors.allErrors.each( {e -> println (e) } )
			}
			println("	### Categories 'cat1' cat2' and 'OS' created")
			
			//creation d'un document1
			def theUser = User.findByUsername("Silvana")
			def theCat = Category.findByName("J2EE")
			def doc1 = new Document(
				title: "Spring Developer Suite", 
				category: theCat, 
				user:theUser, 
				content: "IntelliJ IDEA brings outstanding code assistance and productivity-boosting features for development Spring applications with Web Services, Data JPA, Security, Web Flow, MVC, AOP, Roo, Integration and Dynamic Modules.",
			)
			def theTag = Tag.findByName( "Groovy-Grails" )
			doc1.addToTags( theTag )
			if(!doc1.save(flush:true)){
				println("erreur enregistrement doc1");
				doc1.errors.allErrors.each( {e -> println (e) } )
			}
			theTag.addToDocuments( doc1 );
			if(!theTag.save(flush:true)){
				println("erreur enregistrement theTag");
				theTag.errors.allErrors.each( {e -> println (e) } )
			}
			println("	### Document 'doc1' created")
			
			
			
			//creation d'un document 2
			def theUser2 = User.findByUsername("Paolo")
			def theCat3 = Category.findByName("OS")
			def doc2 = new Document(
				title: "Linux and Unix sudo command",
				category: theCat3,
				user: theUser2,
				content: "The command sudo (\"superuser do\") allows a user with proper permissions to execute a command as another user, such as the superuser.",
			)
			def theTag2 = Tag.findByName( "Unix" )
			doc2.addToTags( theTag2 )
			theTag2.addToDocuments( doc2 );
			if(!theTag2.save(flush:true)){
				println("erreur enregistrement theTag2");
				theTag2.errors.allErrors.each( {e -> println (e) } )
			}
			def theTag3 = Tag.findByName( "Linux" )
			doc2.addToTags( theTag3 )
			theTag3.addToDocuments( doc2 );
			if(!theTag3.save(flush:true)){
				println("erreur enregistrement theTag3");
				theTag3.errors.allErrors.each( {e -> println (e) } )
			}
			
			if(!doc2.save(flush:true)){
				println("erreur enregistrement doc2");
				doc2.errors.allErrors.each( {e -> println (e) } )
			}
			println("	### Document 'doc2' created")
			
			
			
			
			
			
			println("### Database initialized.")
		}
		else {
			println("### Database is already initialized !")
		}
		
		
		
		
    }
    def destroy = {
    }
}

