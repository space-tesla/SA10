// Strategy Interfaces
interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

// Concrete Fly Behaviors
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("Cannot fly.");
    }
}

// Concrete Quack Behaviors
class QuackLoud implements QuackBehavior {
    public void quack() {
        System.out.println("Quack! Quack!");
    }
}

class SilentQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

// Duck base class using Strategy Pattern
class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    Duck(FlyBehavior f, QuackBehavior q) {
        this.flyBehavior = f;
        this.quackBehavior = q;
    }

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }

    // Changing strategies at runtime
    void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}

// Demo Program
public class DuckDemo {
    public static void main(String[] args) {
        Duck cityDuck = new Duck(new FlyWithWings(), new QuackLoud());

        System.out.println("=== City Duck Behavior ===");
        cityDuck.performFly();
        cityDuck.performQuack();

        // Change behavior dynamically
        System.out.println("\n=== Changing Behavior at Runtime ===");
        cityDuck.setFlyBehavior(new FlyNoWay());
        cityDuck.setQuackBehavior(new SilentQuack());

        cityDuck.performFly();
        cityDuck.performQuack();
    }
}
