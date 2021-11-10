package video.enumeration;

/**
 * 原始的 不优雅的代码。[极其丑陋的代码]
 */
public class Original {
    public String judge(String role) {
        String power = role + "power";
        if ("Admin".equals(role)) {
            return power;
        } else if ("Normal".equals(role)) {
            return power;
        } else if ("Super".equals(role)) {
            return power;
        } else {
            power = "No Person";
        }
        return power;
    }
}
