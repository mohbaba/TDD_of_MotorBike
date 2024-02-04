package bikeCode;

public class Bike {
    public boolean isOn;
    private int speed;
    private int gearState;


    public void powerOn() {
        isOn = true;
    }

    public void powerOff() {
        isOn = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed){
        if (speed < 0) {
            throw new IllegalArgumentException("Exceeded speed limit!");
        }

        this.speed = speed;
    }

    public void accelerate() {
        if (isOn) {
            gearState = changeGear();
            if (gearState == 1) {
                setSpeed(getSpeed() + 1);
            } else if (gearState == 2) {
                setSpeed(getSpeed() + 2);
            } else if (gearState == 3) {
                setSpeed(getSpeed() + 3);
            } else if (gearState  == 4) {
                setSpeed(getSpeed() + 4);
            }
        }


    }

    public int changeGear(){
        if (getSpeed() >= 0 && getSpeed() <= 20) {
            return 1;
        } else if (getSpeed() >= 21 && getSpeed() <= 30) {
            return 2;
        } else if (getSpeed() >= 31 && getSpeed() <= 40) {
            return 3;

        } else if (getSpeed() >= 41) {
            return 4;
        }
        return 1;
    }

    public int getGearState() {
        return changeGear()  ;
    }

    public void decelerate() {
        if (isOn ) {
            gearState = changeGear();
            if (gearState == 1) {
                setSpeed(getSpeed() - 1);
            } else if (gearState == 2) {
                setSpeed(getSpeed() - 2);
            } else if (gearState == 3) {
                setSpeed(getSpeed() - 3);
            } else if (gearState == 4) {
                setSpeed(getSpeed() - 4);
            }
        }

    }
}
