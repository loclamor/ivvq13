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
			println("	### Users 'toto'/'tata' and 'a'/'a' created")
			
			//creation de tags
			def tag1 = new Tag( name : "tag1" )
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
			
			//creation de categories
			def cat1 = new Category( name : 'Programming Languages' )
			if(!cat1.save(flush:true)){
				println("erreur enregistrement cat1");
				cat1.errors.allErrors.each( {e -> println (e) } )
			}
			
			def cat2 = new Category( name : 'Frameworks' )
			if(!cat2.save(flush:true)){
				println("erreur enregistrement cat2");
				cat2.errors.allErrors.each( {e -> println (e) } )
			}
			
			def cat3 = new Category( name : 'Software Technologies' )
			if(!cat3.save(flush:true)){
				println("erreur enregistrement cat3");
				cat3.errors.allErrors.each( {e -> println (e) } )
			}
			
			def cat4 = new Category( name : 'Verification tools' )
			if(!cat4.save(flush:true)){
				println("erreur enregistrement cat4");
				cat4.errors.allErrors.each( {e -> println (e) } )
			}
			
			println("	### Categories 'cat1', 'cat2', 'cat3', 'cat4' created")
			
			
			
			//creation d'un document
			def theUser = User.findByUsername("toto")
			def theCat = Category.findByName("Software Technologies")
			def doc1 = new Document(
				title: "un super document trop bien ta vue", 
				category: theCat, 
				user:theUser, 
				content: "Some content of the document, so crazy !"
			)
			def theTag = Tag.findByName( "tag1" )
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
			
			println("### Database initialized.")
		}
		else {
			println("### Database is already initialized !")
		}
    }
    def destroy = {
    }
}
