package Week1;

//Abstract class
abstract class Appliance {
void turnOn() {
   System.out.println("Turned On.");
}
}

//Interface
interface Connectable {
void connect();
}

//SmartTV extends Appliance and implements Connectable
class SmartTV extends Appliance implements Connectable {

// Implementing the interface method
@Override
public void connect() {
   System.out.println("SmartTV is connected to WiFi.");
}
}

//Main class
public class AbstractVsInterface {
public static void main(String[] args) {
   SmartTV tv = new SmartTV();
   
   tv.turnOn();    // From abstract class
   tv.connect();   // From interface
}
}

