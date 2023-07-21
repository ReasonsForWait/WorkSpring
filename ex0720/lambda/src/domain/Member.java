package domain;

public class Member {
    private String name;
    private String id;
    private Address address;

    public Member() {
        System.out.println("Member() 실행");
    }

    public Member(String name) {
        System.out.println("Member(String name) 실행");
        this.name = name;
    }

    public Member(String name, String id) {
        System.out.println("Member(String name, String id) 실행");
        this.name = name;
        this.id = id;
    }

    public Member(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
