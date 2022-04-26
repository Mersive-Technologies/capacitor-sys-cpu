package com.mersive.capacitor.syscpu;

import android.util.Log;
import java.io.RandomAccessFile;
import java.io.IOException;

public class SysCpu {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public float getCpuLoad() {
        // https://stackoverflow.com/questions/9756353/how-to-get-memory-usage-and-cpu-usage-by-application
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();

            String[] toks = load.split(" ");

            long idle1 = Long.parseLong(toks[5]);
            long cpu1 =
                Long.parseLong(toks[2]) +
                Long.parseLong(toks[3]) +
                Long.parseLong(toks[4]) +
                Long.parseLong(toks[6]) +
                Long.parseLong(toks[7]) +
                Long.parseLong(toks[8]);

            try {
                Thread.sleep(360);
            } catch (Exception e) {
                e.printStackTrace();
            }

            reader.seek(0);
            load = reader.readLine();
            reader.close();

            toks = load.split(" ");

            long idle2 = Long.parseLong(toks[5]);
            long cpu2 =
                Long.parseLong(toks[2]) +
                Long.parseLong(toks[3]) +
                Long.parseLong(toks[4]) +
                Long.parseLong(toks[6]) +
                Long.parseLong(toks[7]) +
                Long.parseLong(toks[8]);

            float result = (float) (cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));
            //Log.i("CapacitorCastor", "cpu load = " + result);
            return result;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
