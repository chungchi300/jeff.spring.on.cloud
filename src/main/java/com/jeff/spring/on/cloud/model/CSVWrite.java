package com.jeff.spring.on.cloud.model;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by aigens on 19/1/2016.
 */
//singleton
public class CSVWrite{
    private CSVWriter csvWriter;
    private OutputStreamWriter osw;

    public CSVWrite(ByteArrayOutputStream baos) {

        try{
            this.osw = new OutputStreamWriter(baos, "utf-8");

            this.osw.write('\ufeff');

        }catch(Exception ex){
            System.out.print(ex);
        }
        csvWriter = new CSVWriter(osw);
    }


    public void writeRow(String[] rStrings) {

        csvWriter.writeNext(rStrings);
    }


    public void setSheetMeta(String metaData) {

        csvWriter.writeNext(new String[]{metaData});
    }


    public void flush() {

        try{
            csvWriter.flush();
            csvWriter.close();

        }catch(Exception exception){
            System.out.print(exception);
        }
    }

}