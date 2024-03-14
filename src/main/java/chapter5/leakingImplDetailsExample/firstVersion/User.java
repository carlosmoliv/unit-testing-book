package chapter5.leakingImplDetailsExample.firstVersion;

// Leaking implementation details: An example with an operation
public class User {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String normalizeName(String name) {
        String result = name.trim();
        if (result.length() > 50) return result.substring(0, 50);
        return result;
    }
}
