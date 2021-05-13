/**
 * @author surui
 * @date 2021/2/23 11:14 PM
 */
public class Susu {
    private String name;
    private int age;

    public Susu(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Susu susu = (Susu) o;
        return name == susu.name;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
