package com.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mid;
    String name;
    String phone;
    boolean hasMembership = false;
    int booksTaken = 0;
    
    public Long getMid() {
        return mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isHasMembership() {
        return hasMembership;
    }
    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
    public int getBooksTaken() {
        return booksTaken;
    }
    public void setBooksTaken(int booksTaken) {
        this.booksTaken = booksTaken;
    }
    public Member() {
    }
    @Override
    public String toString() {
        return "Member [mid=" + mid + ", name=" + name + ", phone=" + phone + ", hasMembership=" + hasMembership
                + ", booksTaken=" + booksTaken + "]";
    }

    
}