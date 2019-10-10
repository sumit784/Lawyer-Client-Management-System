package com.lawyer.project;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Server is up and running!");
	}

	// @Bean
    // public TomcatServletWebServerFactory tomcatEmbedded() {

    //     TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

    //     tomcat.setTomcatConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
    //         if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
    //             //-1 means unlimited
    //             ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
    //         }
    //     });

    //     return tomcat;

    // }

}
