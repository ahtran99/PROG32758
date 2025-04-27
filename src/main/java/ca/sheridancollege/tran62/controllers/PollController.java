package ca.sheridancollege.tran62.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.tran62.beans.Poll;
import ca.sheridancollege.tran62.database.DatabaseAccess;

// Alexander Tran
// 91500919
// October 23, 2021
@Controller
public class PollController {
	
	@Autowired
	private DatabaseAccess da;
	
	List<Poll> pollList = new CopyOnWriteArrayList<Poll>();

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("poll", new Poll());
		model.addAttribute("pollList", pollList);
		return "index.html";
	}

	@GetMapping("/candy")
	public String candy(Model model, @ModelAttribute Poll poll) {
		da.insertPoll(poll);
		model.addAttribute("poll", new Poll());
		model.addAttribute("pollList", pollList);
		return "candy.html";
	}
	
	@GetMapping("/chips")
	public String chips(Model model, @ModelAttribute Poll poll) {
		da.insertPoll(poll);
		model.addAttribute("poll", new Poll());
		model.addAttribute("pollList", pollList);
		return "chips.html";
	}


	@PostMapping("/result")
	public String result(Model model, @ModelAttribute Poll poll) {
		pollList.add(poll);
		model.addAttribute("pollList", pollList);
		return "result.html";
	}
}
