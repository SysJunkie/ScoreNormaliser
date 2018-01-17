
/**
 * Class for representing Team Members as user
 * 
 * @author Team 26
 *
 */
public class User {

	private String name;
	private Integer professionalismScore;
	private Integer meetingParticipationScore;
	private Integer workEvalScore;
	private Double normalisedScore;
	
	/**
	 * Constructor for User class
	 * @param name - name of the User
	 * @param professionalismScore - professionalism score for the User
	 * @param meetingParticipationScore - meeting participation score for the User
	 * @param workEvalScore - work evaluation score for the User
	 */
	public User(String name, Integer professionalismScore, Integer meetingParticipationScore, Integer workEvalScore) {
		setName(name);
		setProfessionalismScore(professionalismScore);
		setMeetingParticipationScore(meetingParticipationScore);
		setWorkEvalScore(workEvalScore);
	}

	/**
	 * @return the name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the professionalismScore
	 */
	public Integer getProfessionalismScore() {
		return professionalismScore;
	}

	/**
	 * @param professionalismScore the professionalismScore to set
	 */
	public void setProfessionalismScore(Integer professionalismScore) {
		this.professionalismScore = professionalismScore;
	}

	/**
	 * @return the meetingParticipationScore
	 */
	public Integer getMeetingParticipationScore() {
		return meetingParticipationScore;
	}

	/**
	 * @param meetingParticipationScore the meetingParticipationScore to set
	 */
	public void setMeetingParticipationScore(Integer meetingParticipationScore) {
		this.meetingParticipationScore = meetingParticipationScore;
	}

	/**
	 * @return the workEvalScore
	 */
	public Integer getWorkEvalScore() {
		return workEvalScore;
	}

	/**
	 * @param workEvalScore the workEvalScore to set
	 */
	public void setWorkEvalScore(Integer workEvalScore) {
		this.workEvalScore = workEvalScore;
	}

	/**
	 * @return the normalisedScore
	 */
	public Double getNormalisedScore() {
		return normalisedScore;
	}

	/**
	 * @param normalisedScore the normalisedScore to set
	 */
	public void setNormalisedScore(Double normalisedScore) {
		this.normalisedScore = normalisedScore;
	}
	
}
