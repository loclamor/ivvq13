package com.sysgears.example;

import geb.spock.GebReportingSpec;
import spock.lang.Stepwise;
import com.sysgears.example.pages.*

@Stepwise
class SignInSpec extends GebSpec{
    def "should login with valid username and password"(){
        when:
        go "index.gsp"

        then:
        $(".page-header").text() == "Bienvenu en IVVQ13"

        when:
        $("#formSignIn input[name=inputUsernameIn]").value("totot")
        $("#formSignIn input[name=inputPasswordIn]").value("tata")
        $("#formSignIn input[type=submit]").click()

        then:
        $(".page-header").text() == "Document List"
    }

	
//test-app --functional
	
	// see http://jaxenter.com/tutorial-groovy-functional-testing-with-geb-42070.html?print=yes
	