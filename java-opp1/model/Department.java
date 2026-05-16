package model;

public class Department {
    private String name;
    private  int studentCount;
    private String building;


    public Department(String name,int studentCount,String building){
        this.name = name;
        this.studentCount = studentCount;
        this.building = building;
    }

    public void printAll(){
        System.out.printf("학과명: %s\n학생 수: %d\n건물: %s\n",this.name,this.studentCount,this.building);
    }




}
