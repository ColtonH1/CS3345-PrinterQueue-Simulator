public class OutsidePrintjob extends Printjob
{
    //use parent class to do the same variables
    OutsidePrintjob(String name, int priority, int pages)
    {
        super(name, priority, pages);
    }

    //different about this child is the fee
    //this will get and return fee
    double getFee(int pages)
    {
        double fee = pages * 10; //in cents
        double dollars = fee/100;
        System.out.println("Your fee is: $" + String.format("%.2f", dollars));
        return fee; 
    }
}