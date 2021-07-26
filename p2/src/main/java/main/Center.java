package main;

import java.util.logging.Logger;

public class Center {
    Logger logger = Logger.getLogger(Center.class.getName());
    private String name;
    private int vacunados1;
    private int vacunados2;
    public Center(String name) {

        this.name = name;
    }
    public void vacunar1(int c) {
        vacunados1 += c;
        String msg = "El centro: " + name + " ha vacunado: primera dosis a " + vacunados1 + " personas";
        logger.info(msg);
    }
    public void vacunar2(int c) {
        vacunados2 += c/5;
        String msg = "El centro: " + name + " ha vacunado: segunda dosis a " + vacunados2  + " personas";
        logger.info(msg);
    }

    public int getVacunados1() {
        return vacunados1;
    }

    public int getVacunados2() {
        return vacunados2;
    }
}
