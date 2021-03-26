package rmit.springtut.ioc.coach;

public class CppCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do 1 SED exercise!";
    }
}
