package com.carlfiller.icourtwatch.models.data;

import com.carlfiller.icourtwatch.models.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.util.*;

public class CanvasjsChartData {

    @Autowired
    protected JudgeDao judgeDao;

    EntityManager em;

    public HashMap<String, OptionalDouble> getAudability() {
        List<Judge> judges = judgeDao.findAll();
        HashMap<String,OptionalDouble> audabilityMap = new HashMap<String,OptionalDouble>();
        for (Judge j : judges) {
            OptionalDouble audability = judges.stream().filter(s -> s.getName() == j.getName()).mapToDouble(s -> s.getAudability()).average();
            audabilityMap.put(j.getName(),audability);
        }

        return audabilityMap;

    }

    static Map<Object,Object> map = null;
    static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
    static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();

    static {
        map = new HashMap<Object,Object>(); map.put("x", 10); map.put("y", 69);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 20); map.put("y", 48);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 30); map.put("y", 26); map.put("indexLabel", "Lowest");dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 40); map.put("y", 50);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 50); map.put("y", 67);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 60); map.put("y", 38);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 70L); map.put("y", 94); map.put("indexLabel", "Highest");dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 80); map.put("y", 63);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 90); map.put("y", 57);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 100); map.put("y", 60);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 110); map.put("y", 38);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 120); map.put("y", 49);dataPoints1.add(map);
        map = new HashMap<Object,Object>(); map.put("x", 130); map.put("y", 37);dataPoints1.add(map);

        list.add(dataPoints1);
    }

    public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
        return list;
    }
}
