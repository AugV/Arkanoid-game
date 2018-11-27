import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(GameRulesTestMockito.class);

        for(Failure failure: result.getFailures()){
            System.out.println("FAILURE:" + failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
