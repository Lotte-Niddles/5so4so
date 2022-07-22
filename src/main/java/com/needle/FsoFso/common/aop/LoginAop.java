package com.needle.FsoFso.common.aop;

import com.needle.FsoFso.common.util.AttributeContainer;
import com.needle.FsoFso.member.controller.AdminMembers;
import com.needle.FsoFso.member.service.Member;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAop {

    private final AdminMembers adminMembers;

    public LoginAop(AdminMembers adminMembers) {
        this.adminMembers = adminMembers;
    }

    @Around("@annotation(com.needle.FsoFso.common.aop.MemberOnly)")
    public Object checkLoginMember(ProceedingJoinPoint joinPoint)
            throws Throwable {
        Optional<Object> request = getHttpServletRequest(joinPoint);
        if (request.isEmpty()) {
            return "redirect:/login.do";
        }
        final HttpServletRequest servletRequest = (HttpServletRequest) request.get();

        if (!AttributeContainer.hasSessionAttributeOf(servletRequest, "member")) {
            return "redirect:/login.do";
        }
        return joinPoint.proceed();
    }

    @Around("@annotation(com.needle.FsoFso.common.aop.AdminOnly)")
    public Object checkAdminMember(ProceedingJoinPoint joinPoint)
            throws Throwable {
        Optional<Object> request = getHttpServletRequest(joinPoint);
        if (request.isEmpty()) {
            return "redirect:/login.do";
        }
        final HttpServletRequest servletRequest = (HttpServletRequest) request.get();

        if (!AttributeContainer.hasSessionAttributeOf(servletRequest, "member")) {
            return "redirect:/login.do";
        }
        Member member = (Member) AttributeContainer.sessionAttributeFrom(servletRequest, "member");

        if (!adminMembers.contains(member.getId())) {
            return "redirect:/productList.do";
        }

        return joinPoint.proceed();
    }

    private Optional<Object> getHttpServletRequest(ProceedingJoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg instanceof HttpServletRequest)
                .findAny();
    }
}
