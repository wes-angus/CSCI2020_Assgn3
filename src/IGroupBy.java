
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public interface IGroupBy
{
    static int BY_SECTOR   = 0;
    static int BY_EMPLOYER = 1;
    static int BY_POSITION = 2;
    static int BY_NAME     = 3;

    public void setData(List<Record> records);
    public void groupby(int byAttribute);
    public void printTopK(int k);
}
