package Experiment;

public class TaskAppMain {

	    public static void main(String[] args) {
	        TaskManager manager = new TaskManager();

	       
	        User u1 = new User(1, "Alice", "Developer", "alice@company.com");
	        User u2 = new User(2, "Bob", "Tester", "bob@company.com");
	        Manager1 m1 = new Manager1(3, "Carol", "carol@company.com", "Engineering");

	        manager.addUser(u1);
	        manager.addUser(u2);
	        manager.addUser(m1);

	       
	        Project p1 = new Project("Website Revamp", "2025-12-31");
	        p1.addTeamMember(u1);
	        p1.addTeamMember(u2);
	        p1.addTeamMember(m1);

	        
	        Task t1 = new Task(101, "Design UI", "Create modern UI mockups");
	        Task t2 = new Task(102, "Backend API", "Develop RESTful endpoints", "2025-11-15");
	        Task t3 = new Task(103, "Testing", "Perform integration testing");

	        p1.addTask(t1);
	        p1.addTask(t2);
	        p1.addTask(t3);

	        manager.addProject(p1);

	        
	        manager.assignTask(p1, 101, 1); 
	        manager.assignTask(p1, 102, 1, "2025-11-15"); 
	        manager.assignTask(p1, 103, 2); 

	       
	        manager.updateTaskStatus(p1, 101, Task.Status.IN_PROGRESS);
	        manager.updateTaskStatus(p1, 101, Task.Status.DONE);

	        manager.updateTaskStatus(p1, 102, Task.Status.IN_PROGRESS);

	        
	        m1.approveTask(t2);

	       
	        System.out.println("\n--- All Tasks in Project ---");
	        manager.listTasks(p1);

	      
	        System.out.println("\n--- Tasks Completed by Alice ---");
	        manager.reportTasksCompletedByUser(u1);

	        
	        System.out.println("\n--- Tasks Completed by Bob ---");
	        manager.reportTasksCompletedByUser(u2);

	   
	        User ref = m1; 
	        ref.displayDetails(); 

	        
	        System.out.println("\n--- Project Details ---");
	        p1.displayProject();
	    }
	}

