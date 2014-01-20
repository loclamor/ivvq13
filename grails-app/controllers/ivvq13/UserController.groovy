package ivvq13

import org.springframework.mail.SimpleMailMessage

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
		
			/*	def mailSender = appContext.getBean( "mailSender" )
				def message = new SimpleMailMessage()
			
				// Set properties
				message.from=""
				message.to = 'user@domain.com'
				message.subject = 'subject'
			
				def body = "Dear ${session.user},"
				body = body + "rn You have a new message"
				body = body + " to view this message go here."
				body = body + "rnhttp://domain.com/send/email"
			
				message.body = body
			
				mailSender.send( message )*/
			
			  
		redirect(uri: "/")
	}
	
    def index() { }
}
