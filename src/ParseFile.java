
import java.util.*;
import java.io.*;
import java.util.regex.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class ParseFile implements RecordLoader
{
    @Override
    public List<Record> load(String filename) throws FileNotFoundException
    {
        String line;
        String block = "";
        List<Record> employeeRecords = new ArrayList<>();
        String temp_sector = "";
        String temp_name = "";
        String temp_position = "";
        String temp_employer = "";
        double temp_salary = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))//try-with-resources
        {
            line = reader.readLine();
            Pattern startBlock = Pattern.compile("<tr>");
            Pattern endBlock = Pattern.compile("</tr>");
            Pattern pre_sectorp = Pattern.compile("<div xml:lang=\"en\">");
            Pattern sectorp = Pattern.compile("<br />([A-Z- a-z_0-9#\\\\+\\(\\)\\.\\:;/&,`'\"\\-\\t]+)<");
            Pattern end_sectorp = Pattern.compile("</h3>");
            Pattern employer_posp = Pattern.compile("<span lang=\"en\">([A-Z- a-z_0-9#\\+\\\\:`\\(\\)\\.;/&'\",\\-\\t]+)<");
            Pattern lastnamep = Pattern.compile("<td align=\"left\" valign=\"top\">([A-Z- a-z_0-9#\\+\\\\(`\\)\\:'\"\\./;&,\\-]+)<");
            Pattern firstnamep = Pattern.compile("<td colspan=\"2\" align=\"left\" valign=\"top\">([A-Z- a-z_0-9#,\\\\+\\`'\"(\\)/\\:;&\\.\\-]+)<");
            Pattern moneyp = Pattern.compile("<td align=\"right\" valign=\"top\">\\$([0-9,\\(\\)\\.]+)<");
	    while(line != null)
	    {
                //Find the block of text containing the sector name
                Matcher mSectorStart = pre_sectorp.matcher(line);
                if(mSectorStart.find())
                {
                    Matcher mSectorEnd = end_sectorp.matcher(line);
                    while(!mSectorEnd.find())
                    {
                        mSectorEnd = end_sectorp.matcher(line);
                        block += line;
                        line = reader.readLine();
                    }
                    //Parse the sector
                    Matcher m0 = sectorp.matcher(block);
                    if(m0.find())
                    {
                        temp_sector = m0.group(1).trim();
                    }
                }
                
                Matcher mBlockStart = startBlock.matcher(line);
                //Get the block of text pertaining to 1 person
                if(mBlockStart.find())
                {
                    Matcher mBlockEnd = endBlock.matcher(line);
                    while(!mBlockEnd.find())
                    {
                        block += line;
                        line = reader.readLine();
                        mBlockEnd = endBlock.matcher(line);
                    }
                    //Do the parsing (employer, firstname, lastname, etc.)
                    Matcher m1 = employer_posp.matcher(block);
                    if(m1.find())
                    {
                        temp_employer = m1.group(1).trim();
                        
                        Matcher m2 = lastnamep.matcher(block);
                        if(m2.find(m1.end() - 1))
                        {
                            temp_name = m2.group(1).trim();
                            
                            Matcher m3 = firstnamep.matcher(block);
                            if(m3.find(m2.end() - 1))
                            {
                                temp_name += ", " + m3.group(1).trim();//Put the first and mast names together
                                
                                Matcher m4 = employer_posp.matcher(block);
                                if(m4.find(m3.end() - 1))
                                {
                                    temp_position = m4.group(1).trim();
                                    
                                    Matcher m5 = moneyp.matcher(block);
                                    if(m5.find(m4.end() - 1))
                                    {
                                        temp_salary = Double.parseDouble(m5.group(1).replaceAll(",", "").trim());                                       
                                    }
                                }
                            }
                        }
                    }
                }
                
                if(!temp_name.isEmpty())
                {
                    employeeRecords.add(new Record(temp_sector, temp_employer, temp_name, temp_position, temp_salary));
                }
                
                block = "";
                temp_name = "";
                temp_position = "";
                temp_employer = "";
                temp_salary = 0.0f;
                line = reader.readLine();
	    }
	}
	catch (IOException e)
	{
            System.out.println("Error: " + e);
            //e.printStackTrace();
        }
	return employeeRecords;
    }
}
