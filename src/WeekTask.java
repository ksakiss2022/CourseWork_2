import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class WeekTask extends Task{

    public WeekTask(String dateTime, String title, int description, LocalDateTime type) {
        super(dateTime, title, description, type);
    }

    @Override
    public boolean isAvaillable(LocalDateTime inputDate) {
        var startDate=getDateTime().toLocalDate();
        while (startDate.isBefore(ChronoLocalDate.from(inputDate))){
            if (startDate.equals(inputDate)){
                return  true;
            }
            startDate=startDate.plusWeeks(1);
        }
        return false;
    }
}
