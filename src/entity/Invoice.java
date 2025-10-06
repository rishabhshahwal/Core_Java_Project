package entity;

public class Invoice {

     private int id;

     private int customerId;

     private int vehicleId;

     private int serviceId;

    public Invoice(int id, int customerId, int vehicleId, int serviceId) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Invoice[" +
                "id =" + id +
                ", customerId =" + customerId +
                ", vehicleId =" + vehicleId +
                ", serviceId =" + serviceId + "]";
    }
}
