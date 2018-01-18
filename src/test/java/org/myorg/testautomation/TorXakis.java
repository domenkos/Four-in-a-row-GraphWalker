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
public class TorXakis {

    public int turns = 0;
    public boolean secondPath = false;

    private static WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private long sleep = 230; //miliseconds
    private PrintWriter sockout;

    private void sleep()throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(this.sleep);
    }

    String startingColor = "red"; // either "c4fillred.gif" or "c4fillblu.gif"
    String player2Color = "blu"; // the opposite of above

    String playersTurn;
    String playerOne;

    public boolean checkPlayer1Color(String s){
        if(s.contains(startingColor)){
            return  true;
        }
        return  false;
    }

    public String coin_3_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[3]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_3_7_r");
            return "Coin_3_7_r";

        }else{
            return "Fail";
        }
    }

    public String coin_2_5_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[6]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_2_5_r");

            return "Coin_2_5_r";
        }else{
            return "Fail";
        }
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
        this.playerOne = "Player 1";
        this.startingColor = this.playersTurn.contains("1") ? "red" : "blu";
        this.player2Color = this.startingColor.equals("red") ? "blu" : "red";
    }

    public void throwCoin(int row){

    }

    public void throw_2_7_r() {

        secondPath = true;

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[2]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }

        switch (turns){
            case 0:
                sockout.print(coin_2_7_r()+"\n");
                sockout.flush();
                break;
            case 2:
                sockout.print(coin_2_5_r()+"\n");
                sockout.flush();
                break;
            case 4:
                sockout.print(coin_2_3_r()+"\n");
                sockout.flush();
                break;
        }
    }

    public void restart_game() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/input[2]")).click();
        sleep();
        sleep();
        driver.findElement(By.xpath("//*[@id=\"formo\"]/div[1]/input[1]")).click();
        sleep();
        determineColour();
        //System.out.println("Resp: New_Game");
        //sockout.print("New_game\n");
        //sockout.flush();
        turns = 0;
        secondPath = false;
    }

    public void throw_3_7_r() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[3]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }

    }

    public String coin_2_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_2_7_r");

            return "Coin_2_7_r";
        }else{
            return "Fail";
        }
    }

    public void throw_5_7_r() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[5]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }
    }

    public String coin_2_3_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[4]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_2_3_r");

            return "Coin_2_3_r";
        }else{
            return "Fail";
        }
    }

    public String coin_6_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[6]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_6_7_r");
            return "Coin_6_7_r";
        }else{
            return "Fail";
        }
    }

    public void throw_7_7_r() {

        driver.findElement(By.xpath("//html/body/div[2]/div[2]/a[7]/img")).click();
        try{
        sleep();
        } catch (InterruptedException e) { }
    }

    public void throw_1_7_r(){

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[1]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }

        switch (turns){
            case 0:
                sockout.print(coin_1_7_r()+"\n");
                sockout.flush();
                break;
            case 2:
                sockout.print(coin_1_6_r()+"\n");
                sockout.flush();
                break;
            case 4:
                sockout.print(coin_1_5_r()+"\n");
                sockout.flush();
                break;
            case 6:
                sockout.print(winner_r()+"\n");
                sockout.flush();
                break;
        }
    }

    public String coin_4_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[4]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Resp: Coin_4_7_r");
            return "Coin_4_7_r";
        }else{
            return "Fail";
        }
    }

    public void throw_6_7_r() {

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[6]/img")).click();
        try{
            this.sleep();
        }catch (InterruptedException e) { }
    }

    public void throw_2_7_b() {

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[2]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }

        if(secondPath){
            switch (turns){
                case 1:
                    sockout.print(coin_2_6_b()+"\n");
                    sockout.flush();
                    break;
                case 3:
                    sockout.print(coin_2_4_b()+"\n");
                    sockout.flush();
                    break;
                case 5:
                    sockout.print(coin_2_2_b()+"\n");
                    sockout.flush();
                    break;
            }
        }else{
            switch (turns){
                case 1:
                    sockout.print(coin_2_7_b()+"\n");
                    sockout.flush();
                    break;
                case 3:
                    sockout.print(coin_2_6_b()+"\n");
                    sockout.flush();
                    break;
                case 5:
                    sockout.print(coin_2_5_b()+"\n");
                    sockout.flush();
                    break;
            }
        }
    }

    public String coin_1_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[1]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Resp: Coin_1_7_r");

            return "Coin_1_7_r";
        }else{
            return "Fail";
        }
    }

    public String coin_2_4_b() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[5]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Resp: Coin_2_4_b");
            return "Coin_2_4_b";
        }else{
            return "Fail";
        }
    }

    public String coin_2_5_b() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[6]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            return "Coin_2_5_b";
        }else{
            return "Fail";
        }
    }

    public String coin_2_6_b() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[7]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            return "Coin_2_6_b";
        }else{
            return "Fail";
        }
    }

    public String coin_1_5_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[6]/a[1]/img")).getAttribute("src");
        System.out.println(s);
        if(checkPlayer1Color(s)){
            return "Coin_1_5_r";
        }else{
            return "Fail";
        }
    }

    public String coin_2_7_b() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            return "Coin_2_7_b";
        }else{
            return "Fail";
        }
    }

    public String coin_1_6_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[7]/a[1]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            return "Coin_1_6_r";
        }else{
            return "Fail";
        }
    }

    public void throw_4_7_r() {

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/a[4]/img")).click();
        try{ this.sleep();}
        catch (InterruptedException e) { }
    }

    public String coin_5_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[5]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_5_7_r");
            return "Coin_5_7_r";
        }else{
            return "Fail";
        }
    }

    public String winner_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[5]/a[1]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            try{
                this.sleep();
                driver.switchTo().alert().accept();
            } catch (InterruptedException e) { }
            return "Winner_r";
        }else{
            try{
                this.sleep();
                driver.switchTo().alert().accept();
            } catch (InterruptedException e) { }
            return "Fail";
        }
    }

    public String coin_2_2_b() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[3]/a[2]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            return "Coin_2_2_b";
        }else{
            return "Fail";
        }
    }

    public String coin_7_7_r() {
        String s = driver.findElement(By.xpath("/html/body/div[2]/div[8]/a[7]/img")).getAttribute("src");
        if(checkPlayer1Color(s)){
            System.out.println("Coin_7_7_r");
            return "Coin_7_7_r";
        }else{
            return "Fail";
        }
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
            case "Throw_1_7_r":
                throw_1_7_r();
                break;
            case "Throw_2_7_r":
                throw_2_7_r();
                break;
            case "Throw_3_7_r":
                throw_3_7_r();
                sockout.print(coin_3_7_r()+"\n");
                sockout.flush();
                break;
            case "Throw_4_7_r":
                throw_4_7_r();
                sockout.print(coin_4_7_r()+"\n");
                sockout.flush();
                break;
            case "Throw_5_7_r":
                throw_5_7_r();
                sockout.print(coin_5_7_r()+"\n");
                sockout.flush();
                break;
            case "Throw_6_7_r":
                throw_6_7_r();
                sockout.print(coin_6_7_r()+"\n");
                sockout.flush();
                break;
            case "Throw_7_7_r":
                throw_7_7_r();
                sockout.print(coin_7_7_r()+"\n");
                sockout.flush();
                break;
            case "Throw_2_7_b":
                throw_2_7_b();
                break;
        }
        turns++;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("program started");
        TorXakis tx = new TorXakis();
        tx.init();
        tx.readSocket();
    }
}
