package br.edu.fateczl.TCC2;

import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



@Component
public class SpringServlet implements WebApplicationInitializer {

	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
		}