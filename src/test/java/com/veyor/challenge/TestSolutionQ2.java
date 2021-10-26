package com.veyor.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyNew;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class TestSolutionQ2 {

    @Mock
    private Logger logger;
    private File outPutFile;


    @Before
    public void setUp(){
        String dir = SolutionQ2.class.getResource("/").getPath();
        outPutFile = new File(dir+"out_put.txt");
    }

    @Test
    public void testMain() throws IOException {
        try {

            String input = "1";
            mockStatic(Result.class);
            InputStream stream = new ByteArrayInputStream((input + "\n"+"3"+"\n").getBytes(StandardCharsets.UTF_8));
            System.setIn(stream);
            SolutionQ2.main(null);
            List<String> list = new ArrayList<>();
            try (Stream<String> st = Files.lines(Paths.get(outPutFile.getPath()))) {
                list = st.collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("1",list.get(0));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMainOutOfRangeNAndUnluckyNumber() throws IOException {
        try {
            String input = "0";
            mockStatic(Result.class);
            InputStream stream = new ByteArrayInputStream((input + "\n"+"0"+"\n").getBytes(StandardCharsets.UTF_8));
            System.setIn(stream);
            SolutionQ2.main(null);
            List<String> list = new ArrayList<>();
            try (Stream<String> st = Files.lines(Paths.get(outPutFile.getPath()))) {
                list = st.collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("0",list.get(0));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMainMaxDollarAmt() throws IOException {
        try {
            String input = "3";
            mockStatic(Result.class);
            InputStream stream = new ByteArrayInputStream((input + "\n"+"3"+"\n").getBytes(StandardCharsets.UTF_8));
            System.setIn(stream);
            SolutionQ2.main(null);
            List<String> list = new ArrayList<>();
            try (Stream<String> st = Files.lines(Paths.get(outPutFile.getPath()))) {
                list = st.collect(Collectors.toList());

            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("5",list.get(0));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
