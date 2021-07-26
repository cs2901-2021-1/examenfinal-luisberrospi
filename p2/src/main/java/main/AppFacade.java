package main;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class AppFacade {

    Random rand = new Random();

    private static AppFacade instance = null;
    HashMap<String, Center> centers = new HashMap<>();
    int nCenters = 0;
    static final long TOTAL = 22935533;
    private String userName;
    private String userPassword;

    Logger logger = Logger.getLogger(AppFacade.class.getName());


    public static AppFacade getInstance() {
        if (instance == null) {
            instance = new AppFacade();
        }
        return instance;
    }

    public Boolean login(String name, String password){
        StringBuilder reversedName = new StringBuilder(name);
        reversedName.reverse();
        if (password.equals(reversedName.toString())) {
            logger.info("Bienvenido");
            this.userName =name;
            this.userPassword =password;
            return true;
        } else {
            logger.info("Error, vuelva a ingresar");
            return false;
        }
    }

    public void logout() {
        logger.info("Vuelva pronto");
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void addCenter(String name) {
        var newCenter = new Center(name);
        centers.put(name, newCenter);
        nCenters++;
    }

    public void deleteCenter(String name) {
        centers.remove(name);
        nCenters--;
    }

    public void randomVac(int c){ //simula vacunacion de n personas en un centro primera dosis
        for (var center : centers.entrySet()) {
            center.getValue().vacunar1(rand.nextInt(c));
            center.getValue().vacunar2(rand.nextInt(c));

        }
    }

    public void getInfo(){

        int total1 = 0;
        int total2 = 0;
        for (var center : centers.entrySet()) {
            total1 += center.getValue().getVacunados1();
            total2 += center.getValue().getVacunados2();
        }

        double dtotal1 = total1;
        double dtotal2 = total2;
        String avance1 = "Avance de la vacunacion %: " +  dtotal1/TOTAL*100;
        logger.info(avance1);
        String avance2 = "Cobertura de la vacunacion %: " +  dtotal2/TOTAL*100;
        logger.info(avance2);
        String avance = "Centros de  vacunacion: " +  nCenters;
        logger.info(avance);
        String cPar = "Número de personas vacunadas parcialmente: " +  total1;
        logger.info(cPar);
        String cCom = "Número de personas vacunadas Totalmente: " +  total2;
        logger.info(cCom);
    }
}
