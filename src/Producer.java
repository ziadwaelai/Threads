import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Declaring a Producer Class that extends a thread class
public class Producer extends Thread {

    //The Starting Time Variable
    public static long startTime;

    //The Variable at the end time we want to calculate
    public static long endTime;

    //The Variable that holds the maximum prime number, initialized with Zero
    private static int max_prim = 0;

    //The Declaration of the file output as a string
    public static String file;

    //The Variable that holds the numbers of the primary numbers in the thread
    private static int num_prim = -1;

    //Declaring the variable buffer
    private static int buffer;

    //The Size of the numbers entered by the user
    private static int n;

    //Declaration of the Array list that holds the N size integers
    public final List<Integer> mylist = new ArrayList<>();

    //A Counter Initialized by Zero
    static int counter = 0;

    //The producer function, that takes Size of array N, the buffer size and the file output to
    public Producer(int num, int buf, String _file) {
        n = num;
        buffer = buf;
        file = _file;
    }

    //A Function that resets the variables after finishing work
    public static void reSet() {
        max_prim = 0;
        num_prim = 0;
        counter = 0;
        startTime = 0;
        endTime = 0;
    }

    //Function to check if the number in the iteration is a Prime Number or not
    //in the for loop we started from 2 as prime numbers starts from 2
    // the Condition check if the number is divisible by itself or not
    //If it's prime number we add to the counter to count how many prime numbers we have
    public int prim_n() {
        counter++;
    if(counter < 2) return -1;
    if(counter == 2 || counter == 3) return counter;
    if(counter%2 == 0 || counter%3 == 0) return -1;
    long sqrtN = (long)Math.sqrt(counter)+1;
    for(long i = 6L; i <= sqrtN; i += 6) {
        if(counter%(i-1) == 0 || counter%(i+1) == 0) return -1;
    }
    return counter;
    }

    //The synchronization function of producer
    public synchronized void produce() throws InterruptedException {
        while (mylist.size() == buffer) { //while the array size is equal to buffer, the
            // System.out.println("producer is waiting");
            wait(); //here the producer waits
        }
        int number = prim_n(); //a variable number holds the prime numbers counter
        if (number != -1 && number <= n) { //As long as the number is not -1 and still less than the array size N
            mylist.add(number); //we Add the number
            num_prim++; //and here the counter prime numbers is increased
            SecondFrame.jLabel5.setText(Integer.toString(num_prim)); //We transform the counter to string for the GUI
            if (number > max_prim) { //if the prime number we have is bigger than the previous maximum we replace it
                max_prim = number;
                SecondFrame.jLabel4.setText(Integer.toString(max_prim)); //We transform the Maximum Prime to string for the GUI
            }


            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write("\"" + number + "\"" + ",");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // System.out.println("this num is produced " + number);
        }
        notify();
    }

    //The Run function for our project, with a Start Time to begin calculating the time for the execution
    public void run() {
        try {
            startTime = System.currentTimeMillis(); //The Time Variable
            while (counter <= n) { //Condition as long as we didn't pass the Size N
                produce(); //we will keep producing
                endTime = System.currentTimeMillis(); //The end time here for when the work is finished
                SecondFrame.jLabel6.setText(Long.toString(endTime - startTime) + " ms"); //the GUI Time Calculation
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //The Synchronization of the consumer class
    public synchronized void consume() throws InterruptedException {
        while (mylist.size() == 0) { //While the list array is equal to zero
            // System.out.println("consumer is waiting");
            wait(); //the consumer will keep waiting till numbers is put in
        }
        // System.out.println("number is consumed " + mylist.get(0));
        mylist.remove(0); //The Number here consumed and removed
        notify();

    }

}
