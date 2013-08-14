/**
 *
 */
package br.com.acsp.curso.util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author eduardobregaida
 * 
 */
public class HibernateSessionFilter implements Filter {
	public void doFilter2(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws ServletException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.getTransaction().rollback();
			throw new ServletException(e);
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws ServletException {
		try {
			HibernateUtil.getSessionFactory().openSession().beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			HibernateUtil.getSessionFactory().openSession().getTransaction()
					.commit();
		} catch (Exception e) {
			HibernateUtil.getSessionFactory().openSession().getTransaction()
					.rollback();
			throw new ServletException(e);
		} finally {
			HibernateUtil.getSessionFactory();
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}