package by.step.java.core.end.project.dao;

import by.step.java.core.end.project.service.cars.CarForm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCarpark extends FileDAO {

    @Override
    public List readFile() {
        List<CarForm> carpark = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\carpark.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArray = line.split(",");

                carpark.add(new CarForm(
                                Integer.parseInt(tempArray[0]),
                                tempArray[1],
                                Integer.parseInt(tempArray[2]),
                                Double.parseDouble(tempArray[3])
                        )
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carpark;
    }
}
