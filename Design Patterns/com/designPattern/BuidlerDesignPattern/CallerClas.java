/*
 *  we want to make a class immutable, we can't provide public setters for its fields.
But then, how do we set values while constructing the object?

That’s where Builder Pattern helps:

It allows you to build the object step-by-step using a separate builder class, and then pass all values at once to the final object, which is immutable.

| Technique                          | Role                                  |
| ---------------------------------- | ------------------------------------- |
| `private final` fields             | Prevent changes after construction    |
| No setters                         | Prevent state mutation                |
| `private constructor`              | Enforce controlled object creation    |
| Builder sets values temporarily    | Keeps construction flexible but clean |
| Values passed once via constructor | Ensures atomic initialization         |

 */


package BuidlerDesignPattern;

public class CallerClas {

    public static void main(String[] args) {
        User user = new User.Builder().setName("Abhishek").setEmail("ihsc").setUserId(0).build();

        System.out.println(user);
    }
}
