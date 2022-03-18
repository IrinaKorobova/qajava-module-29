import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest {
    public void currentTime (){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    @BeforeClass
    void beforeClass () {
        System.out.println("Before class");
        currentTime();
    }
    @AfterClass
    void afterClass () {
        System.out.println("After class");
        currentTime();
    }
    @DataProvider(name = "personProvider")
    Object [][] dataProvider (){
        return new Object[][] {
                {10, false},
                {13, true},
                {15, true},
                {18, true},
                {19, true},
                {20, false}
        };
    }
    @Test (dataProvider = "personProvider")
    public void testPerson(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        System.out.println(age + " age - " + result);

     Assert.assertEquals(result, expected);

    }
}
