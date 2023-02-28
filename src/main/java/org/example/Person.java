package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
class Person
{
    private static final Logger logger=Logger.getLogger(Tictac.API);
    String name;
    char symbol;

    Person(String name,char symbol)
    {
        this.name=name;
        this.symbol=symbol;
    }
    void move1()
    {
        Scanner sc=new Scanner(System.in);
        int row;
        int col;
        do {
            logger.info("Enter the row");
            row=sc.nextInt();
            logger.info("Enter the col");
            col=sc.nextInt();
        }while(!move2(row,col));

        Tictac.putsymbol(row,col,symbol);
    }
    boolean move2(int row,int col)
    {
        if(row>=0 &&row<=2 && col>=0 && col<=2)
        {
            return Tictac.board[row][col] == ' ';
        }
        logger.info("This row and Column is already played please choose another ");
        return false;
    }
}
