package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> months = new ArrayList<>();

    public MonthInterceptor() {
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if (monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        int monthNumber = Integer.parseInt(monthNumberString);
        Month month = months.stream()
                .filter(m -> m.getMonthNumber() == monthNumber)
                .findFirst()
                .orElse(new Month(monthNumber, "nope", "nope", "nope"));
        request.setAttribute("month", month);
        return true;
    }
}

