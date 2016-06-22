
import java.io.FileNotFoundException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class Pie
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length > 0)
        {
            GroupBy grouper = new GroupBy();
            ParseFile parser = new ParseFile();
            grouper.setData(parser.load(args[0]));
            grouper.groupby(GroupBy.BY_SECTOR);
            
            //Implement the pie chart
            JFrame frame = new JFrame();
            PieChart l_graph = new PieChart(grouper.groups);
            frame.getContentPane().add(l_graph);
            frame.pack();
            frame.repaint();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
        }
        else
        {
            System.out.println("Not enough command-line arguments.");
        }
    }
}
