class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/user/changepwd"(view:"/user/changepwd")
		"/user/changepwdOk"(view:"/user/changepwdOk")
		
		"/user/forgotpwd"(view:"/user/forgotPassword")

        "/"(view:"/index")
		"/document/create"(view:"/document/create")
		"/document/view"(view:"/document/view")
		"/document/list"(view:"/document/list")
        "500"(view:'/error')
	}
}
