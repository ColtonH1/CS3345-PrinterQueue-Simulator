import java.io.File; 
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Printer
{
    public static void main(String[] args) throws IOException
    {
        BinaryHeap printerQueue = new BinaryHeap(); //labeled printerQueue since it is the decider for what prints next
        Scanner sc = new Scanner(new File("input.txt"));
       

        
        while (sc.hasNextLine())
        { 
            sc.useDelimiter("\\s"); //scans for input until next white space
            String userName = sc.next(); //holds the name
            String userPriority = sc.next(); //holds the priority
            String numpages = sc.next(); //holds the number of pages
            String whichClass = sc.next(); //holds info stating if inside outside print

            //moves to next line to start reading for next time, but only if there is a next line
            if(sc.hasNextLine())
            {
                sc.nextLine();
            } 

            //if the whichClass varaible represents the inside printjob, then go to printjob
            if(whichClass.equals("I"))  
            {
                Printjob job = new Printjob(userName, Integer.parseInt(userPriority), Integer.parseInt(numpages));
                printerQueue.insert(job);
            }
            //else it can only be one other option: O which means to go to outside printjob
            else
            { 
                OutsidePrintjob job = new OutsidePrintjob(userName, Integer.parseInt(userPriority), Integer.parseInt(numpages));
                printerQueue.insert(job);
            }
            
        }
        sc.close(); //always close file

        //until we reached the end of the queue
        while(!printerQueue.isEmpty())
        {
            //check which class they belong to
            //everyone is a child of Printjob, but not everyone is a child of OutsidePrintjob
           if(printerQueue.findMin() instanceof OutsidePrintjob)
           {
                OutsidePrintjob currentOutJob = (OutsidePrintjob) printerQueue.deleteMin(); 
                currentOutJob.displayPrintJob(); //display info as the queue is being deleted
                currentOutJob.getFee(currentOutJob.getNumPages());
           }
           else 
           {
                Printjob currentJob = (Printjob) printerQueue.deleteMin(); 
                currentJob.displayPrintJob();
           }
           System.out.println("");
        }
        

    } 

}