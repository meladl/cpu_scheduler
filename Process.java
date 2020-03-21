// Author: Mohamed Eladl
// Project: CPU Scheduler
// Date: March 21, 2020

public class Process {

    private int executeTime;
    private int arriveTime;
    private final int burstTime;
    private int completionTime;
    private int processId;

    public Process(int aExecuteTime, int aArrive, int aProcessId) {
        executeTime = aExecuteTime;
        burstTime = aExecuteTime;
        arriveTime = aArrive;
        processId = aProcessId;
    }

    public int getProcessID() {
        return processId;
    }

    public int getExecutionTime() {
        return executeTime;
    }

    public void setExecutionTime(int aExecuteTime) {
        executeTime = aExecuteTime;
    }

    public void setCompletionTime(int aCompletionTime) {
        completionTime = aCompletionTime;
    }

    public int turnaroundTime() {
        return completionTime - arriveTime;
    }

    public int waitTime() {
        return turnaroundTime() - burstTime;
    }

}
