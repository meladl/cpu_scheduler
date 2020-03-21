// Author: Mohamed Eladl
// Project: CPU Scheduler
// Date: March 21, 2020

import java.util.*;

public class Cpu {

     private int time;
     private Data data;

    public Cpu(int quantum, Data aData) {
        time = quantum;
        data = aData;
    }

    private void execute(Process process) {
        int execute = process.getExecutionTime();
        process.setExecutionTime(execute - 1);
    }

    public void execute(){
        int contextSwitch = 0;
        int processCompletion = 0;
        int t = 0;
        int _cpuUtilization = 0;
        int counter = data.getProcessNumber();
        int currentQuantum = time;
        Queue<Process> queue = new LinkedList<>();
        List<Process> processExecution = new ArrayList<>();
        while (processCompletion != counter){
            Queue<Process> arrivalTime = data.createProcess(t);
            if (arrivalTime != null){
                Iterator<Process> arrivalIterator = arrivalTime.iterator();
                while (arrivalIterator.hasNext()){
                    Process p = arrivalIterator.next();
                    queue.add(p);
                    arrivalIterator.remove();
                }
            }
        Process p = queue.peek();
        if (p == null){
            t++;
            continue;
        }
        execute(p);
        System.out.println("Process " + p.getProcessID() + " is running at " + t + " (Time)" );
        t++;
        _cpuUtilization++;
        currentQuantum--;
        if (p.getExecutionTime() == 0){
            currentQuantum = time;
            processCompletion++;
            p.setCompletionTime(t);
            processExecution.add(queue.poll());
            System.out.println("Process " + p.getProcessID() + " was completed in " + t + " (Time)" );
            System.out.println("A context switch is in process...");
            contextSwitch++;
        }
        else if (currentQuantum == 0){
            currentQuantum = time;
            if (p.getExecutionTime() > 0){
                queue.add(queue.poll());
                System.out.println("Context Switch");
            }
            else{
                currentQuantum = time;
                processCompletion++;
                System.out.println(" Process " + p.getProcessID() + " completed at " + t + " (Time)" );
                System.out.println("A context switch is in process...");
                p.setCompletionTime(t);
                processExecution.add(queue.poll());
            }
            contextSwitch++;
        }
    }
    Iterator<Process> processIteration = processExecution.iterator();
    int totalWaitTime = 0;
    int turnaroundTime = 0;
    while (processIteration.hasNext()){
        Process p = processIteration.next();
        totalWaitTime = totalWaitTime + p.waitTime();
        turnaroundTime = turnaroundTime + p.turnaroundTime();
    }
    double _avgTurnaroundTime = (double) turnaroundTime / counter;
    double _avgWaitTime = (double) totalWaitTime / counter;
    double throughputRate = (double) counter / t;
    double utilize = (double) (_cpuUtilization / t) * 100;
    System.out.println("\nSelected Time Quantum: " + time);
    System.out.println("Average turnaround time: " + _avgTurnaroundTime);
    System.out.println("Average wait time: " + _avgWaitTime);
    System.out.println("Number of context switches performed: " + contextSwitch);
    System.out.println("CPU Utilization: " + utilize + "%");
    System.out.println("CPU Throughput: " + throughputRate);
    }

}
