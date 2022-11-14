import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements isAvallableDate {

    private LocalDateTime dateTime;
    private int id;
    private String title;
    private String description;
    private Type type;
    private static int idGenerator=0;

    public Task(String dateTime, String title, int description, LocalDateTime type) {
        this.dateTime = LocalDateTime.parse(dateTime);
        this.title = title;
        this.description = String.valueOf(description);
        this.type = type.getClass();
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
    }

    public int getId(){
        return id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean isAvaillable(LocalDateTime inputDate)  {
        return inputDate.isEqual(getDateTime().toLocalDate().atStartOfDay());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && dateTime.equals(task.dateTime) && title.equals(task.title) && description.equals(task.description) && type.equals(task.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, id, title, description, type);
    }

    @Override
    public String toString() {
        return "Task{" +
                "dateTime=" + dateTime +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }

}