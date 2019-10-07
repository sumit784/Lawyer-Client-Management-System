package com.lawyer.project.controllers;

import java.util.List;

import javax.validation.Valid;

import com.lawyer.project.services.EmployeeService;
import com.lawyer.project.models.Employee;
import com.lawyer.project.repositories.GeneralAnnouncementRepository;
import com.lawyer.project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private GeneralAnnouncementRepository announcementRepo;
    @Autowired
    EmployeeService employeeService;


    
    
    
    public HomeController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //@GetMapping("/")
    // public String showUsers(Model model){
    //     model.addAttribute("users", userRepo.findAll());
    //     return "index";
    // }
    
    @GetMapping("/")
    public String showIndex(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);
        model.addAttribute("announcement", announcementRepo.getAnn());
        //announcementRepo.putAnn();
        return "master/index";
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("1", "employee", new Employee());
    }


    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/logout-success")
    public String logoutPage(){
        return "logout";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = "/addEmployee", method=RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("1","emp", new Employee());
    }

    // @RequestMapping(value = "/addEmployee", method=RequestMethod.POST)
    // public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
    //     model.addAttribute("name", employee.getName());
    //     model.addAttribute("contactNumber", employee.getContactNumber());
    //     model.addAttribute("id", employee.getId());
    // }

    // @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	// public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {
	// 	employeeService.insertEmployee(emp);
	// 	List<Employee> employees = employeeService.getAllEmployees();
	// 	ModelAndView model = new ModelAndView("getEmployees");
	// 	model.addObject("employees", employees);
	// 	return model;
	// }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String processRequest1(@ModelAttribute("emp") Employee emp) {
		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		// ModelAndView model = new ModelAndView("getEmployees");
		// model.addObject("employees", employees);
		return "thanks";
    }
    
    //show all employees saved in db
	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
}