package com.prog.springbootexample;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static class LatLng {
        double lat;
        double lng;
        public LatLng(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }

    public List<LatLng> parse(String filePath) {
        List<LatLng> locations = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                double lat = Double.parseDouble(line[0]);
                double lng = Double.parseDouble(line[1]);
                locations.add(new LatLng(lat, lng));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return locations;
    }
}
