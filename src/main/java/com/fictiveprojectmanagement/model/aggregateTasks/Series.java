package com.fictiveprojectmanagement.model.aggregateTasks;

import java.util.ArrayList;

@lombok.Data
public class Series {
     String type;
     String name;
     ArrayList<Datum> data;
}
