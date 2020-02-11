package entities;

import java.time.LocalDate;

public class Coupon {

    private long id;
    private LocalDate expired;
    private CouponType type;
    private double price;
    private int amount;
    private String message;
    private String image;
    private long companyId;

    public Coupon(long id, LocalDate expired, CouponType type, double price, int amount, String message, String image, long companyId) {
        this.id = id;
        this.expired = expired;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.message = message;
        this.image = image;
        this.companyId = companyId;
    }

    public Coupon(LocalDate expired, CouponType type, double price, int amount, String message, String image, long companyId) {
        this.expired = expired;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.message = message;
        this.image = image;
        this.companyId = companyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public CouponType getType() {
        return type;
    }

    public void setType(CouponType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", expired=" + expired +
                ", type=" + type +
                ", price=" + price +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", image='" + image + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
