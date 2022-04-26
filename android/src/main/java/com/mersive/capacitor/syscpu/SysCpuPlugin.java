package com.mersive.capacitor.syscpu;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

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
}
