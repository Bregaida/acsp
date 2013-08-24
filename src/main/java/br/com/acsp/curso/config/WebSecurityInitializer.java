package br.com.acsp.curso.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * User: Christian Reichel
 * Date: 8/9/13
 * Time: 10:14 PM
 */
@Order(2)
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
