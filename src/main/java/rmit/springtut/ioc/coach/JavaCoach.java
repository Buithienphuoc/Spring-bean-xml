package rmit.springtut.ioc.coach;

public class JavaCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Create 1 Spring boot API";
    }
}
