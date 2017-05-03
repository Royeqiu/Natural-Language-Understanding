package main;

import utils.IOManager;

import java.io.File;

/**
 * Created by roye on 2017/4/5.
 */
public class WineDomainQuestionDataFilter {

    public static void main(String[] args)
    {
        IOManager io=new IOManager();
        File pagePath=new File("page");
        io.setwritepath("sentence.data",true);
        int count=0;
        if(pagePath.isDirectory())
        {
            String[] folderNameSet=pagePath.list();
            for(String folderName:folderNameSet)
            {
                File folderPath=new File("page/"+folderName);
                if(folderPath.isDirectory())
                {
                    String[] fileNameSet=folderPath.list();
                    for(String fileName:fileNameSet)
                    {
                        String fullFileName="page/"+folderName+"/"+fileName;
                        io.setreadpath(fullFileName);
                        for(int i=0;io.ready();i++)
                        {
                            String text=io.readLine();
                            if(i!=2)
                            {
                                String []sentenceSet=text.split("\\.|\\?|\\!|\\;|\\:");
                                for(String sentence:sentenceSet)
                                {
                                    if(!sentence.isEmpty())
                                    {
                                        if(sentence.charAt(0)==' ')
                                        {
                                            sentence=sentence.replaceFirst(" ","");
                                            sentence=sentence.replaceAll("\"","");
                                            sentence=sentence.replaceAll("\\(","");
                                            sentence=sentence.replaceAll("\\)","");
                                            sentence=sentence.replaceAll("\\/"," or ");
                                            if(!sentence.isEmpty())
                                            {
                                                count++;
                                                io.writeLine(sentence);
                                            }
                                        }
                                        else
                                        {
                                            if(!sentence.isEmpty())
                                            {
                                                count++;
                                                io.writeLine(sentence);

                                            }
                                        }
                                        //System.out.println(sentence);
                                    }

                                }

                            }
                            else
                            {

                            }
                        }

                    }
                }
            }
            System.out.println(count);
        }
    }
}
