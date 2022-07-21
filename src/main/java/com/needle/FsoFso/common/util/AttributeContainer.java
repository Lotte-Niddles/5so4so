package com.needle.FsoFso.common.util;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class AttributeContainer {

    private AttributeContainer() {
    }

    public static boolean hasSessionAttributeOf(HttpServletRequest request, String attributeKey) {
        final List<String> attributes = new ArrayList<>();
        request.getSession().getAttributeNames().asIterator()
                .forEachRemaining(attributes::add);
        return attributes.contains(attributeKey);
    }

    public static Object sessionAttributeFrom(HttpServletRequest request, String attributeKey) {
        if (hasSessionAttributeOf(request, attributeKey)) {
            return request.getSession().getAttribute(attributeKey);
        }
        return null;
    }

    public static boolean hasAttributeOf(HttpServletRequest request, String attributeKey) {
        final List<String> attributes = new ArrayList<>();
        request.getAttributeNames().asIterator()
                .forEachRemaining(attributes::add);
        return attributes.contains(attributeKey);
    }

    public static Object attributeFrom(HttpServletRequest request, String attributeKey) {
        if (hasAttributeOf(request, attributeKey)) {
            return request.getAttribute(attributeKey);
        }
        return null;
    }
}
