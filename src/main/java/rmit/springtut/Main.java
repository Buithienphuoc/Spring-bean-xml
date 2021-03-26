package rmit.springtut;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import rmit.springtut.di.mentor.Mentor;
import rmit.springtut.ioc.coach.Coach;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                Which demo do you want?\s
                Press 1 to run Inversion of Control.\s
                Press 2 to run Dependency Injection.\s
                Your choice:""");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1 -> runInversionOfControlDemo();
            case 2 -> runDependencyInjectionDemo();
            default -> System.out.println("Wrong input or not existed choice");
        }
    }
    public static void runInversionOfControlDemo() throws InterruptedException {
        System.out.println("----------------------Inversion of control demo------------------------------");
        // Step 1: Load configuration file
        System.out.println("Step 1: Loading configuration file...\n");
        TimeUnit.SECONDS.sleep(3);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Step 2: Retrieve bean from spring container
        System.out.println("Step 2: Retrieving bean from Spring container...\n");
        TimeUnit.SECONDS.sleep(3);
        Coach cppCoach = context.getBean("cppCoach", Coach.class);
        Coach javaCoach = context.getBean("javaCoach", Coach.class);
        // Step 3: Call methods on the bean
        System.out.println("Step 3: Call methods on bean... \n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("C++ coach says:" + cppCoach.getDailyWorkout());
        System.out.println("Java coach says:" + javaCoach.getDailyWorkout());
        // Step 4: Close the context
        context.close();
    }
    public static void runDependencyInjectionDemo() throws InterruptedException {
        System.out.println("-----------------------Dependency injection demo------------------------------");
        // Step 1: Load configuration file
        System.out.println("Step 1: Loading configuration file...\n");
        TimeUnit.SECONDS.sleep(3);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Step 2: Retrieve bean from spring container
        System.out.println("Step 2: Retrieving bean from Spring container...\n");
        TimeUnit.SECONDS.sleep(3);
        Mentor pythonMentor = context.getBean("pythonMentor", Mentor.class);
        // Step 3: Call methods on the bean
        System.out.println("Step 3: Call methods on bean... \n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Python mentor says:" + pythonMentor.getDailyFortune() +
                " " + pythonMentor.getDailyWorkout());
        // Step 4: Close the context
        context.close();
    }
}
