package unchange;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j(topic = "c.TestSimpleDataFormat")
public class TestSimpleDataFormat {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDate date = dtf.parse("2021-08-12", LocalDate::from);
                log.debug("{}", date);
            }).start();
        }
    }
}
