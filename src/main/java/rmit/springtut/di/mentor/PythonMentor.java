package rmit.springtut.di.mentor;

import rmit.springtut.di.service.FortuneService;

public class PythonMentor implements Mentor {
    // Define attribute for the dependency
    private final FortuneService fortuneService;

    // Define constructor

    public PythonMentor(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 1h to practice Numpy, you will be the best Python developer :)";
    }

    @Override
    public String getDailyFortune() {
        System.out.println("Python mentor: getting daily fortune...");
        return fortuneService.getFortune();
    }
}
