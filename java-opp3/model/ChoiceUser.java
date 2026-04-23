package model;


import model.charactor.Character;
import model.charactor.Mage;
import model.charactor.Warrio;

public class ChoiceUser {
    public Character create(int choice){
        if(choice==1){
            return new Warrio();
        }else if(choice ==2){
            return new Mage();
        }
        return null;
    }
}
