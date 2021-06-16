package com.codecool.spingboot_tasks.request_counter.filter;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class RequestCounterFilter implements Filter {

    private final RequestCountStatsService service;

    @Autowired
    public RequestCounterFilter(RequestCountStatsService service) {
        this.service = service;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Rozpoczecie requestu");

        if(!req.getServletPath().contains("/api/statistics")){
            service.increaseCounter(req.getMethod());
        }

        chain.doFilter(request, response);
        System.out.println("Zakończenie requestu");
    }
    
}