
import java.text.DecimalFormat;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class GroupBy implements IGroupBy
{
    List<Record> records;
    Map<String, Double> groups;//Stores the total salary for each group based on the group name
    
    GroupBy()
    {
        records = new ArrayList<>();
        groups = new LinkedHashMap<>();
    }
    
    @Override
    public void setData(List<Record> records)
    {
        this.records.clear();
        this.records.addAll(records);
    }
    
    @Override
    public void groupby(int byAttribute)
    {
        groups.clear();
        switch(byAttribute)
        {
            case BY_SECTOR:
                for(Record r : records)
                {
                    //if a group doesn't exist, create it
                    if(!groups.containsKey(r.sector))
                    {
                        groups.put(r.sector, r.salary);
                    }
                    //otherwise, add the salary to the existing data
                    else
                    {
                        groups.put(r.sector, groups.get(r.sector) + r.salary);
                    }
                }
                break;
            case BY_EMPLOYER:
                for(Record r : records)
                {
                    if(!groups.containsKey(r.employer))
                    {
                        groups.put(r.employer, r.salary);
                    }
                    else
                    {
                        groups.put(r.employer, groups.get(r.employer) + r.salary);
                    }
                }
                break;
            case BY_POSITION:
                for(Record r : records)
                {
                    if(!groups.containsKey(r.position))
                    {
                        groups.put(r.position, r.salary);
                    }
                    else
                    {
                        groups.put(r.position, groups.get(r.position) + r.salary);
                    }
                }
                break;
            case BY_NAME:
                for(Record r : records)
                {
                    if(!groups.containsKey(r.name))
                    {
                        groups.put(r.name, r.salary);
                    }
                    else
                    {
                        groups.put(r.name, groups.get(r.name) + r.salary);
                    }
                }
                break;
        }
    }

    @Override
    public void printTopK(int k)
    {
        //Maps can't be sorted normally by value, so to sort the groups by value you must convert the map
        //to a list/array of its entries and build a comparator to sort the array/list of the map entries
        Object[] a = groups.entrySet().toArray();
        Arrays.sort(a, new ComparatorImpl());
        for (int i = 0; i < k; i++)
        {
            //Breaks once the end of the list is reached to avoid out-of-range errors if k > the number of groups
            if(i > a.length - 1)
            {
                break;
            }
            DecimalFormat salaryFormatter = new DecimalFormat("$###,###.##");
            System.out.println(((Map.Entry<String, Double>) a[i]).getKey() + "\t" + salaryFormatter.format(((Map.Entry<String, Double>) a[i]).getValue()));
        }
    }

    private static class ComparatorImpl implements Comparator {

        public ComparatorImpl() {
        }

        @Override
        public int compare(Object o1, Object o2)
        {
            return ((Map.Entry<String, Double>) o2).getValue().compareTo(((Map.Entry<String, Double>) o1).getValue());
        }
    }
}
