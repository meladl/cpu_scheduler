// Author: Mohamed Eladl
// Project: CPU Scheduler
// Date: March 21, 2020

public class RoundRobin {

    private static Data info;

    public static void main(String[] args) {
        int timeQ = Integer.parseInt(args[1]);
        String file = args[0];
        if (timeQ <= 0) {
            System.out.println("Incorrect Input : Time Quantum cannot be less than 0!");
            return;
        }
        TimeQuant timeQuantum = new TimeQuant(file);
        info = new Data(timeQuantum.read());
        Cpu cpu = new Cpu(timeQ, info);
        cpu.execute();
    }

}
