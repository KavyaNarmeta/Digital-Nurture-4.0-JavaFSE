class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

public class TaskManagementSystem {
    private Task head = null;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public Task searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            head = head.next;
            return;
        }

        Task prev = head;
        Task current = head.next;

        while (current != null) {
            if (current.taskId == taskId) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void displayTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.addTask(1, "Design Module", "Pending");
        system.addTask(2, "Implement Module", "In Progress");
        system.addTask(3, "Test Module", "Pending");

        system.displayTasks();

        System.out.println("Searching Task 2: " + system.searchTask(2));

        system.deleteTask(1);
        system.displayTasks();
    }
}
