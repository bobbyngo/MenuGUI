import java.util.Objects;

public class BuddyInfo {
    private String name;
    private String address;
    private String age;
    /**
     * Author: Ngo Huu Gia Bao
     * ID: 101163137
     */

    /**
     * Default Constructor
     */
    public BuddyInfo() {
        this.name = "Bobby";
        this.address = "96 VietNam";
        this.age = "20";
    }

    /**
     * Constructor
     */
    public BuddyInfo(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for name
     * @return String address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter for age
     * @return String age
     */
    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(name, buddyInfo.name) && Objects.equals(address, buddyInfo.address) && Objects.equals(age, buddyInfo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, age);
    }

    public static void main(String[] args) {
        BuddyInfo buddyInfo1 = new BuddyInfo();
        BuddyInfo buddyInfo2 = new BuddyInfo("pogger gamers", "1056 Middle East", "50");

        System.out.println("Hello " + buddyInfo1.getName());
        System.out.println("Hello " + buddyInfo2.getName());
    }
}

