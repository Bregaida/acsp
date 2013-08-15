package br.com.acsp.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * User: Christian Reichel
 * Date: 8/9/13
 * Time: 10:08 PM
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { WebSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class, WebSecurityInitializer.class, PersistenceConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    //@Override
    //protected Filter[] getServletFilters(){
    //    return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
    //}



    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("dispatchOptionsRequest", "true");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.active", "persist-emb");
//		servletContext.setInitParameter("spring.profiles.active", "persist-pg");
        super.onStartup(servletContext);
    }
}
