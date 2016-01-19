package com.jeff.spring.on.cloud.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by aigens on 19/1/2016.
 */
public class CSVFormatter {
    private static CSVFormatter ourInstance = new CSVFormatter();

    public static CSVFormatter getInstance() {
        return ourInstance;
    }

    private CSVFormatter() {
    }
    public ByteArrayOutputStream convertBenefit(Benefit benefit) throws IOException {
        String[] strings = new String[]{"bromance",""};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(30000);

        CSVWrite csvWrite = new CSVWrite(byteArrayOutputStream);
        csvWrite.writeRow(strings);
        csvWrite.flush();
        return byteArrayOutputStream;
    }
}
