package org.example;
import java.util.Scanner;
import java.util.logging.Logger;

class Tictac
{
    static Logger logger=Logger.getLogger("com-api-jar");
    static char[][] board;
    public Tictac()
    {
        board=new char[3][3];
        boarddesign();
    }
    void boarddesign()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
    }
    static void display()
    {
        logger.info("------------");
        for(int i=0;i<board.length;i++)
        {
            logger.info("|");
            for(int j=0;j<board[i].length;j++)
            {
                logger.info(board[i][j]+" | ");
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
        if((board[0][0]!=' '&&board[0][0]==board[1][1]&&board[1][1]==board[2][2] )||(board[0][2]!=' ' && board[0][2]==board[1][1]&&board[1][1]==board[2][0]))
        {
            return  true;
        }
        return  false;
    }

    static boolean checkdraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
class person
{
    Logger logger=Logger.getLogger("com-api-jar");
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
    public static void main(String[] args)
    {
        Logger logger=Logger.getLogger("com-api-jar");
        Tictac t=new Tictac();
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