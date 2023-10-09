package com.example.fictiveprojectmanagement.model.aggregateTasks;

import lombok.Data;

import java.util.List;
@Data
public class Root {
     XAxis xAxis;
     YAxis yAxis;
     List<Series> series;
}
