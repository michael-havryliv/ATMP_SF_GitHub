package models.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard {

    private String description;
    private String name;
    private boolean share;

    public Dashboard(){}

    //Used for POST requests
    public Dashboard(String description, String name, boolean share){
        setDescription(description);
        setName(name);
        setShare(share);
    }

}
