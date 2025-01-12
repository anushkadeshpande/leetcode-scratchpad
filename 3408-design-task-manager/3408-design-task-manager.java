class TaskManager {

    class Task {
        int userId;
        int taskId;
        int priority;

        public Task() {}

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public void setPriority(int newPriority) {
            this.priority = newPriority;
        }

        public int getUserId() {
            return this.userId;
        }

        public int getTaskId() {
            return this.taskId;
        }

        public int getPriority() {
            return this.priority;
        }

        @Override
        public String toString() {
            return "UserId: " + userId + " TaskId: " + taskId + " Priority: " + priority;
        }

        @Override
        public boolean equals(Object o){
            return this.taskId == ((Task)o).taskId;
        }

        @Override
        public int hashCode() {
            return userId;
        }
    }

    Map<Integer, Task> tasksMap = new HashMap<>();
    Queue<Task> tasksHeap = new PriorityQueue<>((a, b) -> {
        if (b.priority != a.priority) {
            return b.priority - a.priority; 
        } else if(b.taskId != a.taskId){
            return b.taskId - a.taskId; 
        } else 
            return b.userId - a.userId;
    });

    public TaskManager(List<List<Integer>> tasks) {
        // use heap??
        // max heap on the basis of priority and task id
        // ++ hashmap with taskId as key for faster lookup

        // for each of the task items, add it to map and heap
        for(List<Integer> task: tasks) {
            // ideally should have checks and validations here
            Task t = new Task(task.get(0), task.get(1), task.get(2));

            tasksMap.put(t.taskId, t);
            tasksHeap.add(t);
        }

    }
    
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);

        tasksMap.put(t.taskId, t);
        tasksHeap.add(t);
    }
    
    public void edit(int taskId, int newPriority) {

        if (tasksMap.containsKey(taskId)) {
            Task t = tasksMap.get(taskId);

            // t.setPriority(newPriority);

            // creating a new object to avoid modifying the existing one thereby preventing any inconsistencies in the heap
            // as heap refers to this object, and any changes done in the object wont trigger Reheapification
            Task updatedTask = new Task(t.userId, taskId, newPriority);
            tasksMap.put(taskId, updatedTask);

            // Add the updated task back to the heap 
            tasksHeap.add(updatedTask); 
        }
    }
    
    public void rmv(int taskId) {
        tasksMap.remove(taskId);
    }
    
    public int execTop() {
        while(!tasksHeap.isEmpty()) {
            Task t = tasksHeap.poll();

            // check if the top task has not been removed or updated
            if(tasksMap.containsKey(t.taskId) && tasksMap.get(t.taskId).priority == t.priority) {
                tasksMap.remove(t.taskId);

                return t.userId;
            }
        }

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */