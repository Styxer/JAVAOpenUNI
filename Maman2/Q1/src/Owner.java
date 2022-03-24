public class Owner {
    private String _name;
    private String _phone;

    public  Owner(String name, String _phone){
        _name = name;
        _phone = _phone;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "_name='" + _name + '\'' +
                ", _phone='" + _phone + '\'' +
                '}';
    }
}
