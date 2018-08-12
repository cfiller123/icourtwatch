package com.carlfiller.icourtwatch.models.service;

import java.util.List;
import java.util.Map;

import com.carlfiller.icourtwatch.models.data.CanvasjsChartDao;
import org.springframework.beans.factory.annotation.Autowired;


public class CanvasjsChartServiceImpl implements CanvasjsChartService {

    @Autowired
    private CanvasjsChartDao canvasjsChartDao;

    public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
        this.canvasjsChartDao = canvasjsChartDao;
    }

    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData() {
        return canvasjsChartDao.getCanvasjsChartData();
    }

}