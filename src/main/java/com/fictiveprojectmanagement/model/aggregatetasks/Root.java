package com.fictiveprojectmanagement.model.aggregatetasks;

import lombok.Data;

import java.util.List;
@Data
public class Root {
     XAxis xAxis;
     YAxis yAxis;
     List<Series> series;
}
