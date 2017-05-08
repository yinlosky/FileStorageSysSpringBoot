package edu.umbc.yhuang9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by yhuang9 on 5/8/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationMain.class)
@WebAppConfiguration
public class ApplicationMainTest {
    @Test
    public void contextLoads(){

    }
}