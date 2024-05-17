// Customer class to represent a customer object
class Customer {
    private int orderNumber; // Order number of the customer
    private String customerName; // Name of the customer
    private String contactNumber; // Contact number of the customer
    private String address; // Address of the customer
    private String location; // Location (city) of the customer
    private String email; // Email address of the customer

    public Customer(int orderNumber, String customerName, String contactNumber, String address, String location, String email) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.location = location;
        this.email = email;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber; 
   }
   
   public String getAddress() { 
       return address; 
   }
   
   public void setAddress(String address) { 
       this.address = address; 
   }
   
   public String getLocation() { 
       return location; 
   }
   
   public void setLocation(String location) { 
       this.location = location; 
   }
   
  public String getEmail() { 
      return email; 
  }
  
  public void setEmail(String email) { 
      this.email = email; 
  }
}