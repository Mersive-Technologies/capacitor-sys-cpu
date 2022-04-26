import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(SysCpuPlugin)
public class SysCpuPlugin: CAPPlugin {
    private let implementation = SysCpu()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func getCpuInfo(_ call: CAPPluginCall) {
        call.resolve([
            "load": 0.2
        ])
    }
}
