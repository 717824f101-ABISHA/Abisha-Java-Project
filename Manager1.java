package Experiment;

public class Manager1 extends User {
	
	    private String department;

	    public Manager1(int id, String name, String email, String department) {
	        super(id, name, "Manager", email);
	        this.department = department;
	    }

	    public String getDepartment() { return department; }
	    public void setDepartment(String department) { this.department = department; }

	    
	    @Override
	    public void displayDetails() {
	        System.out.println("Manager[ID:" + getId() + ", Name:" + getName() + ", Email:" + getEmail() +
	                ", Dept:" + department + "]");
	    }

	    public void approveTask(Task t) {
	        if (t.getStatus().equals(Task.Status.IN_PROGRESS)) {
	            t.setStatus(Task.Status.DONE);
	            System.out.println("Manager approved task: " + t.getTitle());
	        }
	    }
	}

