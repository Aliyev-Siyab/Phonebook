package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"John", "Hill", "1234567890", "st1@mail.ru", "Koln", "Hey"});
        list.add(new Object[]{"Max", "Fox", "1122334455", "1st@gmail.com", "Cologne", "World"});
        list.add(new Object[]{"Amy", "Day", "1010101010", "s1t@gm.com", "Stutgart", "Nice"});
        list.add(new Object[]{"Sam", "Lee", "9998887776", "testing@gm.ua", "Hamburg", "Job"});
        list.add(new Object[]{"Eve", "Ray", "1212121212", "lowtest@mail.com", "Berlin", "Hard"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
