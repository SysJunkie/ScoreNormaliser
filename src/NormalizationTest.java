
import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

/**
 * This class tests the normalization of the scores using Junit methods
 *
 * @author Team 26
 */
public class NormalizationTest {

	//Tests the correct normalization of scores
	@Test
	public void testNormalizeScore() throws InvalidAttributeValueException {
		ArrayList<User> members = new ArrayList<>();
		User user1 = new User("User1", 4, 4, 4);
		members.add(user1);
		User user2 = new User("User2", 5, 5, 4);
		members.add(user2);
		User user3 = new User("User3", 5, 4, 4);
		members.add(user3);
		User user4 = new User("User4", 5, 4, 5);
		members.add(user4);

		ArrayList<User> normMembers = Normalization.normalizeScore(members);

		assertTrue(normMembers.get(0).getNormalisedScore().doubleValue() == (double) 12 / 53);
		assertTrue(normMembers.get(1).getNormalisedScore().doubleValue() == (double) 14 / 53);
		assertTrue(normMembers.get(2).getNormalisedScore().doubleValue() == (double) 13 / 53);
		assertTrue(normMembers.get(3).getNormalisedScore().doubleValue() == (double) 14 / 53);
	}

	//Tests Total of the normalized score equals 1
	@Test
	public void testTotalNormalizedScore() throws InvalidAttributeValueException {
		ArrayList<User> members = new ArrayList<>();
		User user1 = new User("User1", 4, 4, 4);
		members.add(user1);
		User user2 = new User("User2", 5, 5, 4);
		members.add(user2);
		User user3 = new User("User3", 5, 4, 4);
		members.add(user3);
		User user4 = new User("User4", 5, 4, 5);
		members.add(user4);

		ArrayList<User> normMembers = Normalization.normalizeScore(members);

		assertTrue(normMembers.get(0).getNormalisedScore().doubleValue()
				+ normMembers.get(1).getNormalisedScore().doubleValue()
				+ normMembers.get(2).getNormalisedScore().doubleValue()
				+ normMembers.get(3).getNormalisedScore().doubleValue() == 1);
	}


	//Tests if the Number of members in the input are valid
	@Test
	public void testValidNumberOfMembers() throws InvalidAttributeValueException {
		
		ArrayList<User> members = new ArrayList<>();
		
		User user1 = new User("User1", 4, 4, 4);
		members.add(user1);

		try {
			ArrayList<User> normMembers = Normalization.normalizeScore(members);
			fail();
		} catch (InvalidAttributeValueException e) {
			assertNotNull(e);
		}

		User user2 = new User("User2", 4, 3, 4);
		members.add(user2);
		User user3 = new User("User3", 4, 3, 4);
		members.add(user3);
		User user4 = new User("User4", 4, 5, 3);
		members.add(user4);
		User user5 = new User("User5", 5, 3, 3);
		members.add(user5);
		User user6 = new User("User6", 5, 2, 2);
		members.add(user6);
		User user7 = new User("User7", 5, 4, 4);
		members.add(user7);
		User user8 = new User("User8", 5, 2, 5);
		members.add(user8);
		User user9 = new User("User9", 5, 4, 5);
		members.add(user9);
		
		try {
			ArrayList<User> normMembers = Normalization.normalizeScore(members);
			fail();
		} catch (InvalidAttributeValueException e) {
			assertNotNull(e);
		}

		ArrayList<User> members1 = new ArrayList<>();
		members1.add(user1);
		members1.add(user2);
		members1.add(user3);
		members1.add(user4);

		ArrayList<User> normMembers1 = Normalization.normalizeScore(members1);

		assertTrue(normMembers1.size() >= 2);
		assertTrue(normMembers1.size() <= 7);
	}

	//Negative test to check handling when all input scores are 0
	@Test
	public void testMinTotalScore() throws InvalidAttributeValueException {
		ArrayList<User> members = new ArrayList<>();
		User user1 = new User("User1", 0, 0, 0);
		members.add(user1);
		User user2 = new User("User2", 0, 0, 0);
		members.add(user2);
		User user3 = new User("User3", 0, 0, 0);
		members.add(user3);

		try {
			ArrayList<User> normMembers = Normalization.normalizeScore(members);
			fail();
		} catch (InvalidAttributeValueException e) {
			assertNotNull(e);
		}

	}

	//Tests if the total score of all the members is valid
	@Test
	public void testInvalidTotalScore() throws InvalidAttributeValueException {
		ArrayList<User> members = new ArrayList<>();
		User user1 = new User("User1", 10, 10, 10);
		members.add(user1);
		User user2 = new User("User2", 10, 10, 10);
		members.add(user2);
		User user3 = new User("User3", 10, 10, 10);
		members.add(user3);

		try {
			ArrayList<User> normMembers = Normalization.normalizeScore(members);
			fail();
		} catch (InvalidAttributeValueException e) {
			assertNotNull(e);
		}
	}

	
	//Tests if the Number of normalized scores returned is same as the number of members received as input
	@Test
	public void testNumberOfReturnedScoresSameAsTeamMembers() throws InvalidAttributeValueException {
		ArrayList<User> members = new ArrayList<>();
		User user1 = new User("User1", 4, 4, 4);
		members.add(user1);
		User user2 = new User("User2", 5, 5, 4);
		members.add(user2);
		User user3 = new User("User3", 5, 4, 4);
		members.add(user3);
		User user4 = new User("User4", 5, 4, 5);
		members.add(user4);
		ArrayList<User> normMembers = Normalization.normalizeScore(members);

		assertTrue(normMembers.size() == members.size());
	}
	
	
}
