package com.company;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;

public class Car implements Externalizable {
    private Integer id;
    private Integer countOfSeats;
    private String confidentialVIN;
    private String manufactureName;
    private String modelName;

    //при испл. интерфейса Externalizable нужен конструктор без параметров
    public Car() {}

    public Car(Integer id, Integer countOfSeats, String confidentialVIN, String manufactureName, String modelName) {
        this.id = id;
        this.countOfSeats = countOfSeats;
        this.confidentialVIN = confidentialVIN;
        this.manufactureName = manufactureName;
        this.modelName = modelName;
    }

    //при исп. интерфейса Externalizable нужно реализовать процесс де/сереализации в соотвествии
    //со своими нуждами, например кодирование, шифрование и т.д.
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.id);
        out.writeObject(this.countOfSeats);
        out.writeObject(this.encodeBase64(this.confidentialVIN));
        out.writeObject(this.manufactureName);
        out.writeObject(this.modelName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Integer)in.readObject();
        countOfSeats = (Integer)in.readObject();
        confidentialVIN = this.decodeBase64((String) in.readObject());
        manufactureName = (String)in.readObject();
        modelName = (String)in.readObject();
    }

    private String encodeBase64(String confidentialVIN){
        String encodedData = Base64.getEncoder().encodeToString(confidentialVIN.getBytes());
        return encodedData;
    }

    private String decodeBase64(String confidentialVIN){
        String decodedData = new String(Base64.getDecoder().decode(confidentialVIN));
        return decodedData;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", countOfSeats=" + countOfSeats +
                ", confidentialVIN='" + confidentialVIN + '\'' +
                ", manufactureName='" + manufactureName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
