package org.example;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class Tictac
{
    static final String API="com-api-jar";
    private static final Logger logger=Logger.getLogger(API);
    static char[][] board=new char[3][3];

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
                logger.log(Level.INFO,()->aChar + " | ");
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