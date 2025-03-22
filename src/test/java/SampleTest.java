import com.base.BaseTest;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void testSample() {
        logStep(startStep(), "Open application");
        logStep(nextStep(), "On Dashboard Page, tap on click Macro");
        onboardScreen()
                .clickOnSkipButton();
    }
}
