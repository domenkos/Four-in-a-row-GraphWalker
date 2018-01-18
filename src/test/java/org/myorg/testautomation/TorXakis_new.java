package org.myorg.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Created by Musdey on 07.01.2018.
 */
public class TorXakis_new {

    private boolean playerOneTurn = true;
    private boolean firstPlayerPlayedLast = false;

    private static WebDriver driver;
    private String baseUrl;
    private long sleep = 230; //miliseconds
    private PrintWriter sockout;

    private void sleep()throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(this.sleep);
    }

    String startingColor = "red"; // either "c4fillred.gif" or "c4fillblu.gif"
    String player2Color = "blu"; // the opposite of above

    String playersTurn;

    public boolean checkPlayer1Color(String s){
        if(s.contains(startingColor)){
            return  true;
        }
        return  false;
    }



    public void init() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.mathsisfun.com/";
        driver.get(baseUrl + "/games/connect4.html");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"formo\"]/div[5]/select")));
        select.selectByVisibleText("Human");

        driver.findElement((By.xpath("//*[@id=\"formo\"]/div[4]/input"))).clear();
        driver.findElement((By.xpath("//*[@id=\"formo\"]/div[4]/input"))).sendKeys("Player 1");
        driver.findElement((By.xpath("//*[@id=\"formo\"]/div[6]/input"))).clear();
        driver.findElement((By.xpath("//*[@id=\"formo\"]/div[6]/input"))).sendKeys("Player 2");

        driver.findElement(By.xpath("//*[@id=\"formo\"]/div[1]/input[1]")).click();
        determineColour();
        sleep();
    }

    public void determineColour() {
        this.playersTurn = driver.findElement((By.xpath("//*[@id=\"texter\"]"))).getAttribute("value");
        this.startingColor = this.playersTurn.contains("1") ? "red" : "blu";
        this.player2Color = this.startingColor.equals("red") ? "blu" : "red";
        if(startingColor.contains("1")){
            playerOneTurn =true;
        }else{
            playerOneTurn = false;
        }
    }


    private void checkChanges(){
        String text = driver.findElement((By.xpath("//*[@id=\"texter\"]"))).getAttribute("value");
        if(text.contains("wins")){
            if(text.contains("1")){
                sockout.print("WinP1\n");
                System.out.println("player 1 wins");

                sockout.flush();
            }else{
                System.out.println("player 2 wins");
                sockout.print("WinP2\n");
                sockout.flush();
            }
            return;
        }

        if(text.contains("draw")){
            sockout.print("Draw\n");
            sockout.flush();
            return;
        }

        if(firstPlayerPlayedLast){
            if(text.contains("1")){
                sockout.print("Fail\n");
                sockout.flush();
            }else{
                sockout.print("Ok\n");
                sockout.flush();
            }
        }else{
            if(text.contains("2")){
                sockout.print("Fail\n");
                sockout.flush();
            }else{
                sockout.print("Ok\n");
                sockout.flush();
            }
        }
    }


    public void throwCoin(int row){

        String text = driver.findElement((By.xpath("//*[@id=\"texter\"]"))).getAttribute("value");
        if(text.contains("1")){
            firstPlayerPlayedLast = true;
        }else{
            firstPlayerPlayedLast = false;
        }

        switch (row){
            case 1:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[1]/img")).click();
                break;
            case 2:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[2]/img")).click();
                break;
            case 3:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[3]/img")).click();
                break;
            case 4:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[4]/img")).click();
                break;
            case 5:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[5]/img")).click();
                break;
            case 6:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[6]/img")).click();
                break;
            case 7:
                driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[7]/img")).click();
                break;
        }

        checkChanges();
    }

    public void restart_game() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/input[2]")).click();
        sleep();
        sleep();
        driver.findElement(By.xpath("//*[@id=\"formo\"]/div[1]/input[1]")).click();
        sleep();
        determineColour();
    }

    public void readSocket(){

        try
        {   //int portNo = Integer.parseInt(args[0]);
            // instantiate a socket for accepting a connection
            ServerSocket servsock = new ServerSocket(7890);
            // wait to accept a connection request and a data socket is returned
            Socket sock = servsock.accept();
            // get an input stream for reading from the data socket
            InputStream inStream = sock.getInputStream();
            // create a BufferedReader object for text line input
            BufferedReader sockin = new BufferedReader(new InputStreamReader(inStream));
            // get an output stream for writing to the data socket
            OutputStream outStream = sock.getOutputStream();
            // create a PrinterWriter object for character-mode output
            sockout = new PrintWriter(new OutputStreamWriter(outStream));
            // read a line from the data stream: the stimulus

            while(true) {
                String s = sockin.readLine();
                doAction(s);
                // send a line to the data stream: the response
                // TorXakis targets embedded systems and servers that typically don't terminate
                //TimeUnit.SECONDS.sleep(10);
            }
        }
        catch (Exception ex) { ex.printStackTrace(); }
    }

    public void doAction(String s) throws InterruptedException {
        System.out.println(s);
        switch (s){
            case "Restart_Game":
                restart_game();
                break;
            case "Throw_1":
                throwCoin(1);
                break;
            case "Throw_2":
                throwCoin(2);
                break;
            case "Throw_3":
                throwCoin(3);
                break;
            case "Throw_4":
                throwCoin(4);
                break;
            case "Throw_5":
                throwCoin(5);
                break;
            case "Throw_6":
                throwCoin(6);
                break;
            case "Throw_7":
                throwCoin(7);
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("program started");
        TorXakis_new tx = new TorXakis_new();
        tx.init();
        tx.readSocket();
    }
}
