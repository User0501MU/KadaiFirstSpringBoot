package com.techacademy14;
//http://localhost:8080/dayofweek/20240502
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // 月は0から始まるため、1を引きます
        String[] dayOfWeekStrings = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeekStrings[dayOfWeek - 1];
    }

    @GetMapping("/plus/{num1}/{num2}")
    public int calcPlus(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/minus/{num1}/{num2}")
    public int calcMinus(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping("/times/{num1}/{num2}")
    public int calcTimes(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/{num2}")
    public int calcDivide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return num1 / num2;
    }
}