package com.company;


public class Main {

    public static void main(String[] args){

        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        boolean isMac = System.getProperty("os.name")
                .toLowerCase().startsWith("mac");

        if(isWindows){
            String nameOS= System.getProperty("os.name");
            System.out.println("Operating system "+ nameOS);

            String TotalMemory = "wmic ComputerSystem get TotalPhysicalMemory";
            String FreeMemory = "wmic OS get FreePhysicalMemory";

            String PercentProcessorTime = " Powershell \"gwmi Win32_PerfFormattedData_PerfOS_Processor | Select -First 1 | %{'{0}%' -f $_.PercentProcessorTime}\"";



        }else if(isMac){
            String nameOS= System.getProperty("os.name");
            System.out.println("Operating system: "+ nameOS);

            String TotalMemory = "sysctl -a | grep '^hw.memsize' | awk '{print $2}'";
            String UsedMemory = "top -l 1 | grep PhysMem: | awk '{print $2}'";
            String FreeMemory = "top -l 1 | grep PhysMem: | awk '{print $6}'";


            String FreeCPU = "top -l 1 | grep 'CPU usage': | awk '{print $7}'";
            String CPU_UsedBySystem = "top -l 1 | grep 'CPU usage': | awk '{print $5}'";
            String CPU_UsedByUser = "top -l 1 | grep 'CPU usage': | awk '{print $3}'";

        } else {


        }
    }
}
