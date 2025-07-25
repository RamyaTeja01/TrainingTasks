package Week1;

//Base class
class Animal {
void sound() {
   System.out.println("Animal makes a sound");
}
}

//Dog class
class Dog extends Animal {
@Override
void sound() {
   System.out.println("Dog barks");
}
}

//Cat class
class Cat extends Animal {
@Override
void sound() {
   System.out.println("Cat meows");
}
}

//Cow class
class Cow extends Animal {
@Override
void sound() {
   System.out.println("Cow moos");
}
}

//Main class
public class MethodOverridingAnimalSound {
public static void main(String[] args) {
   // Dynamic Method Dispatch
   Animal animal;

   animal = new Dog();    
   animal.sound();        

   animal = new Cat();    
   animal.sound();        

   animal = new Cow();    
   animal.sound();        
}
}

