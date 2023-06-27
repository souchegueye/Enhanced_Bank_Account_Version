package test3;

//Manager class
class Manager {
 private String id;
 private String password;

 public Manager(String id, String password) {
     this.id = id;
     this.password = password;
 }

 public boolean authenticate(String enteredId, String enteredPassword) {
     return id.equals(enteredId) && password.equals(enteredPassword);
 }
}