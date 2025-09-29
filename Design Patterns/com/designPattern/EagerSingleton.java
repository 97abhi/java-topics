
/*
 * ✅ Pros:
Simple and straightforward.

Thread-safe because instance is created before any thread accesses it.

❌ Cons:
Instance is created even if it's never used.

Might waste memory or resources for heavy objects.

🧠 Use Case:
Use when the instance is lightweight and always needed (e.g., Runtime.getRuntime()).
 */


public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}