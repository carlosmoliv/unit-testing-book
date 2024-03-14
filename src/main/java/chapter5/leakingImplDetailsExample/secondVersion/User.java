package chapter5.leakingImplDetailsExample.secondVersion;

// Only observable behavior is public
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = normalizeName(name);
    }

    public String normalizeName(String name) {
        String result = name.trim();
        if (result.length() > 50) return result.substring(0, 50);
        return result;
    }
}
