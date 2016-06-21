package com.car.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car
{
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "mark")
    @NotEmpty
    @Size(min = 2, max = 30, message = "Название автомобиля, должно иметь минимум 2 символа, и максимум 30 символов.")
    private String mark;

    @Column(name = "color")
    @NotEmpty
    private String color;

    @Column(name = "vin")
    @Min(value = 1, message = "Vin номер автомобиля, должно начинаться минимум с 1.")
    private int vin;

    @Column(name = "miles")
    @Range(min = 1, max = 9999, message = "Указанный диапозон миль может находиться в пределах от 1 до 9999.")
    private int miles;

    public Car()
    {

    }

    public Car(String id, String mark, String color, int vin, int miles) {
        this.id = id;
        this.mark = mark;
        this.color = color;
        this.vin = vin;
        this.miles = miles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", miles=" + miles +
                '}';
    }
}
