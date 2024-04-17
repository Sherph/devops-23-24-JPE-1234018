package basic_demo;


import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    dependencies {
        // Use Apache Log4J for logging
        implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
        implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
        testImplementation 'junit:junit:4.12'
    }
}