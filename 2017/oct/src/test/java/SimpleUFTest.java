import org.junit.Test;

import java.util.Arrays;

public class SimpleUFTest {

    @Test
    public void foo() {
        SimpleUF simpleUF = new SimpleUF(10);


        simpleUF.union(4,3);
        System.out.println(Arrays.toString(simpleUF.p));

        simpleUF.union(3,8);
        System.out.println(Arrays.toString(simpleUF.p));
    }

}