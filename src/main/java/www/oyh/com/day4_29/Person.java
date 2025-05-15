package www.oyh.com.day4_29;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author sharkCode
 * @date 2025/4/29 17:25
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
//        Person person = new Person("oyh", 18);
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
//            oos.writeObject(person);
//            System.out.println("序列化完成");
//        } catch (IOException e) {
//        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

