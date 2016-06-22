
import java.io.FileNotFoundException;
import java.util.*;
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
public class His
{
    static double LERP(double v1, double v2, double dt)
    {
        return ((1.0 - dt) * v1) + ((dt) * v2);
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length > 0)
        {
            List<Record> records;
            ParseFile parser = new ParseFile();
            records = new ArrayList<>(parser.load(args[0]));
            
            //Find the maximum salary to determine the range (the minimum is 100000 by definition)
            double minSalary = 100000.0f;
            double maxSalary = minSalary;
            for(Record record : records)
            {
                maxSalary = Math.max(maxSalary, record.salary);
            }
            
            //Map the salary ranges to the bin indices
            Map<Integer, Double> salaryRangeToBin = new HashMap<>();
            int[] bins = new int[100];
            for(int i = 0; i < 100; i++)
            {
                salaryRangeToBin.put(i, LERP(minSalary, maxSalary, (double)i/100.0));
            }
            
            //Count the salaries that are in each bin
            for(Record r2 : records)
            {
                for(int i = 0; i < 100; i++)
                {
                    if(i == 99)
                    {
                        bins[i]++;
                    }
                    else if (r2.salary >= salaryRangeToBin.get(i))
                    {
                        if(r2.salary < salaryRangeToBin.get(i + 1))
                        {
                            bins[i]++;
                            i = 100;
                        }
                    }
                }
            }
            
            //Implement the histogram
            JFrame frame = new JFrame();
            BarGraph hist = new BarGraph(bins, 1000);
            frame.getContentPane().add(hist);
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
