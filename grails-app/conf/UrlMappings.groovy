class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
		"/document/create"(view:"/document/create")
		"/document/view"(view:"/document/view")
		"/document/list"(view:"/document/list")
        "500"(view:'/error')
	}
}
