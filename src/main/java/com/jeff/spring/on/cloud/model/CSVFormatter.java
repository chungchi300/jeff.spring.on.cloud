package com.jeff.spring.on.cloud.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

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

    public String stringsToString(List<String> strings) {
        String concatStr = "";
        for (int i = 0; i < strings.size(); i++) {
            if (i == 0) {
                concatStr += "\"" + strings.get(i) + "\"";
            } else {
                concatStr += ",\"" + strings.get(i) + "\"";
            }
        }
        return concatStr;
    }

    public ByteArrayOutputStream convertBenefits(List<Benefit> benefits) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(30000);

        CSVWrite csvWrite = new CSVWrite(byteArrayOutputStream);
       // csvWrite.setSheetMeta("bank_offer");
        String[] title = new String[]{"language", "bank", "card", "merchant", "merchantPhone", "benefit", "tAndCLink", "from", "to", "storeLocation"};
        csvWrite.writeRow(title);

        for(Benefit benefit:benefits){
            csvWrite.writeRow(new String[]{benefit.getLanguage(),
                    benefit.getBank(),
                    stringsToString(benefit.getCards()),
                    benefit.getMerchant(),
                    benefit.getMerchantPhone(),
                    stringsToString(benefit.getBenefitDescriptions()),
                    benefit.gettAndCLink(),
                    "1-1-2016", "31-12-2016",
                    stringsToString(benefit.getStoreLocations())});

        }
        csvWrite.flush();
        return byteArrayOutputStream;
    }
}
