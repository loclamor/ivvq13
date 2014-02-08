package ivvq13

import grails.transaction.Transactional

@Transactional
class UserService {  

    def serviceGetSessionUser() {
		return session.user
    }
	
	
	
}
