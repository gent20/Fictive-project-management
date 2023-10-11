package com.fictiveprojectmanagement.model.aggregatetasks;

import java.util.ArrayList;

@lombok.Data
public class Series {
     String type;
     String name;
     ArrayList<Datum> data;
}
