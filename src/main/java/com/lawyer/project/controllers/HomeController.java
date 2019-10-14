package com.lawyer.project.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
//import org.apache.commons.lang3.StringUtils;   

import javax.validation.Valid;

//import com.lawyer.project.services.EmployeeService;
import com.lawyer.project.services.MessageService;
import com.lawyer.project.services.NotificationService;
import com.lawyer.project.models.Appointment;
import com.lawyer.project.models.Cases;
import com.lawyer.project.models.Court;
import com.lawyer.project.models.Document;
import com.lawyer.project.models.GeneralAnnouncements;
import com.lawyer.project.models.Judge;
//import com.lawyer.project.models.Employee;
import com.lawyer.project.models.MailingList;
import com.lawyer.project.models.MassMailBody;
import com.lawyer.project.models.Message;
import com.lawyer.project.repositories.AnnouncementRepository;
import com.lawyer.project.repositories.AppointmentRepository;
import com.lawyer.project.repositories.CaseRepository;
import com.lawyer.project.repositories.CourtRepository;
import com.lawyer.project.repositories.DocumentRepository;
import com.lawyer.project.repositories.GeneralAnnouncementRepository;
import com.lawyer.project.repositories.JudgeRepository;
import com.lawyer.project.repositories.MailingListRepository;
import com.lawyer.project.repositories.MassMailBodyRepository;
import com.lawyer.project.repositories.MessageRepository;
import com.lawyer.project.repositories.SubscriberListMassMailing;
import com.lawyer.project.repositories.UserCloneRepository;
import com.lawyer.project.repositories.UserCredentialRepository;
import com.lawyer.project.repositories.UserListCredentialRepository;
//import com.lawyer.project.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.MailException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import net.ricecode.similarity.JaroWinklerStrategy;
// import net.ricecode.similarity.SimilarityStrategy;
// import net.ricecode.similarity.StringSimilarityService;
// import net.ricecode.similarity.StringSimilarityServiceImpl;

import info.debatty.java.stringsimilarity.*;
import com.lawyer.project.UserCredentials;
import com.lawyer.project.dao.impl.MessageDaoImpl;

@Controller
public class HomeController {

    // @Autowired
    // private UserRepository userRepo;
    @Autowired
    private GeneralAnnouncementRepository announcementRepo;
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    // @Autowired
    // EmployeeService employeeService;
    @Autowired
    MessageService messageService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private UserListCredentialRepository userListCredentialRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private MailingListRepository mailingListRepository;
    @Autowired
    private SubscriberListMassMailing subscriberListMassMailing;
    @Autowired
    private MassMailBodyRepository massMailBodyRepository;
    @Autowired
    private AnnouncementRepository annRepo;
    @Autowired
    private UserCloneRepository userCloneRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private CourtRepository courtRepository;
    @Autowired
    private JudgeRepository judgeRepository;


    
    
    
    public HomeController() {
        
    }

    //@GetMapping("/")
    // public String showUsers(Model model){
    //     model.addAttribute("users", userRepo.findAll());
    //     return "index";
    // }

    @GetMapping("/error")
    public String showIndecks(){
        return "/error";
    }

    // @GetMapping("/editCase/{id}/")
    // public Model editCase(Model model){
    //     CaseRepository cas = caseRepository.getCaseById(id).get(0);
    // }

    
    

    @RequestMapping(value="/saveCase", method=RequestMethod.POST)
	public String pupdate(@ModelAttribute("cas") Cases cas, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        caseRepository.UpdateCaseBy(cas);
        System.out.println(cas.getUsername());
	    return "/lawyers/AdminHome";
    }
    
