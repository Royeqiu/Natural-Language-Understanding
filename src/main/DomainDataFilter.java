package main;

import json.JSONObject;
import util.IOManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by roye on 2017/4/28.
 */
public class DomainDataFilter {

    static public void main(String args[])
    {
        IOManager io=new IOManager();
        ArrayList<String> oldWineDomainDictionary=new ArrayList<String>();
        ArrayList<String> newWineDomainDictionary=new ArrayList<String>();
        ArrayList<String> uniqueDomainDictionary=new ArrayList<String>();
        io.setreadpath("WineDomainDataFirstFilter.txt");
        Set<String> unique=new HashSet<String>();
        int i=0;
        int j=0;
        while(io.ready())
        {
            String singleDictionary=io.readLine();
            JSONObject singleDictionaryJsonObject=new JSONObject(singleDictionary);
            if(!singleDictionaryJsonObject.keySet().contains("value"))
            {
                continue;
            }
            i++;
            System.out.println(singleDictionaryJsonObject.toString());
            oldWineDomainDictionary.add(singleDictionaryJsonObject.getString("value"));
            unique.add(singleDictionaryJsonObject.getString("value"));
        }
        io.setreadpath("sortedDictionary2ReplaceSlash.txt");
        while(io.ready())
        {
            String singleDictionary=io.readLine();
            JSONObject singleDictionaryJsonObject=new JSONObject(singleDictionary);
            if(!singleDictionaryJsonObject.keySet().contains("value"))
            {
                continue;
            }
            j++;
            newWineDomainDictionary.add(singleDictionaryJsonObject.getString("value"));
            unique.add(singleDictionaryJsonObject.getString("value"));
        }

        System.out.println(i+" "+j+" "+unique.size());

    }
}
