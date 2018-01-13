package sample;

public class MetricUnit {

    public String name;
    public String type;
    public Double value;

    public MetricUnit(){}
    public MetricUnit(String Name, String Type, Double Value){
        name = Name;
        type = Type;
        value = Value;
    }

    public String getName(){
        return name;
    }

}
