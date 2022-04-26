import Foundation

@objc public class SysCpu: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
