package org.example;
import org.example.Tictac;
import org.example.Person;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Games
{
    private static final Logger logger=Logger.getLogger(Tictac.API);
    public static void main(String[] args)
    {
        Tictac t=new Tictac();
        t.boarddesign();
        Person p1=new Person("THAVASU",'X');
        Person p2=new Person("MOORTHI",'O');
        Person c;
        c=p1;
        while (true)
        {
            String names=c.name;
            logger.log(Level.INFO,()->names+" is playing.......");
            c.move1();
            Tictac.display();
            if(Tictac.horizontalcheck()||Tictac.verticalcheck()||Tictac.diagonalcheck())
            {
                String name;
                name=c.name;
                logger.log(Level.INFO,()->name+" is win the game");
                logger.log(Level.INFO,()->"congratulation "+name);
                break;
            }
            else if(Tictac.checkdraw())
            {
                logger.info("Game is draw");
                logger.info("play again");
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