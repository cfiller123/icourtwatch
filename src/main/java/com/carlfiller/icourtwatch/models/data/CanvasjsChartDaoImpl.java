package com.carlfiller.icourtwatch.models.data;

import java.util.List;
import java.util.Map;


public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData() {
        return CanvasjsChartData.getCanvasjsDataList();
    }

}