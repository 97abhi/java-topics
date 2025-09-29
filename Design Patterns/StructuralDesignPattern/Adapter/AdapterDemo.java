/*

Allows incompatible interfaces to work together by converting the interface of one class into another that a client expects.

 * You have a Type-C USB device, but the power plug is Type-A.
You use a Type-C to Type-A adapter so your device works without redesigning it.
 * 
 * 
 * | Situation                                            | Use Adapter?                    |
| ---------------------------------------------------- | ------------------------------- |
| You have a class with an incompatible interface      | ✅ Yes                           |
| You want to reuse legacy or third-party code         | ✅ Yes                           |
| You want to wrap a class and provide a different API | ✅ Yes                           |
| You want to redesign the whole class                 | ❌ No, use Adapter to avoid this |

 */



package Adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        LegacyPrinter legacy = new LegacyPrinter();
        ModernPrinter modernPrinter = new PrinterAdapter(legacy); // Adapter in use

        modernPrinter.print("Hello Adapter Pattern!");
    }
}
