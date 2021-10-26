package com.veyor.challenge;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeast;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class TestSolutionQ1 {
    @Test
    public void testMain() throws IOException {
        try {
            String input = "1";
            mockStatic(Result.class);
            InputStream stream = new ByteArrayInputStream((input + "\n"+"3"+"\n").getBytes(StandardCharsets.UTF_8)); //this stream will output the example string
            InputStream stdin = System.in;
            System.setIn(stream);
            PowerMockito.verifyStatic(atLeast(1));
            SolutionQ1.main(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomSort(){
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        mockStatic(Result.class);
        Logger logger = Mockito.mock(Logger.class);
        Result.customSort(ls);
        verify(logger,times(0)).error(anyString());
        mockStatic(Result.class);
    }
}
