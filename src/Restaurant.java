// Restaurant class to represent a restaurant object
class Restaurant { 
     private String name; // Name of the restaurant
     private String location; // Location of the restaurant
     private String contactNumber; // Contact number of the restaurant

     public Restaurant(String name, String location, String contactNumber) { 
         this.name = name; 
         this.location = location; 
         this.contactNumber = contactNumber; 
     }
     
     public String getName() { 
         return name; 
     }
     
     public void setName(String name) { 
         this.name = name; 
     }
     
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}