package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

public class Gender {
    private int idGender;
    private String description;

    void SetIdGender(int idGender){ this.idGender = idGender; }

    int GetIdGender(){ return idGender; }

    void SetDescription(String description){ this.description = description; }

    String GetDescription() { return description; }


}
