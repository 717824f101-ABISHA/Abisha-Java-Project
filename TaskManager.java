package Experiment;

	import java.util.*;

	public class TaskManager {
	    private List<User> users;
	    private List<Project> projects;

	    public TaskManager() {
	        users = new ArrayList<>();
	        projects = new ArrayList<>();
	    }

	    
	    public void addUser(User user) {
	        users.add(user);
	    }

	    public User getUserById(int id) {
	        for (User u : users)
	            if (u.getId() == id)
	                return u;
	        return null;
	    }

	    
	    public void addProject(Project project) {
	        projects.add(project);
	    }

	    public Project getProjectByName(String name) {
	        for (Project p : projects)
	            if (p.getName().equalsIgnoreCase(name))
	                return p;
	        return null;
	    }

	    
	    public void assignTask(Project project, int taskId, int userId) {
	        assignTask(project, taskId, userId, null);
	    }

	    public void assignTask(Project project, int taskId, int userId, String deadline) {
	        Task task = null;
	        for (Task t : project.getTasks())
	            if (t.getId() == taskId)
	                task = t;
	        User user = getUserById(userId);
	        if (task != null && user != null) {
	            task.setAssignedUser(user);
	            if (deadline != null)
	                task.setDeadline(deadline);
	            System.out.println("Assigned task '" + task.getTitle() + "' to " + user.getName());
	        }
	    }

	    public void updateTaskStatus(Project project, int taskId, Task.Status status) {
	        for (Task t : project.getTasks())
	            if (t.getId() == taskId)
	                t.setStatus(status);
	    }

	    public void listTasks(Project project) {
	        project.listTasks();
	    }

	    public void reportTasksCompletedByUser(User user) {
	        int completed = 0;
	        System.out.println("Completed Tasks by " + user.getName() + ":");
	        for (Project p : projects) {
	            for (Task t : p.getTasks()) {
	                if (t.getAssignedUser() != null && t.getAssignedUser().getId() == user.getId()
	                        && t.getStatus() == Task.Status.DONE) {
	                    completed++;
	                    t.displayTask();
	                }
	            }
	        }
	        System.out.println("Total completed: " + completed);
	    }
	}

