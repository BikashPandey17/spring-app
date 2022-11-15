package com.example.appthree.payload;
import javax.validation.constraints.NotEmpty;

public class Name {
    @NotEmpty String firstName;
    @NotEmpty String lastName;

    protected Name() {}

    public Name(@NotEmpty String firstName, @NotEmpty String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
