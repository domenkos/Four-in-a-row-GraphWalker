package org.myorg.testautomation;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

//@GraphWalker(value = "random(edge_coverage(100))", start = "change_to_human")


class MyException extends RuntimeException{
    MyException(String msg){
        super("Wrong color coin: " + msg);
    }
}

public class SimpleTest extends ExecutionContext implements four_in_a_row_4 {

    public final static Path MODEL_PATH = Paths.get("org/myorg/testautomation/four_in_a_row_4.graphml");

    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private long sleep = 230; //miliseconds

    private void sleep()throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(this.sleep);
    }


    String startingColor = "red"; // either "c4fillred.gif" or "c4fillblu.gif"
    String player2Color = "blue"; // the opposite of above

    String playersTurn;
    String playerOne;
    public boolean checkPlayer1Color(String s){
        if(s.contains(startingColor)){
            return  true;
        }
        return  false;
    }

    public boolean checkPlayer2Color(String s){
        if(s.contains(player2Color)){
            return  true;
        }
        return  false;
    }





    @Override
    public void coin_3_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[3]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_3_7_r");
    }

    @Override
    public void coin_2_5_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_2_5_r");
    }

    @Override
    public void change_to_human() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.mathsisfun.com/";
        driver.get(baseUrl + "/games/connect4.html");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));

        Select select = new Select(driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[9]/td[2]/select")));
        //select.deselectAll();
        select.selectByVisibleText("Human");

        driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input"))).clear();
        driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input"))).sendKeys("Automatic tester 1");
        driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[10]/td[2]/input"))).clear();
        driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[10]/td[2]/input"))).sendKeys("Automatic tester 2");

        this.restart_game();
        this.restart_game();

    }

    @Override
    public void new_game() {
        this.playersTurn = driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/input"))).getAttribute("value");
        this.playerOne = driver.findElement((By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input"))).getAttribute("value");

        this.startingColor = this.playersTurn.contains("1") ? "c4fillred.gif" : "c4fillblue.gif";
        this.player2Color = this.startingColor.equals("c4fillred.gif") ? "c4fillblue.gif" : "c4fillred.gif";
    }

    @Override
    public void throw_2_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/a")).click();
    }

    @Override
    public void restart_game() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[1]/table/tbody/tr[2]/td/input")).click();
        System.out.println("Game restart");
    }

    @Override
    public void throw_3_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/a")).click();

    }

    @Override
    public void coin_2_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_2_7_r");
    }

    @Override
    public void throw_5_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[5]/a")).click();
    }

    @Override
    public void coin_2_3_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_2_3_r");
    }

    @Override
    public void coin_6_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[6]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_6_7_r");
    }

    @Override
    public void throw_7_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[7]/a")).click();
    }

    @Override
    public void throw_1_7_r(){
        try{ this.sleep();}
        catch (InterruptedException e) { }
        System.out.println("rdec");
        //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/a")).click();
    }

    @Override
    public void coin_4_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[4]/a/img")).getAttribute("src");
        //if(!checkPlayer1Color(s)) throw new MyException("coin_4_7_r");
    }

    @Override
    public void throw_6_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[6]/a")).click();
    }

    @Override
    public void throw_2_7_b() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/a")).click();
        System.out.println("modr");
    }

    @Override
    public void coin_1_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[1]/a/img")).getAttribute("src");
        System.out.println(s);
        //if(!checkPlayer1Color(s)) throw new MyException("coin_1_7_r");
    }

    @Override
    public void coin_2_4_b() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/a/img")).getAttribute("src");
        //if(!checkPlayer2Color(s)) throw new MyException("coin_2_4_b");
    }

    @Override
    public void coin_2_5_b() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/a/img")).getAttribute("src");
//        if(!checkPlayer2Color(s)) throw new MyException("coin_2_5_b");
    }

    @Override
    public void coin_2_6_b() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/a/img")).getAttribute("src");
  //      if(!checkPlayer2Color(s)) throw new MyException("coin_2_6_b");
    }

    @Override
    public void coin_1_5_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[1]/a/img")).getAttribute("src");
        System.out.println(s);
     //   if(!checkPlayer1Color(s)) throw new MyException("coin_1_5_r");
    }

    @Override
    public void coin_2_7_b() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/a/img")).getAttribute("src");
    //    if(!checkPlayer2Color(s)) throw new MyException("coin_2_7_b");
    }

    @Override
    public void coin_1_6_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]/a/img")).getAttribute("src");
     //   if(!checkPlayer1Color(s)) throw new MyException("coin_1_6_r");
    }

    @Override
    public void throw_4_7_r() {
        try{ this.sleep();}
        catch (InterruptedException e) { }
        driver.findElement(By.xpath("//form[@id='formo']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[4]/a")).click();
    }

    @Override
    public void coin_5_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[5]/a/img")).getAttribute("src");
       // if(!checkPlayer1Color(s)) throw new MyException("coin_5_7_r");
    }

    @Override
    public void winner_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/a/img")).getAttribute("src");
        checkPlayer1Color(s);
        try{
            this.sleep();
            driver.switchTo().alert().accept();
        }
        catch (InterruptedException e) { }

    }

    @Override
    public void coin_2_2_b() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a/img")).getAttribute("src");
//        if(!checkPlayer2Color(s)) throw new MyException("coin_2_2_b");
    }

    @Override
    public void coin_7_7_r() {
        String s = driver.findElement(By.xpath("//*[@id=\"formo\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[7]/a/img")).getAttribute("src");
//        if(!checkPlayer1Color(s)) throw new MyException("coin_7_7_r");
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new SimpleTest())
                .setPathGenerator(new RandomPath(new EdgeCoverage(1000)))
                .setStart("change_to_human")
                .execute();
    }

    @Test
    public void runSmokeTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new SimpleTest())
                .setPathGenerator(new AStarPath(new ReachedVertex("winner_r")))
                .setStart("change_to_human")
                .execute();

    }

    @After
    public void after() throws Exception{
        //driver.quit();
        System.out.println("Quit the tests");
    }
}
