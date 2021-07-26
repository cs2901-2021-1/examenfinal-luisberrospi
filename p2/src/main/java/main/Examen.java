package main;

import java.util.Scanner;
import java.util.logging.Logger;

public class Examen {


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Examen.class.getName());

        var app = AppFacade.getInstance();
        String username;
        String password;
        Scanner sc= new Scanner(System.in);

        do {
            logger.info("Username");
            username = sc.nextLine();
            logger.info("Password");
             password = sc.nextLine();
        } while (Boolean.FALSE.equals(app.login(username, password)));

        String command;

        do {
            logger.info("\nIngrese comando | info | alta | baja | logout | esperar vacunados\n");
            command = sc.nextLine();


            if (command.equals("alta")) {
                logger.info("nombre del centro a dar de alta: ");
                app.addCenter(sc.nextLine());
            }
            if (command.equals("baja")) {
                logger.info("nombre del centro a dar de baja: ");
                app.deleteCenter(sc.nextLine());
            }


            if (command.equals("info")) {
                app.getInfo();
            }

            if (command.equals("esperar")) {
                app.randomVac(100000); //simulacion de vacunado cada vez que se usa un comando
            }

        } while (!command.equals("logout"));
        app.logout();
    }
}
