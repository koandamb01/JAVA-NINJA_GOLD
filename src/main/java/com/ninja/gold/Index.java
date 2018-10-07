package com.ninja.gold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index {
	public Random rand = new Random();
	public ArrayList<String> activities = new ArrayList<String>();
	public String str = null;
	public String dateString = null;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("goldEarn") == null) {
			session.setAttribute("goldEarn", 0);
		}
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		int farm = this.rand.nextInt(10) + 10;
		this.dateString = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date()).toString();
		this.str = "<p class='text-success'>You entered a farm and earned " + farm + " golds (" + this.dateString + ")</p>";
		this.activities.add(str);
		
		session.setAttribute("activities", this.activities);
		session.setAttribute("goldEarn", (int) session.getAttribute("goldEarn") + farm); 
		return "redirect:/";
	}
	
	@RequestMapping(value="/process_cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		int cave = this.rand.nextInt(5) + 5;
		this.dateString = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date()).toString();
		this.str = "<p class='text-success'>You entered a cave and earned " + cave + " golds (" + this.dateString + ")</p>";
		this.activities.add(str);
		
		session.setAttribute("activities", this.activities);
		session.setAttribute("goldEarn", (int) session.getAttribute("goldEarn") + cave); 
		return "redirect:/";
	}
	
	@RequestMapping(value="/process_house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		int house = this.rand.nextInt(3) + 2;
		this.dateString = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date()).toString();
		this.str = "<p class='text-success'>You entered a house and earned " + house + " golds (" + this.dateString + ")</p>";
		this.activities.add(str);
		
		session.setAttribute("activities", this.activities);
		session.setAttribute("goldEarn", (int) session.getAttribute("goldEarn") + house); 
		return "redirect:/";
	}
	
	@RequestMapping(value="/process_casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		int casino = this.rand.nextInt(100) - 50;
		this.dateString = new SimpleDateFormat("MMMM d YYYY hh:mm a").format(new Date()).toString();
		
		if(casino < 0) {
			casino = casino * -1;
			this.str = "<p class='text-danger'>You entered a casino and lost " + casino + " gold. Ouch.. (" + this.dateString + ")</p>";
		}
		else if(casino == 0) {
			this.str = "<p class='text-warning'>You entered a casino and earned " + casino + " gold (" + this.dateString + ")</p>";
		}
		else {
			this.str = "<p class='text-success'>You entered a casino and earned " + casino + " gold (" + this.dateString + ")</p>";
		}
		
		this.activities.add(str);
		session.setAttribute("activities", this.activities);
		session.setAttribute("goldEarn", (int) session.getAttribute("goldEarn") + casino); 
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
