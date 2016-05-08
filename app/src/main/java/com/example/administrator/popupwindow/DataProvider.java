package com.example.administrator.popupwindow;

import java.util.HashMap;
import java.util.Map;

/*******************************************************************************
 * Author  : Yankai
 * Date    : 2016-03-18 17:43
 * Email   : yk_yang@wesugarfree.com
 * Company : 上海无糖运动
 ******************************************************************************/
public class DataProvider {
    public static final String[] summaries = {
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "M",
            "N"
    };
    public static final Map<String, String[]> details = new HashMap<>();

    static {
        details.put("A", new String[]{"A1", "A2", "A3"});
        details.put("B", new String[]{"B1", "B2"});
        details.put("C", new String[]{"C1", "C2", "C3", "C4", "C5"});
        details.put("D", new String[]{"D1", "D2", "D3"});
        details.put("E", new String[]{"E1", "E2", "E3"});
        details.put("F", new String[]{"F2", "F3"});
        details.put("G", new String[]{"G1", "G2", "G3"});
        details.put("H", new String[]{"H1", "H2", "H3"});
        details.put("I", new String[]{"I2", "I3"});
        details.put("M", new String[]{"M1", "M2", "M3"});
        details.put("N", new String[]{"N1", "N2", "N3"});
    }

}
