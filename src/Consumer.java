//The Consumer Class File

//Declaration of the consumer class that inherits the threads class file
public class Consumer extends Thread{

    //Private declaration of an Object of the Producer Class
    private Producer p;

    //Declaring a Consumer object who takes the producer as an argument
    public Consumer(Producer c){
        p = c;
    }

    //Run Function of the consumer, it checks the activity of the Producer function in AsAlive()
    //or if the Producer List is still has numbers that isn't consumed yet in "mylist.size()>0"
    @Override
    public void run(){
        try {
            while (p.isAlive() || p.mylist.size()>0){
            p.consume();}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
