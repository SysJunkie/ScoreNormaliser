
import java.util.ArrayList;

import javax.management.InvalidAttributeValueException;

/**
 * Class to normalize team member scores
 * 
 * @author Team 26
 *
 */
public class Normalization {

	/**
	 * This method performs normalization of each team member's scores and
	 * throws Exception in case any value in the argument is invalid 
	 * 
	 * @param members - ArrayList of User objects, containing each user's details
	 * @return members - ArrayList of User objects, containing each user's
	 *         details and their normalized score
	 * @throws InvalidAttributeValueException
	 *             - when the input is invalid
	 */
	public static ArrayList<User> normalizeScore(ArrayList<User> members) throws InvalidAttributeValueException {

		if (members.size() < 2 || members.size() > 7) {
			throw new InvalidAttributeValueException("Invalid number of team members: " + members.size());
		}
		Double total = new Double(0);
		Double userTotal = new Double(0);

		for (User member : members) {
			userTotal = (double) (member.getMeetingParticipationScore() + member.getProfessionalismScore()
					+ member.getWorkEvalScore());
			member.setNormalisedScore(userTotal);
			total += userTotal;
		}
		if (total == 0 || total > members.size() * 15) {
			throw new InvalidAttributeValueException("Invalid Total score: " + total);
		}
		for (User member : members) {
			member.setNormalisedScore(member.getNormalisedScore() / total);
		}
		return members;
	}

}
