package org.springframework.samples.grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class EndPointLoggingController {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    public EndPointLoggingController(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @RequestMapping(value="/endpointlist", method=RequestMethod.GET)
    @ResponseBody
    public String endpointlist() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        buffer.append("<html>");
        buffer.append("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>End Point List</title></head>");
        buffer.append("<body>");
        buffer.append("<h1>End Point List</h1><hr>");
        buffer.append("<div>Total : ");
        buffer.append(requestMappingHandlerMapping.getHandlerMethods().size());
        buffer.append("</div>");
        buffer.append("<table>");
        buffer.append("<thead><tr><td>Patterns</td><td>Class</td><td>Name</td><td>Request Methods</td><td>Headers</td><td>Parameters</td><td>Consumes</td><td>Produces</td></tr></thead>");
        buffer.append("<tbody>");
        for (RequestMappingInfo r : requestMappingHandlerMapping.getHandlerMethods().keySet()) {
            HandlerMethod h = requestMappingHandlerMapping.getHandlerMethods().get(r);
            buffer.append("<tr>");
            buffer.append("<td>");
            buffer.append(r.getPatternsCondition().getPatterns());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(h.getBeanType().getSimpleName());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(h.getMethod().getName());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(r.getMethodsCondition().getMethods());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(r.getHeadersCondition().getExpressions());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(r.getParamsCondition().getExpressions());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(r.getConsumesCondition().getExpressions());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(r.getProducesCondition().getExpressions());
            buffer.append("</td>");
            buffer.append("</tr>");
        }
        buffer.append("</tbody>");
        buffer.append("</table>");
        buffer.append("</body>");
        buffer.append("</html>");
        return buffer.toString();
    }
}
