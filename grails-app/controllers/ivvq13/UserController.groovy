package ivvq13

class UserController {

	def signin() {
		def username = params.inputUsernameIn
		def password = params.inputPasswordIn
		
		def user = User.findByUsernameAndPassword( username, password )
		if( !user ) {
			redirect(uri: "/")
			return
		}
		
		session.user = user
		redirect(controller: "document", action: "list")
	}
	
	def signup(){
		def username = params.inputUsernameUp
		def password = params.inputPasswordUp
		def email = params.inputEmailUp
		
		def user = new User(username: username, password: password, email: email)
		if(!user.save(flush : true)) {
			user.errors.allErrors.each( {e -> println (e) } )
			redirect(uri: "/")
			return
		}
		session.user = user
		redirect(controller: "document", action: "list")
	}
	
	def forgotpwd(){
		redirect(uri: "/forgotpwd")
	}
	
	def sendEmail(){
		redirect(uri: "/")
	}
	
    def index() { }
}
