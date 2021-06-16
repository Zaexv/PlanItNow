package models;

public class Participation {

	private ParticipationState participation_state; 
	private Integer satisfaction_grade; 
	
	private User user_joined; 
	private Plan to_plan;
	
	public Participation (User user, Plan plan, ParticipationState state) {
		user_joined = user; 
		to_plan = plan; 
		participation_state = state;
	}

	public User getUser_joined() {
		return user_joined;
	}

	public void setUser_joined(User user_joined) {
		this.user_joined = user_joined;
	}
	
	public void unactivate() {
		this.participation_state = ParticipationState.INACTIVE;
	}

	public Integer getSatisfaction_grade() {
		return satisfaction_grade;
	}

	public void setSatisfaction_grade(Integer satisfaction_grade) {
		this.satisfaction_grade = satisfaction_grade;
	}

	@Override
	public String toString() {
		return "Participation [participation_state=" + participation_state + ", satisfaction_grade="
				+ satisfaction_grade + ", user_joined=" + user_joined + ", to_plan=" + to_plan + "]";
	}
	
	
	
	
	
}
