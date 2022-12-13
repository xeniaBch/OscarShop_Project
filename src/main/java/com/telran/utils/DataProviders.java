package com.telran.utils;

import com.telran.utils.model.User;
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
    public Iterator<Object[]> newUserPositiveRegisterWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setEmail(split[0])
                    .setPassword(split[1])
                    .setConfirmPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserNegativeEmailRegisterWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongEmailUsers.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setEmail(split[0])
                    .setPassword(split[1])
                    .setConfirmPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserNegativePasswordRegisterWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongPasswordUsers.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setEmail(split[0])
                    .setPassword(split[1])
                    .setConfirmPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
