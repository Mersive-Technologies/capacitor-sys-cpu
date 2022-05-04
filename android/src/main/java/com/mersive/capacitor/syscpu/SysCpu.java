package com.mersive.capacitor.syscpu;

import android.util.Log;
import java.io.RandomAccessFile;
import java.io.IOException;

public class SysCpu {

    private long lastCpu = 0;
    private long lastIdle = 0;

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

            long idle = Long.parseLong(toks[5]);
            long cpu =
                Long.parseLong(toks[2]) +
                Long.parseLong(toks[3]) +
                Long.parseLong(toks[4]) +
                Long.parseLong(toks[6]) +
                Long.parseLong(toks[7]) +
                Long.parseLong(toks[8]);

            float result = (float) (cpu - lastCpu) / ((cpu + idle) - (lastCpu + lastIdle));

            lastCpu = cpu;
            lastIdle = idle;

            return result;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
