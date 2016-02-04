package com.jeff.spring.on.cloud.model.Crawler;

import java.io.IOException;

/**
 * Created by aigens on 4/2/2016.
 */
public interface LoadData {
    void load(GuessCuisineOperation guessCuisineOperation) throws IOException;
}
