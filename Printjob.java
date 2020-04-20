public class Printjob implements Comparable<Printjob>
{
    String user_name;
    int user_priority;
    int numpages;
    int job_priority;

    //basic contructor
    public Printjob()
    {

    }

    //constructor with proper variables
    public Printjob(String name, int priority, int pages)
    {
        setUserName(name);
        setUserPriority(priority);
        setNumPages(pages);
    }

    //set methods for the variables
    void setUserName(String name)
    {
        user_name = name;
    }

    void setUserPriority(int priority)
    {
        user_priority = priority;
    }

    void setNumPages(int pages)
    {
        numpages = pages;
    }

    //get methods for the user names
    String getUserName()
    {
        return user_name;
    }

    int getUserPriority()
    {
        return user_priority;
    }

    int getNumPages()
    {
        return numpages;
    }

    //display variables
    public void displayPrintJob()
    {
        System.out.println("User name is: " + user_name);
        System.out.println("User priority is: " + user_priority);
        System.out.println("Number of pages to print: " + numpages);
    }

    //use compareTo method with binaryHeap with our calculations
    @Override
    public int compareTo(Printjob b)
    { 
        job_priority = user_priority * numpages; //job priority of 'this'
        int secondaryJob_priority = b.user_priority * b.numpages; //job priority of the argument
        return (job_priority > secondaryJob_priority) ? 1 : (job_priority < secondaryJob_priority) ? -1 : 0 ; //return 1 if 'this' > b : -1 if 'this' < b : 0 if 'this' == b

    }





   

}