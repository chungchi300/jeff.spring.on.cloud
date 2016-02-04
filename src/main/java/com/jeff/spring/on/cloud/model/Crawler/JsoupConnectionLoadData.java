package com.jeff.spring.on.cloud.model.Crawler;

import org.jsoup.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aigens on 4/2/2016.
 */
public class JsoupConnectionLoadData implements LoadData {
   private List<Connection> connections = new ArrayList<Connection>();
    public List<RawData> rawDatas = new ArrayList<RawData>();


    @Override
    public void load(GuessCuisineOperation guessCuisineOperation) throws IOException {
        for(Connection connection :this.connections){

            try{
                RawData rawData = new RawData();
                rawData.content = connection.get().html();
                rawData.cuisineType = guessCuisineOperation.guessCuisineType(connection.request().url().toString());

                rawData.url = connection.request().url().toString();

                rawData.connection = connection;
                this.rawDatas.add(rawData);
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
    }

    public List<Connection> getConnections() {
        return connections;
    }
    public void addConnection(Connection connection){
        this.connections.add(connection);
    }
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }
}
