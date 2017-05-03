package main;

import databaseUtil.DatabaseController;
import databaseUtil.SqlObject;
import json.JSONObject;
import utils.IOManager;

import java.util.ArrayList;

/**
 * Created by roye on 2017/4/28.
 */
public class DomainDataInserter {

    static public void main(String args[])
    {
        IOManager io=new IOManager();
        io.setreadpath("wine_domain_data.txt");
        ArrayList<SqlObject> wineDomainSqlObjectList;
        DatabaseController databaseController=new DatabaseController();
        int i=1;
        while(io.ready())
        {
            String singleDictionary=io.readLine();
            JSONObject singleDictionaryJsonObject=new JSONObject(singleDictionary);
            String consideration=singleDictionaryJsonObject.getString("consideration");
            String word=singleDictionaryJsonObject.getString("word");
            String value=singleDictionaryJsonObject.getString("value");
            String priority=singleDictionaryJsonObject.getString("priority");
            SqlObject singleDictionarySqlObject=new SqlObject();
            singleDictionarySqlObject.addSqlObject("consideration",consideration);
            singleDictionarySqlObject.addSqlObject("display_name",word);
            singleDictionarySqlObject.addSqlObject("priority",priority);
            singleDictionarySqlObject.addSqlObject("word_vector",value);
            String sql="insert into wine_domain_knowledge (id,"+singleDictionarySqlObject.getColumnNameString()+") values ("+i+++","+"'"+consideration+"','"+word+"','"+priority+"',to_tsvector('english','"+value+"'));";
            databaseController.execSql(sql);
            System.out.println(sql);
        }


    }
}
