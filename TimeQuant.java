// Author: Mohamed Eladl
// Project: CPU Scheduler
// Date: March 21, 2020

import java.io.*;
import java.util.*;

public class TimeQuant {

    private File process;

    public TimeQuant(String track) {
        process = new File(track);
    }

    public List<List<String>> read() {
        try {
            FileReader file = new FileReader(process);
            BufferedReader bufferReader1 = new BufferedReader(file);
            List<List<String>> timeQuantum = new ArrayList<>();
            String line;
            while ((line = bufferReader1.readLine()) != null) {
                String[] time = line.split(",");
                List<String> currentT = Arrays.asList(time);
                timeQuantum.add(currentT);
            }
            file.close();
            return timeQuantum;
        }
        catch (IOException r) {
            r.printStackTrace();
        }
        return null;
    }

}
