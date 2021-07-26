import main.Examen;
import main.AppFacade;
import main.Center;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class ExamenTest {
    @Test
    public void test0(){
        String input = "luis\nsiuw\nluis\nsiul\nalta\nutec\nesperar\ninfo\nbaja\nutec\nlogout";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Examen.main(new String[] {}); //el main "contiene" el test
    }
    @Test
    public void test1(){
        var app = AppFacade.getInstance();
        app.login("luis","luis");
        app.getUserName();
        app.getUserPassword();
        app.login("luis","siul");
        app.addCenter("utec");
        app.getInfo();
        app.deleteCenter("utec");
        app.randomVac(100000);
        app.logout();
    }
    @Test(invocationCount = 50, threadPoolSize = 20)
    public void test50Centros(){
        var app = AppFacade.getInstance();
        app.addCenter("utec");
        app.randomVac(100000); //todos los centros vacunan entre 0 y 100000 personas y lo reportan
    }
    @Test
    public void centro(){
        var centro = new Center("utec");
        centro.vacunar1(100);
        centro.vacunar2(200);

        int v1 = centro.getVacunados1();
        int v2 = centro.getVacunados2();

        Assert.assertEquals(Integer.toString(centro.getVacunados1()), "100");
        Assert.assertEquals(Integer.toString(centro.getVacunados2()), Integer.toString(200/5));
    }
    @Test
    public void testInfo(){
        long maxExecutionTime = 2000; //ms
        var app = AppFacade.getInstance();
        app.addCenter("Utec");

        long beginTime = System.currentTimeMillis();
        app.getInfo();
        long endTime = System.currentTimeMillis();

        Assert.assertTrue(endTime - beginTime < maxExecutionTime);
    }

    @Test
    public void testVacunados(){
        long maxExecutionTime = 3000; //ms
        var centro = new Center("utec");

        long beginTime = System.currentTimeMillis();
        centro.vacunar1(100);
        centro.vacunar2(100);
        long endTime = System.currentTimeMillis();

        Assert.assertTrue(endTime - beginTime < maxExecutionTime);
    }
}
