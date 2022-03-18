package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import core.CheckersLogic;
import core.CheckersComputerPlayer;
/**
 * CheckersTest is a JUnit test application for CheckersLogic and CheckersComputerPlayer classes
 *
 * @author Steven Kosanke, skosanke
 * @version 2/20/2022
 */
public class NewEmptyJUnitTest { 
    CheckersComputerPlayer comp;
    CheckersLogic computergame;
    CheckersLogic testA;
    CheckersLogic testB;
    
        String nonmoveX1; String nonmoveO1;
        String nonmoveX2; String nonmoveO2;
        String nonmoveX3; String nonmoveO3;
        
        String moveX1; String moveO1;
        String moveX2; String moveO2;
        String moveX3; String moveO3;
        String moveX4; String moveO4;
        String moveX5; String moveO5;
        String moveX6; String moveO6;
        String moveX7; 

        //Moves for computer game
        String X1; String compO1;
        String X2; String compO2;
        String X3; String compO3;
        String X4; String compO4;
        String X5; String compO5;
        String X6 ;

    
    public NewEmptyJUnitTest() {
        setUpClass();
        getTurn();
        move();
        displayGame();
        winCheck();
        getNextMove();      
        tearDownClass();
        
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() {
        testA = new CheckersLogic();
        testB = new CheckersLogic();
        nonmoveX1 = "3h-4g"; nonmoveO1="3a-4b";
        nonmoveX2 = "hello";nonmoveO2="6d5c";
        nonmoveX3 = "6h-5g"; nonmoveO3="1c-2d";
        
        moveX1 = "3a-4b"; moveO1 = "6d-5c";
        moveX2 = "4b-6d"; moveO2 = "6f-5e";
        moveX3 = "3c-4b"; moveO3 = "";
        moveX4 = "3c-4b"; moveO4 = "7e-3a";
        moveX5 = "2d-3c"; moveO5 = "5e-4d";
        moveX6 = "3g-4f"; moveO6 = "7g-6f";
        moveX7 = "3c-7g";

        //Moves for computer game
        X1 = "3a-4b"; compO1 = "6h-5g";
        X2 = "3g-4h"; compO2 = "5g-4f";
        X3 = "2f-3g"; compO3 = "6f-5e";
        X4 = "3e-5g"; compO4 = "5e-4d";
        X5 = "2d-3e"; compO5 = "4d-2f";
        X6 = "4b-5c"; 

    
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() {
    CheckersComputerPlayer comp=null;
    CheckersLogic computergame=null;
    CheckersLogic testA=null;
    CheckersLogic testB=null;
        
         String nonmoveX1=null; String nonmoveO1=null;
        String nonmoveX2=null; String nonmoveO2=null;
        String nonmoveX3=null; String nonmoveO3=null;
        
        String moveX1 =null; String moveO1=null;
        String moveX2=null; String moveO2=null;
        String moveX3=null; String moveO3=null;
        String moveX4=null; String moveO4=null;
        String moveX5=null; String moveO5=null;
        String moveX6=null; String moveO6=null;
        String moveX7=null;

        //Moves for computer game
        String X1=null; String compO1=null;
        String X2=null; String compO2=null;
        String X3=null; String compO3=null;
        String X4=null; String compO4=null;
        String X5 =null; String compO5=null;
        String X6=null; 
        
    }
    

    @Test
    public void getTurn() {  
        testA.move(moveX1);
        //Cases should pass
        assertTrue(testA.getTurn().equals("O"));
        assertTrue(testB.getTurn().equals("X"));
        
        //Cases should fail
        assertFalse(testB.getTurn().equals("O"));
        assertFalse(testA.getTurn().equals("X"));
    }
    
    @Test
    public void move() {
        //Cases should fail
        assertTrue(testB.move(nonmoveX1)==0);
        assertTrue(testB.move(nonmoveX2)==0);
        assertTrue(testA.move(nonmoveO1)==0);
        assertTrue(testA.move(nonmoveO2)==0);
        
        //Cases should pass
        assertTrue(testA.move(moveO1) == 1);  
        assertTrue(testA.move(moveX2) == 1); 
        assertTrue(testA.move(moveO2) == 1); 
        assertTrue(testA.move(moveX3) == 1); 
        assertTrue(testA.move(moveO3) == 1);
        assertTrue(testA.move(moveX4) == 1); 
        assertTrue(testA.move(moveO4) == 1);
        assertTrue(testA.move(moveX5) == 1); 
        assertTrue(testA.move(moveO5) == 1);
        assertTrue(testA.move(moveX6) == 1); 
        assertTrue(testA.move(moveO6) == 1);
        assertTrue(testA.move(moveX6) == 1);                   
    }
    
    @Test
    public void displayGame() {
        //Cases should pass
        assertTrue(testA.displayGame().equals(testA.displayGame())); 
        assertTrue(testB.displayGame().equals(testB.displayGame()));
        
        //Cases should fail
        assertFalse(testA.displayGame().equals(testB.displayGame())); 
        assertFalse(testB.displayGame().equals(testA.displayGame()));
    }
    
    @Test
    public void winCheck() {
        //Cases should pass
        assertTrue(testA.winCheck() ==0);
        assertTrue(testB.winCheck() ==0);
        
        //Cases should pass
        assertFalse(testA.winCheck() ==1);
        assertFalse(testB.winCheck() ==1);        
    }
    
//END OF TESTS FOR CHECKERSLOGIC CLASS
    
   //TEST THE COMPUTER PLAYER
   @Test
   public void getNextMove() {
       computergame = new CheckersLogic();
       computergame.move(X1);
       comp = new CheckersComputerPlayer(computergame);
       assertTrue(comp.getNextMove().equals(compO1));
       computergame.move(compO1);
       computergame.move(X2);
       
       assertTrue(comp.getNextMove().equals(compO2));
       computergame.move(compO2);
       computergame.move(X3);
       
       assertTrue(comp.getNextMove().equals(compO3));
       computergame.move(compO3);
       computergame.move(X4);
       
       assertTrue(comp.getNextMove().equals(compO4));
       computergame.move(compO4);
       computergame.move(X5);
       
       assertTrue(comp.getNextMove().equals(compO5));
       computergame.move(compO5);
       computergame.move(X6);
   }
    
}
