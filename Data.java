// Author: Mohamed Eladl
// Project: CPU Scheduler
// Date: March 21, 2020

import java.util.*;

public class Data {

    private Map<Integer, Queue<Process>> map;
    private int processNumber;

    public Data(List<List<String>> _process) {
        int count = 0;
        int timer = 0;
        map = new HashMap<>();
        Iterator<List<String>> run = _process.iterator();
        while (run.hasNext()) {
            List<String> scan = run.next();
            if (timer == 0) {
                timer++;
                continue;
            }
            int processId = Integer.parseInt(scan.get(0));
            int arriveTime = Integer.parseInt(scan.get(1));
            int burstTime = Integer.parseInt(scan.get(2));
            Process process1 = new Process(processId, arriveTime, burstTime);
            Queue<Process> time = map.get(arriveTime);
            if (time != null){
                time.add(process1);
            }
            else {
                Queue<Process> queue = new LinkedList<>();
                queue.add(process1);
                map.put(arriveTime, queue);
            }
            timer++;
            count++;
        }
        processNumber = count;
    }

    public Queue<Process> createProcess(int aArriveTime) {
        return map.get(aArriveTime);
    }

    public int getProcessNumber() {
        return processNumber;
    }

}
