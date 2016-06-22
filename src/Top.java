
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class Top
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length > 2)
        {
            GroupBy grouper = new GroupBy();
            ParseFile parser = new ParseFile();
            grouper.setData(parser.load(args[0]));
            switch(args[2])
            {
                case "sectors":
                    grouper.groupby(IGroupBy.BY_SECTOR);
                    break;
                case "employers":
                    grouper.groupby(IGroupBy.BY_EMPLOYER);
                    break;
                case "positions":
                    grouper.groupby(IGroupBy.BY_POSITION);
                    break;
                case "names":
                    grouper.groupby(IGroupBy.BY_NAME);
                    break;
            }
            grouper.printTopK(Integer.parseInt(args[1]));
        }
        else
        {
            System.out.println("Not enough command-line arguments.");
        }
    }
}
