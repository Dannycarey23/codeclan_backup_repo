# Polymorphism & Composition Homework - Quiz

# Polymorphism

1. What does the ___word___ 'polymorphism' mean?

'Many forms'

2. What does it mean when we apply polymorphism to OO design? Give a simple Java example.

We are treating an instance of a class as if it is also another class/type at the same time.

```java
public interface IVegetarian{}
public class Deer implements IVegetarian{}

Deer deer = new Deer();
IVegetarian vegetarian = deer;
```

3. What can we use to implement polymorphism in Java?

Interfaces, Abstract Classes, Inheritance

4. How many 'forms' can an object take when using polymorphism?

As many as it needs.

5. Give an example of when you could use polymorphism.

If you wanted a class to have a collection of different types of objects and be able to add objects of those types to the collection e.g:

```java
public interface IEat{}
public class Salmon implements IEat{}
public class Honey implements IEat{}

public class Bear() {
  ArrayList<IEat> belly;

  public Bear() {
    belly = new ArrayList<IEat>();
  }

  public void eat(IEat food) {
    belly.add(food)
  }
}

Bear bear = new Bear();
IEat honey = new Honey();
IEat salmon = new Salmon();

bear.eat(honey);
bear.eat(salmon);
```

# Composition and Aggregation

6. What do we mean by 'composition' in reference to object-oriented programming?

Composition is when an object is made up, or contains other objects.

7. When would you use composition? Provide a simple example in Java.

You would use composition when you want to model an object where another object(s) __IS_A_PART_OF__ the object, rather than inheriting from those objects.

Composition Example:

```java

class Roof {
  int height;
  int width;
  int length;

  public Roof(int height, int width, int length) {
    this.height = height;
    this.width = width;
    this.length = length;
  }
}

class House {
  Roof roof;

  public House() {
    Roof = new Roof();
  }
}
```

8. Give a difference between composition and aggregation?

Composition refers to an ___is-a-part-of___ relationship where an object is made up of one or more other objects. The object composed of other behaviours ___owns___ those behaviours. This means that when the object is destroyed ___all___ of its behaviours are also destroyed.

Aggregation, on the other hand refers to a __has_a__ relationship, where an object has other objects. These objects can exist independently so when the owning object is destroyed, the object it 'owned' can still exist.

Aggregation Example:

```java

class Engine {
    private int capacity;
    public void rev() {

    }

    public Engine(int capacity) {
      this.capacity = capacity;
    }
}

class Gearbox {
    private String type;
    private int numberOfGears;

    public Gearbox(String type, int numberOfGears) {
      this.type = type;
      this.numberOfGears = numberOfGears;
    }
}

class Car {
    private String make;
    private String model;
    private Engine engine;
    private GearBox GearBox;

    public Car(String make, String model, Engine engine, GearBox gearBox) {
      this.make = make;
      this.model = model;
      this.engine = engine;
      this.gearBox = gearBox;
    }
}


Engine engine = new Engine(2000);
GearBox gearBox = new GearBox("manual", 5);

Car car = new Car("Ford", "Escort", engine, gearbox);
```


9. What is/are the advantage(s) of using composition/aggregation?

You can get the behaviour you want from other classes without having to rely on an inheritance tree. Composition is also more flexible than inheritance as class can choose from behaviours and we can swap behaviours in/out as we need them.

10. When using composition, when an object is destroyed, what happens to all the objects it is composed of?

They are also destroyed.

11. When using aggregation, when an object is destroyed, what happens to all the objects it is composed of?

They can still exist.