package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {



    public static void main(String[] args) {

        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        boolean isMac = System.getProperty("os.name")
                .toLowerCase().startsWith("mac");

        if(isWindows){
            String nameOS= System.getProperty("os.name");
            System.out.println("Operating system "+ nameOS);

            String TotalMemory = "wmic ComputerSystem get TotalPhysicalMemory";
            String FreeMemory = "wmic OS get FreePhysicalMemory";




        }else if(isMac){
            String nameOS= System.getProperty("os.name");
            System.out.println("Operating system: "+ nameOS);

            String TotalMemory = "sysctl -a | grep '^hw.memsize' | awk '{print $2}'";
            String UsedMemory = "top -l 1 | grep PhysMem: | awk '{print $2}'";
            String FreeMemory = "top -l 1 | grep PhysMem: | awk '{print $6}'";


            String FreeCPU = "top -l 1 | grep 'CPU usage': | awk '{print $7}'";
            String CPU_UsedBySystem = "top -l 1 | grep 'CPU usage': | awk '{print $5}'";
            String CPU_UsedByUser = "top -l 1 | grep 'CPU usage': | awk '{print $3}'";



            System.out.println("************************************");
            try {
                ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", TotalMemory);
                Process p=pb.start();
                BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while((line=br.readLine())!=null){
                    System.out.println("Total Memory: "+line);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }



        } else {
            String nameOS= System.getProperty("os.name");
            System.out.println("Operating system: "+ nameOS);

        }
    }
}
