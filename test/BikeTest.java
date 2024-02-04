import bikeCode.Bike;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;
    @BeforeEach
    public void createBike(){
         bike = new Bike();
         bike.isOn = true;

    }

    @AfterEach
    public void turnBikeOff(){
        bike.isOn = false;
    }
    @Test
    public void turnBikeOn_ItIsOn(){
        bike.powerOn();
        assertTrue(bike.isOn);

    }

    @Test
    public void turnBikeOff_ItIsOff(){
        bike.powerOff();
        assertFalse(bike.isOn);

    }

    @Test
    public void accelerate_ItAccelerates(){
        bike.setSpeed(20);
        bike.accelerate();

        int speed = bike.getSpeed();
        assertEquals(21,speed);
    }

    @Test
    public void testAccelerate_acceleratesInIncrementOneWhenInGearOne(){
        bike.setSpeed(0);

        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed+1,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementOneWhenInGearOneAndChangesWhenExceeds20(){
        bike.setSpeed(20);
        for (int speed = 0; speed < 2; speed++) {
            bike.accelerate();
        }

        assertEquals(2,bike.getGearState());
        assertEquals(23,bike.getSpeed());

    }
    @Test
    public void testAccelerate_acceleratesInIncrementTwoWhenInGearTwoAndChangesWhenExceeds30(){
        bike.setSpeed(30);
        for (int speed = 0; speed < 2; speed++) {
            bike.accelerate();
        }

        assertEquals(3,bike.getGearState());
        assertEquals(35,bike.getSpeed());

    }

    @Test
    public void testAccelerate_acceleratesInIncrementThreeWhenInGearThreeAndChangesWhenExceeds40(){
        bike.setSpeed(40);
        for (int speed = 0; speed < 2; speed++) {
            bike.accelerate();
        }

        assertEquals(4,bike.getGearState());
        assertEquals(47,bike.getSpeed());
    }

    @Test
    public void testChangeGear(){
        bike.setSpeed(20);
        int expected = 1;

        assertEquals(expected,bike.changeGear());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementTwoWhenInGearTwo(){
        bike.setSpeed(21);
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed + 2,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementThreeWhenInGearThree(){
        bike.setSpeed(31);
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed+3,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementFourWhenInGearFour(){
        bike.setSpeed(41);
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed + 4,bike.getSpeed());
    }

    @Test
    public void testThatSpeedCantGoLowerThanZero(){
        assertThrows(IllegalArgumentException.class,()->bike.setSpeed(-5));
    }
    @Test
    public void testDecelerate_DeceleratesInDecrementOfOneWhenInGearOne(){
        bike.setSpeed(20);

        bike.decelerate();
        assertEquals(19,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfTwoWhenInGearTwo(){

        bike.setSpeed(25);

        bike.decelerate();
        assertEquals(23,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfThreeWhenInGearThree(){
        bike.setSpeed(34);

        bike.decelerate();
        assertEquals(31,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfFourWhenInGearFour(){
        bike.setSpeed(45);

        bike.decelerate();
        assertEquals(41,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementFourWhenInGearFourAndChangesWhenLowerThan40(){
        bike.setSpeed(44);
        for (int speed = 0; speed < 1; speed++) {
            bike.decelerate();
        }

        assertEquals(3,bike.getGearState());
        assertEquals(40,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementThreeWhenInGearThreeAndChangesWhenLowerThan30(){
        bike.setSpeed(32);
        for (int speed = 0; speed < 1; speed++) {
            bike.decelerate();
        }

        assertEquals(2,bike.getGearState());
        assertEquals(29,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementTwoWhenInGearTwoAndChangesWhenLowerThan20(){
        bike.setSpeed(24);
        for (int speed = 0; speed < 3; speed++) {
            bike.decelerate();
        }

        assertEquals(1,bike.getGearState());
        assertEquals(19,bike.getSpeed());
    }
}
