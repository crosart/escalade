package fr.crosart.escalade.model.beans;

public class User {

    // Attributs
    private Integer id;
    private String login;
    private String password;
    private String nickname;
    private String firstName;
    private String lastName;
    private String mail;
    private String telephone;
    private boolean isMember;

    // Constructeurs
    public User() {
    }

    /**
     * Constructeur User
     * @param pId
     */
    public User(Integer pId) {
        id = pId;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public boolean isMember() {
        return isMember;
    }
    public void setMember(boolean member) {
        isMember = member;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}