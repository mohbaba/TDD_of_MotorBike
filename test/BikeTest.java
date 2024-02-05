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
         bike.powerOn();

    }

    @AfterEach
    public void turnBikeOff(){
        bike.powerOff();
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
        for (int speed = 0; speed < 20; speed++) {
            bike.accelerate();
        }
        bike.accelerate();

        int speed = bike.getSpeed();
        assertEquals(21,speed);
    }

    @Test
    public void testAccelerate_acceleratesInIncrementOneWhenInGearOne(){
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed+1,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementOneWhenInGearOneAndChangesWhenExceeds20(){
        for (int speed = 0; speed < 20; speed++) {
            bike.accelerate();
        }
        bike.accelerate();
        bike.accelerate();
        assertEquals(2,bike.getGearState());
        assertEquals(23,bike.getSpeed());

    }
    @Test
    public void testAccelerate_acceleratesInIncrementTwoWhenInGearTwoAndChangesWhenExceeds30(){
        for (int speed = 1; speed <= 26; speed++) {
            bike.accelerate();
        }

        assertEquals(3,bike.getGearState());
        assertEquals(31,bike.getSpeed());

    }

    @Test
    public void testAccelerate_acceleratesInIncrementThreeWhenInGearThreeAndChangesWhenExceeds40(){

        for (int speed = 1; speed <= 30; speed++) {
            bike.accelerate();
        }

        assertEquals(4,bike.getGearState());
        assertEquals(43,bike.getSpeed());
    }

    @Test
    public void testChangeGear(){
        for (int speed = 1; speed <= 20; speed++) {
            bike.accelerate();
        }
        int expected = 1;

        assertEquals(expected,bike.changeGear());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementTwoWhenInGearTwo(){
        for (int speed = 1; speed <= 21; speed++) {
            bike.accelerate();
        }
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed + 2,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementThreeWhenInGearThree(){
        for (int speed = 1; speed <= 26; speed++) {
            bike.accelerate();
        }
        int speed = bike.getSpeed();
        bike.accelerate();
        assertEquals(speed+3,bike.getSpeed());
    }

    @Test
    public void testAccelerate_acceleratesInIncrementFourWhenInGearFour(){
        for (int speed = 1; speed <= 30; speed++) {
            bike.accelerate();
        }
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
        for (int speed = 1; speed <= 20; speed++) {
            bike.accelerate();
        }

        bike.decelerate();
        assertEquals(19,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfTwoWhenInGearTwo(){

        for (int speed = 1; speed <= 23; speed++) {
            bike.accelerate();
        }

        bike.decelerate();
        assertEquals(23,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfThreeWhenInGearThree(){
        for (int speed = 1; speed <= 27; speed++) {
            bike.accelerate();
        }

        bike.decelerate();
        assertEquals(31,bike.getSpeed());
    }

    @Test
    public void testDecelerate_DeceleratesInDecrementOfFourWhenInGearFour(){
        for (int speed = 1; speed <= 31; speed++) {
            bike.accelerate();
        }

        bike.decelerate();
        assertEquals(43,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementFourWhenInGearFourAndChangesWhenLowerThan40(){
        for (int speed = 1; speed <= 30; speed++) {
            bike.accelerate();
        }
        for (int speed = 0; speed < 1; speed++) {
            bike.decelerate();
        }

        assertEquals(3,bike.getGearState());
        assertEquals(39,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementThreeWhenInGearThreeAndChangesWhenLowerThan30(){
        for (int speed = 1; speed <= 26; speed++) {
            bike.accelerate();
        }
        for (int speed = 0; speed < 1; speed++) {
            bike.decelerate();
        }

        assertEquals(2,bike.getGearState());
        assertEquals(28,bike.getSpeed());
    }

    @Test
    public void testDecelerate_deceleratesInDecrementTwoWhenInGearTwoAndChangesWhenLowerThan20(){
        for (int speed = 1; speed <= 21; speed++) {
            bike.accelerate();
        }
        for (int speed = 0; speed < 1; speed++) {
            bike.decelerate();
        }

        assertEquals(1,bike.getGearState());
        assertEquals(19,bike.getSpeed());
    }
}
