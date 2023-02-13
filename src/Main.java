import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.Content;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.ChangeInformation;
import br.com.dio.desafio.dominio.Contents;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentorship;
import br.com.dio.desafio.dominio.Organizer;
import br.com.dio.desafio.dominio.User;

public class Main {

    private static final String BOOTCAMP = "Bootcamp";
    private static final String COURSE = "Course";
    private static final String MENTORING = "Mentoring";

    private static Set<Course> courseList = new LinkedHashSet<>();
    private static Set<Mentorship> mentorList = new LinkedHashSet<>();
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("What are you, a student or organizer? ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("organizer")) {
                loading();
                organizeBootcamp(scan);
                break;
            } else if (answer.equalsIgnoreCase("student")) {
                loading();
                isRegister(scan);
                break;
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }



        // System.out.println(course1);
        // System.out.println(course2);
        // System.out.println(mentorship);

        /*Dev devOne = new Dev();
        devOne.setName("One");
        devOne.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        devOne.progress();
        devOne.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        System.out.println("Concluded Contents One: " + devOne.getConcludedContents());
        System.out.println("XP: " + devOne.calculateTotalXp());

        System.out.println("---------------");

        Dev devTwo = new Dev();
        devTwo.setName("Two");
        devTwo.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents Two: " + devTwo.getSubscribedContent());
        devTwo.progress();
        devTwo.progress();
        devTwo.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents Two: " + devTwo.getSubscribedContent());
        System.out.println("Concluded Contents Two: " + devTwo.getConcludedContents());
        System.out.println("XP: " + devTwo.calculateTotalXp());*/

    }

    private static void organizeBootcamp(Scanner scan) {
        while(true) {
            System.out.println("What you want to do? Create a bootcamp or modify one?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("create")) {
                createBootcamp(scan);
                break;
            } else if (answer.equalsIgnoreCase("modify")) {
                modifyBootcamp(scan);
                break;
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void createBootcamp(Scanner scan) {
        
        loading();
        String bootcampName = ChangeInformation.changeName(scan, BOOTCAMP);
        
        loading();
        String bootcampDescription = ChangeInformation.changeDescription(scan, BOOTCAMP);
        
        //Generate key for the bootcamp.
        Set<Bootcamp> bootcamp = new HashSet<>();
        bootcamp.add(new Bootcamp(bootcampName, bootcampDescription));
        for (Bootcamp entry: bootcamp) System.out.println(entry.getName() + " - " + entry.getDescription() + " - " + entry.getContents());
        
        loading();
        System.out.println("How much content is in the bootcamp? ");
        Integer quantityContents = ChangeInformation.verifyNumber(scan);
        
        loading();
        for (int i = 1; i <= quantityContents; i++) {
            System.out.println("Register content " + i + ": ");
            whichContent(scan);
            
            String answer = scan.nextLine();
            //String changeName = ChangeInformation.changeName(scan, CONTENT);
            //String changeDescription = ChangeInformation.changeDescription(scan, CONTENT);

            Set<Course> bootcampCourses = new HashSet<>();
            //bootcampCourses.add(changeName, changeDescription, 8);

            Course course = new Course();
            //course.setTitle();
            course.setDescription("Java course description");
            course.setWorkload(8);
            
        }
        
        /*Bootcamp bootcamp = new Organizer();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Bootcamp Java Developer description");
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentorship);*/
    }

    private static void whichContent(Scanner scan) {
        while(true) {
            System.out.println("Do you want to create or choose ready-made content? ");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("create")) {
                createContent(scan);
            } else if (answer.equalsIgnoreCase("choose")) {
                chooseContent(scan);
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void createContent(Scanner scan) {
        while(true) {
            System.out.println("Do you want to create a new course or a mentorship?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("course")) {
                createCourse(scan);
            } else if (answer.equalsIgnoreCase("mentorship")) {
                createMentorship(scan);
            } else {
                loading();
                System.out.println("Invalid answer, please try again...");
            }
        }
    }

    private static void createCourse(Scanner scan) {
        String name =  ChangeInformation.changeName(scan, COURSE);
        String description =  ChangeInformation.changeDescription(scan, COURSE);
        Integer workload = ChangeInformation.changeWorkload(scan);

        Course course = new Course();
        course.setTitle(name);
        course.setDescription(description);
        course.setWorkload(workload);
        courseList.add(course);

        for (Course teste : courseList) {
            System.out.println(teste.getTitle() + " - " + teste.getDescription() + " - " + teste.getWorkload());
        }
    }

    private static void createMentorship(Scanner scan) {
        String name =  ChangeInformation.changeName(scan, MENTORING);
        String description =  ChangeInformation.changeDescription(scan, MENTORING);

        Mentorship mentorship = new Mentorship();
        mentorship.setTitle(name);
        mentorship.setDescription(description);
        mentorship.setData(LocalDate.now());
        mentorList.add(mentorship);

        for (Mentorship teste : mentorList) {
            System.out.println(teste.getTitle() + " - " + teste.getDescription() + " - " + teste.getData());
        }
    }

    private static Contents chooseContent(Scanner scan) {
        return null;
        
    }

    private static void modifyBootcamp(Scanner scan) {

    }

    private static void isRegister(Scanner scan) {

        Boolean chooseOptions = true;

        do{
            System.out.println("Are you already registered? Answer with yes or no. ");
            String answer = scan.next().toLowerCase();
            
            switch (answer) {
                case "yes":
                case "y":
                case "sim":
                case "s":
                    loading();
                    System.out.println("Select one of the options bellow: ");
                    System.out.println("---------------------------");
                    chooseOptions = false;
                    break;
                
                case "no":
                case "n":
                case "não":
                case "nao":
                    loading();
                    firstRegister(scan);
                    chooseOptions = false;
                    break;
                
                default:
                    loading();
                    System.out.println("Sorry you answered incorrectly, please try again!");
                    System.out.println("---------------------------");
            }
        } while(chooseOptions);
    }

    private static void firstRegister(Scanner scan) {

        System.out.println("---------------------------");
        System.out.println("You need to register!");

        System.out.print("Write your name: ");
        String name = scan.next();

        while (true) {
            System.out.print("\nSelect the bootcamp do you want to register: \n");
            Integer bootcamp = scan.nextInt();
            
        }
        /*Map<Integer,Dev> newDev = new HashMap<>() {{
            put(newDev.size() + 1, new Dev(name, bootcamp ));
        }};
        

        devOne.setName("One");
        devOne.subscribeBootcamp(bootcamp);
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        devOne.progress();
        devOne.progress();
        System.out.println("-");
        System.out.println("Subscribed Contents One: " + devOne.getSubscribedContent());
        System.out.println("Concluded Contents One: " + devOne.getConcludedContents());
        System.out.println("XP: " + devOne.calculateTotalXp());
        
        Dev devRegister = new Dev();*/
    }

    private static void loading() {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

}
