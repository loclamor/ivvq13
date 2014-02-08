package ivvq13

import org.springframework.mail.SimpleMailMessage

class UserController {

	UserService userService
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
	
	
	def logout() {
		session.user = null
		redirect(uri: "/")
	}
	
	
	def changepwd() {
		
	}
	
	def changepwdOk() {	
		//redirect(uri:"/user/changepwd")
		def newpassword = params.inputNewPasswordIn
		session.user.password=newpassword
		session.user.save( flush: true )
	}


	def changename() {

	}
	
	def changenameOk() {
		//get new username
		def newusername = params.inputNewUsernameIn
		
		//get lastest user from DB to avoid versions conflicts
		def user = User.get( session.user.id )
		
		//set username and save
		user.setUsername( newusername )
	
		// here user is safely saved, store it in session
		session.user = User.get( user.id )
	}
	
	
	
	
	
	def forgotpwd(){
		//le nom de fichier doit etre le meme que le nom de view
	}
	
	def sendEmail(){
		
			to "makhlouf.raouf@gmail.com"
			subject "Hello Fred"
			body 'How are you?'
		 
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
		//redirect(uri: "/")
	}
	
    def index() { }
}