    @RequestMapping(value="/findCase", method=RequestMethod.GET)
    public ModelAndView findCaseG(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }
        ModelAndView m = new ModelAndView("/lawyers/ViewSearch");
        return m;
    }


    @RequestMapping(value="/findCase", method=RequestMethod.POST)
    public ModelAndView findCase(@RequestParam("s") String s){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }

        //int d = Levenshtein.distance(s, "acciden");
        int scored;
        Long index;
        int indexy;
        index= (long) 0;
        indexy= 0;
        scored=100;
        List <Cases> l = caseRepository.getAllCases();
        ModelAndView m = new ModelAndView("/lawyers/ViewMostRelevant");
        //StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
        for(int i = 0; i < l.size(); i++) {
            if(s!=null&&l.get(i).getDescription()!=null){
                if(Levenshtein.distance(s, l.get(i).getDescription())<scored){
                    index= l.get(i).getId();
                    indexy=i;
                    scored=Levenshtein.distance(s, l.get(i).getDescription());
                }
            }
            
        }
        System.out.println(index);
        
        m.addObject("legal_case", l.get(indexy));

        return m;
    }

    // public static double similarity(String s1, String s2) {
    //     String longer = s1, shorter = s2;
    //     if (s1.length() < s2.length()) { // longer should always have greater length
    //       longer = s2; shorter = s1;
    //     }
    //     int longerLength = longer.length();
    //     if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
    //     /* // If you have Apache Commons Text, you can use it to calculate the edit distance:
    //     LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    //     return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; */
    //     return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    
    //   }
    
    //   // Example implementation of the Levenshtein Edit Distance
    //   // See http://rosettacode.org/wiki/Levenshtein_distance#Java
    //   public static int editDistance(String s1, String s2) {
    //     s1 = s1.toLowerCase();
    //     s2 = s2.toLowerCase();
    
    //     int[] costs = new int[s2.length() + 1];
    //     for (int i = 0; i <= s1.length(); i++) {
    //       int lastValue = i;
    //       for (int j = 0; j <= s2.length(); j++) {
    //         if (i == 0)
    //           costs[j] = j;
    //         else {
    //           if (j > 0) {
    //             int newValue = costs[j - 1];
    //             if (s1.charAt(i - 1) != s2.charAt(j - 1))
    //               newValue = Math.min(Math.min(newValue, lastValue),
    //                   costs[j]) + 1;
    //             costs[j - 1] = lastValue;
    //             lastValue = newValue;
    //           }
    //         }
    //       }
    //       if (i > 0)
    //         costs[s2.length()] = lastValue;
    //     }
    //     return costs[s2.length()];
    //   }

    
    // @RequestMapping(value="/findCase", method=RequestMethod.POST)
    // public void findCase(@ModelAttribute("q") Query q, Model model){
    //     // model.addAttribute("q", q);
    //     // return "/lawyers/search";
    //     //SimilarityStrategy strategy = new JaroWinklerStrategy();
    //     String source;
    //     source = "acciden";
    //     System.out.println(source);
    //     Long index;
    //     index=(long)0;
    //     Double scored;
    //     scored=0.0;
    //     List <Cases> l = caseRepository.getAllCases();
    //     //System.out.println(l.size());
    //     Levenshtein l1 = new Levenshtein();
    //     //StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
    //     for(int i = 0; i < l.size(); i++) {
    //         if(source!=null&&l.get(i).getDescription()!=null){
    //             if(l1.distance(source, l.get(i).getDescription())<scored){
    //                 index= l.get(i).getId();
    //                 scored=l1.distance(source, l.get(i).getDescription());
    //             }
    //         }
            
    //     }
    //     System.out.println(index);
    //     //Model model1 = new Model();
    //     //double score = service.score(source, target); // Score is 0.90

    // }

    
    

    @GetMapping("/publishJournal")
    public String massMail(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        MassMailBody massmail = new MassMailBody();
        model.addAttribute("massmail", massmail);
        return "/lawyers/publishJournal";
    }


    @PostMapping("/publishJournal")
    public String mailAll(@ModelAttribute("massmail") MassMailBody massmail, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        massMailBodyRepository.addBody(massmail);
        List <MailingList> l = subscriberListMassMailing.getAllMails();
        for(int i=0;i<l.size();i++){
            MailingList mail = l.get(i);
            notificationService.massMail(mail.getEmail(), massmail.getBody());
        }
        return "/lawyers/publishJournal";
    }

    @GetMapping("/addCase")
    public String addCase(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        Cases cas = new Cases();
        model.addAttribute("cas", cas);
        return "/lawyers/ViewAddCase";
    }

    @PostMapping("/addCase")
    public String paddCases(@ModelAttribute("cas") Cases cas, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        caseRepository.addCase(cas.getUsername(), cas.getCaseType(), cas.getCourt_id(), cas.getJudge_id(),cas.getDescription(), cas.getJudgementDate(), cas.getPreviousHearingDate(), cas.getNextHearingDate(), cas.getStatus());
        return "/lawyers/ViewAddCase";
    }

//     @PostMapping("/upload")
//     public ResponseEntity uploadToLocalFileSystem(@RequestParam("file") MultipartFile file) {
//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//         Path path = Paths.get(fileBasePath + fileName);
//         try {
//             Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                 .path("/files/download/")
//                 .path(fileName)
//                 .toUriString();
//         return ResponseEntity.ok(fileDownloadUri);
//     }

