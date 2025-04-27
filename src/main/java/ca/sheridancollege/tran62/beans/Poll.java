package ca.sheridancollege.tran62.beans;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Poll {
	
	// Identification
	private Long id;
	
	// Titles
	private String title;
	private final String[] titles = {"Candy", "Pizza"};
	
	// Question
	private String question;
	
	// Answers
	private String answer;
	
	// Votes
	private int vote1;
	private int vote2;
	private int vote3;
	
	// Date
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateField;
	
}
