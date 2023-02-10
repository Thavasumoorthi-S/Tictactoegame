package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

class Tictac
{
    private static final Logger logger=Logger.getLogger("com-api-jar");
    static char[][] board;
    Tictac()
    {
        board=new char[3][3];
    }


    void boarddesign()
    {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }
    static void display()
    {
        logger.info("------------");
        for (char[] chars : board) {
            logger.info("|");
            for (char aChar : chars) {
                logger.info(aChar + " | ");
            }
            logger.info("\n");
            logger.info("------------");
        }
    }
    static void putsymbol(int row,int col,char symbol)
    {
        board[row][col]=symbol;
    }
    static boolean verticalcheck()
    {
        for(int j=0;j<=2;j++)
        {
            if(board[0][j]!=' '&&board[0][j]==board[1][j]&&board[1][j]==board[2][j])
            {
                return true;
            }
        }
        return  false;
    }

   static boolean horizontalcheck()
    {
        for(int i=0;i<=2;i++)
        {
            if(board[i][0]!=' '&&board[i][0]==board[i][1]&&board[i][1]==board[i][2])
            {
                return  true;
            }
        }
        return  false;
    }

    static boolean diagonalcheck()
    {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    static boolean checkdraw() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
class person
{
    private static final Logger logger=Logger.getLogger("com-api-jar");
    String name;
    char symbol;

    person(String name,char symbol)
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
            if(Tictac.board[row][col]==' ')
            {
                return true;
            }
        }
        logger.info("This row and Column is already played please choose another ");
        return false;
    }
}

public class Game
{
    private static final Logger logger=Logger.getLogger("com-api-jar");
    public static void main(String[] args)
    {
        Tictac t=new Tictac();
        t.boarddesign();
        person p1=new person("THAVASU",'X');
        person p2=new person("MOORTHI",'O');
        person c;
        c=p1;
        while (true)
        {
            logger.info(c.name+" is playing.......");
            c.move1();
            Tictac.display();
            if(Tictac.horizontalcheck()||Tictac.verticalcheck()||Tictac.diagonalcheck())
            {
                logger.info(c.name+" is win the game");
                logger.info("congratulation "+c.name);
                break;
            }
            else if(Tictac.checkdraw())
            {
                logger.info("Game is draw");
                logger.info("play again");
                break;
            }
            else
            {
                if(c==p1)
                {
                    c=p2;
                }
                else
                {
                    c=p1;
                }
            }
        }
    }
}