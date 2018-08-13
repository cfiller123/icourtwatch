package com.carlfiller.icourtwatch.models.data;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CanvasjsChartDao {

    List<List<Map<Object, Object>>> getCanvasjsChartData();

}