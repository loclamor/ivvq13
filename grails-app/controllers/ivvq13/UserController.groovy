package ivvq13


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
	
	@Override
	def changepwd() {
		
	}
	
	def changepwdOk() {	
		//redirect(uri:"/user/changepwd")
		def newpassword = params.inputNewPasswordIn
		session.user.password=newpassword
		session.user.save( flush: true )
	}

	@Override
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
	
	
	def index() {
		redirect(uri: "/")
	}
	
	@Override
	def forgotpwd(){
		//le nom de fichier doit etre le meme que le nom de view
	}
	
	def sendEmail(){
		def email = params.inputUserEmailUp
		def user = User.findByEmail( email )
		if( !user ) {
			
		redirect(controller: "user", action: "havetosignup")
			return
		}
		sendMail (){			
			to email
			subject "Hello Fred"
			body 'How are you?'
		} 	
	}
	
	@Override
	def havetosignup(){
	}

	}
    