//     @PostMapping("/multi-upload")
//     public ResponseEntity multiUpload(@RequestParam("files") MultipartFile[] files) {
//         List<Object> fileDownloadUrls = new ArrayList<>();
//         Arrays.asList(files)
//                 .stream()
//                 .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file).getBody()));
//         return ResponseEntity.ok(fileDownloadUrls);
// }

    @GetMapping("/addAnnouncement")
    public String addAnnouncements(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        GeneralAnnouncements g = new GeneralAnnouncements();
        model.addAttribute("g", g);
        return "/lawyers/addAnn";
    }

    @PostMapping("/addAnnouncement")
    public String paddAnnouncement(@ModelAttribute("g") GeneralAnnouncements g, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        annRepo.addAnnouncement(g.getText());
        return "/lawyers/addAnn";
    }

    @GetMapping("/addMail")
    public String addMail(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        
        MailingList mail = new MailingList();
        model.addAttribute("mail", mail);
        //mailingListRepository.addMail("venkatshanmukha793@gmail.com");
        return "/lawyers/addMail1";
        
        //return "/lawyers/login";
        
    }



    @PostMapping("/addEmail")
    public String addMail(@ModelAttribute("mail") MailingList mail, Model model){
        mailingListRepository.addMail(mail.getEmail());
        return "/lawyers/addMail1";
    }

    @GetMapping("/addAppointment")
    public String addApp(Model model){
            Appointment app = new Appointment();
            model.addAttribute("app", app);
            return "/lawyers/addApp1";
    }



    @PostMapping("/addAppointment")
    public String addAppo(@ModelAttribute("app") Appointment app, Model model){
        appointmentRepository.addAppointment(app.getName(), app.getAddress(), app.getReason(), app.getEmail(), app.getContactNumber(), app.getAppointmentDate());
        return "/lawyers/addApp1";
    }


    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    // @GetMapping("/addNewsletter")
    // public String addnewsletter(Model model){
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     String name = auth.getName();
    //     if(name=="admin"){
    //         MassMailBody massmail = new MassMailBody();
    //         model.addAttribute("massmail", massmail);
    //         //mailingListRepository.addMail("venkatshanmukha793@gmail.com");
    //         return "/lawyers/addNewsLetter";
    //     }
    //     return "/lawyers/login";
        
    // }



    // @PostMapping("/addNewsletter")
    // public String addMail(@ModelAttribute("massmail") MassMailBody massmail, Model model){
    //     massMailBodyRepository.addBody(massmail);
    //     return "thanks";
    // }

    @GetMapping("/addUser")
    public String addUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        UserCredentials user = new UserCredentials();
        model.addAttribute("user", user);
        return "/lawyers/addUser1";
    }

    @PostMapping("/addUser")
    public String processAddUser(@ModelAttribute("user") UserCredentials user, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        //UserCredentials user = new UserCredentials();
        //model.addAttribute("user", user);
        userCredentialRepository.addUser(user.getUsername(), user.getPassword(), user.getAddress(), user.getEmail(), user.getPhone());
        userCloneRepository.addUser(user.getUsername(), user.getPassword(), user.getAddress(), user.getEmail(), user.getPhone());
        try{
            notificationService.sendNotification(user);
        }catch(MailException e){
            //catch error
        }
        return "/lawyers/addUser1";
        //System.out.println(user.getUsername());
    }

    @GetMapping("/viewMess")
    public ModelAndView ViewMess(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Long user_id;
        user_id = userCredentialRepository.getUserIdFromUsername(name);
        ModelAndView m = new ModelAndView("/lawyers/viewMess");
        Message mess = new Message();
        mess=messageService.getMessagesForUser(user_id);
        if(mess.getBody()==null){
            ModelAndView n = new ModelAndView("/lawyers/NoMessage");
            return n;
        }
        m.addObject("mess", mess);
        return m;

    }

    @GetMapping("/viewCase")
    public ModelAndView ViewCase(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        // Long user_id;
        // user_id = userCredentialRepository.getUserIdFromUsername(name);
        ModelAndView m = new ModelAndView("/lawyers/viewCase");
        List <Cases> l;
        l=caseRepository.getCasesByUsername(name);
        System.out.println(l.size());
        m.addObject("l", l);
        return m;

    }

    @GetMapping("/addMessage")
    public String addMess(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        Message message = new Message();
        model.addAttribute("message", message);
        return "/lawyers/AddMessageView";
    }

    @GetMapping("/viewAppointments")
    public ModelAndView addAppointments(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }
        ModelAndView m = new ModelAndView("/lawyers/viewAppointments");
        List <Appointment> l;
        l=appointmentRepository.getAllAppointments();
        model.addAttribute("l", l);
        return m;
    }

    @GetMapping("/viewUsers")
    public ModelAndView addUsers(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }
        ModelAndView m = new ModelAndView("/lawyers/viewUsers");
        List <UserCredentials> l;
        l = userCredentialRepository.getAllUsers();
        model.addAttribute("l", l);
        return m;
    }

    @GetMapping("/viewAllCases")
    public ModelAndView viewAllCases (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }
        ModelAndView m = new ModelAndView("/lawyers/viewAllCases");
        List <Cases> l;
        l = caseRepository.getAllCases();
        model.addAttribute("l", l);
        return m;
    }

    // @GetMapping("/viewAllCases")
    // public ModelAndView viewAllCases (Model model){
    //     ModelAndView m = new ModelAndView("/lawyers/viewAllCases");
    //     List <Cases> l;
    //     l = caseRepository.getAllCases();
    //     model.addAttribute("l", l);
    //     return m;
    // }

    @RequestMapping(value="/editCase/{id}/", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")){
            ModelAndView n = new ModelAndView("SecurityBreach");
            return n;
        }
	    ModelAndView model = new ModelAndView("/lawyers/ViewEditCase");
	    Cases cas = caseRepository.getCaseById(id).get(0);
	    model.addObject("cas", cas);
	    return model;
	}

    // @GetMapping("/publishJournal")
    // public ModelAndView publishJournal (Model model){
    //     ModelAndView m = new ModelAndView("/lawyers/publishJournal");
    //     List <Cases> l;
    //     l = caseRepository.getAllCases();
    //     model.addAttribute("l", l);
    //     return m;
    // }

    @PostMapping("/addMessage")
    public String processAddMess(@ModelAttribute("message") Message message, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(!name.equals("admin")) return "SecurityBreach";
        //UserCredentials user = new UserCredentials();
        //model.addAttribute("user", user);
        messageRepository.addMessage(message);
        // try{
        //     notificationService.sendNotification(user);
        // }catch(MailException e){
        //     //catch error
        // }
        return "/lawyers/AddMessageView";
        //System.out.println(user.getUsername());
    }

    @GetMapping("/home")
    public String showIndex(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        //announcementRepo.getAnn()
        //Message m = messageService.getMessagesForUser(name);
        //System.out.println(m.getBody());
        //List <Message> n = messageService.getAllMessages();
        //System.out.println(n.size());
        //userCredentialRepository.addUser("ven793", "1", "address", "email", "phone");
        //System.out.println(name);
        //Date date = new Date();
        //appointmentRepository.addAppointment("venky", "varanasi", "fun", "email", "contact_number", date);
        //appointmentRepository.addAppointment("donky", "varanasi", "fun", "email", "contact_number", date);
        // System.out.println(userListCredentialRepository.getAllUsers().size());
        // model.addAttribute("announcement", announcementRepo.getAnn());
        List <Judge> j;
        j=judgeRepository.getAllJudges();
        List <Court> c;
        c=courtRepository.getAllCourts();
        model.addAttribute("judgelist", j);
        model.addAttribute("courtlist", c);
        String s;
        if(name.equals("admin")){
            s =  "/lawyers/AdminHome";
            
        }
        else s =  "/lawyers/ClientHome";
        return s;
        //announcementRepo.putAnn();
        //return "lawyers/index";
    }

    @GetMapping("/viewAnn")
    public ModelAndView showgenann(){
        ModelAndView m = new ModelAndView("/lawyers/viewAnn");
        String s = announcementRepo.getAnn();
        m.addObject("s", s);
        return m;
    }

    // @RequestMapping(value = "/1", method = RequestMethod.GET)
    // public ModelAndView showForm() {
    //     return new ModelAndView("1", "employee", new Employee());
    // }


    @GetMapping("/login")
    public String loginPage(){
        return "/lawyers/DefaultHome";
    }

    @GetMapping("/logout-success")
    public String logoutPage(){
        return "redirect:/";
    }

    // @GetMapping("/home")
    // public String homepage(){
    //     return "home";
    // }


    
    // @GetMapping("/addAppointment")
    // public String appointmentPage(){
    //     return "home";
    // }

    // @GetMapping("/admin")
    // public String admin(){
    //     return "admin";
    // }

    @GetMapping("/downloads")
    public ModelAndView download(){
        ModelAndView model = new ModelAndView("/lawyers/ViewDownload");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List <Document> obj = documentRepository.getDocumentByUsername(name);
        model.addObject("obj",obj);
        return model;
    }


    @GetMapping("/")
    public String homer(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(name.equals("admin")){
            return "redirect:/home";
        }
        else return "redirect:/home";
    }
    // @RequestMapping(value = "/addEmployee", method=RequestMethod.GET)
    // public ModelAndView show() {
    //     return new ModelAndView("1","emp", new Employee());
    // }

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

    // @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	// public String processRequest1(@ModelAttribute("emp") Employee emp) {
	// 	employeeService.insertEmployee(emp);
	// 	List<Employee> employees = employeeService.getAllEmployees();
	// 	// ModelAndView model = new ModelAndView("getEmployees");
	// 	// model.addObject("employees", employees);
	// 	return "thanks";
    // }
    
    // //show all employees saved in db
	// @RequestMapping("/getEmployees")
	// public ModelAndView getEmployees() {
	// 	List<Employee> employees = employeeService.getAllEmployees();
	// 	ModelAndView model = new ModelAndView("getEmployees");
	// 	model.addObject("employees", employees);
	// 	return model;
	// }
}