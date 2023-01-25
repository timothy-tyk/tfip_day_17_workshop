package workshop17.app.model;

import java.io.Serializable;

import jakarta.json.JsonArray;

public class Conditions implements Serializable{
  private String main;
  private String description;
  private String icon;

  // Getters and Setters
  public String getMain() {
    return main;
  }
  public void setMain(String main) {
    this.main = main;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getIcon() {
    return icon;
  }
  public void setIcon(String icon) {
    this.icon = icon;
  }
  
  public static Conditions createJson(JsonArray jsonArr){
    Conditions cond = new Conditions();
    cond.main = jsonArr.get(0).asJsonObject().getString("main");
    cond.description = jsonArr.get(0).asJsonObject().getString("description");
    String iconUrl = "http://openweathermap.org/img/wn/";
    cond.icon = iconUrl+jsonArr.get(0).asJsonObject().getString("icon")+"@4x.png";
    return cond;
  }

  
}

