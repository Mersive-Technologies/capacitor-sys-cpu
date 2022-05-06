package com.mersive.capacitor.syscpu;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@CapacitorPlugin(name = "SysCpu")
public class SysCpuPlugin extends Plugin {

    private SysCpu implementation = new SysCpu();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getCpuInfo(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("load", implementation.getCpuLoad());
        call.resolve(ret);
    }

    @PluginMethod
    public void getZoneTemp(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("temp", getZoneTemp(call.getInt("zone")));
        call.resolve(ret);
    }

    private Double getZoneTemp(int zone) {
        Process process;
        try {
            process = Runtime.getRuntime().exec("cat /sys/class/thermal/thermal_zone" + (zone + 2) + "/temp");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            if (line != null) {
                float temp = Float.parseFloat(line);
                return temp / 10.0;
            } else {
                return 51.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
