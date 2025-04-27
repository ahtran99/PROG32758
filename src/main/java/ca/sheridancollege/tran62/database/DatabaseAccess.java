package ca.sheridancollege.tran62.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.tran62.beans.Poll;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	/*
	 * public void insertPoll() { // Used to specify parameters
	 * MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	 * 
	 * // Specify query String query = "INSERT INTO poll(name) VALUES ('Frank')";
	 * 
	 * // Insert Poll to DB int rowsAffected = jdbc.update(query, namedParameters);
	 * 
	 * // Check to see if insert was successful if (rowsAffected > 0) {
	 * System.out.println("A Poll was inserted into DB"); } }
	 */

	public void insertPoll(Poll poll) {
		// Used to specify parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Specify query
		String query = "INSERT INTO poll(title, question, answer, vote1, vote2, vote3, dateField) VALUES (:title, :question, :answer, :vote1, :vote2, :vote3, "
				+ ":dateField)";

		// Specify and insert to DB
		namedParameters.addValue("title", poll.getTitle());
		namedParameters.addValue("question", poll.getQuestion());
		namedParameters.addValue("answer", poll.getAnswer());
		namedParameters.addValue("vote1", poll.getVote1());
		namedParameters.addValue("vote2", poll.getVote2());
		namedParameters.addValue("vote3", poll.getVote3());
		namedParameters.addValue("dateField", poll.getDateField());

		// Insert Poll to DB
		int rowsAffected = jdbc.update(query, namedParameters);

		if (rowsAffected > 0) {
			System.out.println("Poll was inserted into DB");
		}
	}

	public List<Poll> getPollList() {
		// To use for parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		// Get all students from the DB
		String query = "SELECT * FROM poll";
		// Return the list of students
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Poll>(Poll.class));
	}
}
