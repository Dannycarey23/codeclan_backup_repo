import components.Engine;
import components.FuelTank;
import components.Till;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import people.DealerShip;
import vehicles.Car;

import static org.junit.Assert.assertEquals;

public class DealerShipTest {
    DealerShip dealerShip;
    Customer customer;
    Car car;
    Engine engine;
    FuelTank fuelTank;
    Till till;

    @Before
    public void before(){
        till = new Till(50000.00);
        dealerShip = new DealerShip("Bob", till);
        customer = new Customer("Sheila", 50000.00);
        fuelTank = new FuelTank(100);
        engine = new Engine(1.8, fuelTank);
        car = new Car(5, 10000, "Green", engine);

    }
    @Test
    public void canGetDealerName(){
        assertEquals("Bob", dealerShip.getName());
    }

    @Test
    public void canGetDealerMoney(){
        assertEquals(50000.00, dealerShip.getTillBalance(), 0.01);
    }

    @Test
    public void sellingCarIncreaseDealerMoney(){
        dealerShip.sellCar(car,customer);
        assertEquals(60000.00, dealerShip.getTillBalance(), 0.01);
    }

    @Test
    public void dealerCanBuyCar(){
        dealerShip.buyCar(car);
        assertEquals(1, dealerShip.vehicleCount());
        assertEquals(40000.00, dealerShip.getTillBalance(), 0.1);
    }

    @Test
    public void canRepairCar(){
        car.addDamage(5000.00);
        dealerShip.repairVehicle(5000.00, car);
        assertEquals(45000.00, dealerShip.getTillBalance(), 0.1);
        assertEquals(10000.00, car.getPrice(), 0.1);
    }
}
