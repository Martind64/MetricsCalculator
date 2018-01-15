package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.List;

public class MetricController implements Initializable{

    @FXML public List<MetricUnit> units = new ArrayList<MetricUnit>();

    @FXML public ComboBox<String> unitBox;
    @FXML public ComboBox<String> unitBoxTwo;

    @FXML public TextField input;

    @FXML public Text result;
    @FXML public String textMetric;


    @FXML protected void convert(ActionEvent event) {

        double inputAsDouble = Double.parseDouble(input.getText());

        MetricUnit firstMetric = new MetricUnit();
        MetricUnit secondMetric = new MetricUnit();

        for (MetricUnit metricUnit: units) {
            if (metricUnit.name == unitBox.getValue()){
                firstMetric = metricUnit;
            }
            if (metricUnit.name == unitBoxTwo.getValue()){
                secondMetric = metricUnit;
            }
        }

        calculateMetric(firstMetric, secondMetric, inputAsDouble);
    }


    public void calculateMetric(MetricUnit a, MetricUnit b, double value)  {
        // If types are not the same throw exception
        if(a.type != b.type){
            throw new InvalidParameterException("Cannot convert metrics that are not of the same type");
        }


        double finalValue = (value * a.value) / b.value;
        result.setText(String.valueOf(finalValue));
        result.setText(result.getText() + " " + b.name);
    }

//    // Calculate length metrics
//    public void calculateLengthMetric(MetricUnit a, MetricUnit b, double value){
//
//    }

    public void setMetrics() {
        // Length Metrics
        MetricUnit centimeter = new MetricUnit("Centimeter","length", 1.);
        units.add(centimeter);
        MetricUnit meter = new MetricUnit("Meter","length", 100.);
        units.add(meter);
        MetricUnit kilometers = new MetricUnit("Kilometer","length", 100000.);
        units.add(kilometers);

        // Add the items to the combo boxes
        for (MetricUnit unit: units) {
            unitBox.getItems().add(unit.name);
            unitBoxTwo.getItems().add(unit.name);
        }


        // Capacity Metrics
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMetrics();
    }
}
// Foreach loop
//        for (MetricUnit unit : units) {
//            System.out.println(unit.value);
//            System.out.println(unit.type);
//        }
