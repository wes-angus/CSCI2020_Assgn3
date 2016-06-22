
import java.io.FileNotFoundException;
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
public interface RecordLoader
{
    public List<Record> load(String filename)  throws FileNotFoundException;
}
