package Experiment;

	import java.util.*;

	public class Project {
	    private String name;
	    private String deadline;
	    private List<User> teamMembers;
	    private List<Task> tasks;
	    private int projectId;
	    private static int idCounter = 1;

	    public Project(String name, String deadline) {
	        this.name = name;
	        this.deadline = deadline;
	        this.teamMembers = new ArrayList<>();
	        this.tasks = new ArrayList<>();
	        this.projectId = idCounter++;
	    }

	 
	    public String getName() { return name; }
	    public String getDeadline() { return deadline; }
	    public List<User> getTeamMembers() { return teamMembers; }
	    public List<Task> getTasks() { return tasks; }
	    public int getProjectId() { return projectId; }

	    public void addTeamMember(User user) {
	        teamMembers.add(user);
	    }

	    public void addTask(Task task) {
	        tasks.add(task);
	    }

	    public void displayProject() {
	        System.out.println("Project[ID:" + projectId + ", Name:" + name + ", Deadline:" + deadline + "]");
	        System.out.println("Team Members:");
	        for (User u : teamMembers) {
	            System.out.print("- ");
	            u.displayDetails();
	        }
	        System.out.println("Tasks:");
	        for (Task t : tasks) {
	            t.displayTask();
	        }
	    }

	    
	    public void listTasks() {
	        for (Task t : tasks) {
	            t.displayTask();
	        }
	    }

	    public List<Task> getTasksByUser(User user) {
	        List<Task> res = new ArrayList<>();
	        for (Task t : tasks)
	            if (t.getAssignedUser() != null && t.getAssignedUser().getId() == user.getId())
	                res.add(t);
	        return res;
	    }
	}

