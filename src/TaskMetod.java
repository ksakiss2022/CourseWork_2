import java.time.LocalDateTime;
import java.util.*;

public class TaskMetod {
    private Map<Integer, Task> taskMap = new HashMap<>();
    private Collection<Task> removedTask;

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void remove(int id) {
        taskMap.remove(id);

    }

    public Collection<Task> getAllByDate(LocalDateTime inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : taskMap.entrySet()) {
            var task = integerTaskEntry.getValue();
            if (task.isAvaillable(inputDate)) {

                resultList.add(task);
            }
        }
        return resultList;
    }
}
