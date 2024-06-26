package com.kh.mybatis.common.Fiter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFiter
 */
@WebFilter("/EncodingFiter")
/**
 * @WebFilter("/*") 이 필터로들어오는 모든곳에 적용된다 // 전체
 * @WebFilter("/admin") admin으로 들어오는걸 해줘 // 특정
 * @WebFilter(urlPatterns= {"/list.bo","search.bo"}) // 따로따로 list.bo search.bo에 필터를 걸겠다
 */
public class EncodingFiter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFiter() { //생성자
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { // 필터가 종료할때 해줄 작업(신경안써도됨)
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//기본적으로 많이 쓰는곳
		//요청을 가로채거나
		
		//특정조건에 따라서 다른 필터나 서블릿으로 요청을 전달
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response); // 너가 가던길 가라 의 뜻
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//필터 초기화작업할떄
	}

}
