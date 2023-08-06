import components.Engine;
import components.FuelTank;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import vehicles.Car;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    FuelTank fuelTank;
    Engine engine;
    Car car;

    @Before
    public void before(){
        fuelTank = new FuelTank(100);
        engine = new Engine(1.8, fuelTank);
        car = new Car(5, 10000, "Green", engine);
        customer = new Customer("Sheila", 50000.00);
    }
    @Test
    public void canGetCustomerName(){
        assertEquals("Sheila", customer.getName());
    }

    @Test
    public void canGetCustomerMoney(){
        assertEquals(50000.00, customer.getMoney(), 0.01);
    }

    @Test
    public void canGetVehicleCount(){
        assertEquals(0, customer.getVehicleCount());
    }

    @Test
    public void canAddCar(){
        customer.addVehicle(car);
        assertEquals(1, customer.getVehicleCount());
    }

    @Test
    public void canBuyCar(){
        customer.buyVehicle(car);
        assertEquals(1, customer.getVehicleCount());
        assertEquals(40000.00, customer.getMoney(), 0.01);
    }
}
