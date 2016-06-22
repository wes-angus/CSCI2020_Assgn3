
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class My
{
    public static void main(String[] args) throws FileNotFoundException
    {
        if(args.length > 0)
        {
            Map<String, Double> sectorAVG = new LinkedHashMap<>();
            List<Record> records;
            ParseFile parser = new ParseFile();
            records = new ArrayList<>(parser.load(args[0]));
            
            //Average out the salaries across each sector
            for(Record r : records)
            {
                if(!sectorAVG.containsKey(r.sector))
                {
                    sectorAVG.put(r.sector, r.salary);
                }
                else
                {
                    double temp = (sectorAVG.get(r.sector) + r.salary) / 2;
                    sectorAVG.put(r.sector, temp);
                }
            }
            
            //Implement the line graph
            JFrame frame = new JFrame();
            LineGraph l_graph = new LineGraph(sectorAVG, 5000);
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
