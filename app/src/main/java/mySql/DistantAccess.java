package mySql;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DistantAccess implements AsyncResponse {

    //change the string value
  private final String SERVERADDR = "http://serverIpAdress/folder/file.php";
// private User user;
  public DistantAccess(){
      super();
  }

  public void sendData(String operation, JSONArray jsonData){
    AccessHTTP dataAccess = new AccessHTTP();

    dataAccess.setDelegate(this);

    dataAccess.addParam(operation,jsonData.toString());

    dataAccess.execute(SERVERADDR);
  }

  public void requestUser(String operation, String name){
      AccessHTTP dataAccess = new AccessHTTP();

      dataAccess.setDelegate(this);

      dataAccess.addParam(operation,name);

      dataAccess.execute(SERVERADDR);
  }




    @Override
    public void processFinish(String output) {
        Log.d("response",output);
        String[] response = output.split("%");
        if(response != null){
            if(response[0] == "User"){
                try {
                    JSONObject infos = new JSONObject(response[1]);
                    String Name = infos.getString("name");
                    String password = infos.getString("password");
                    String role = infos.getString("role_id");
                    //User user = new User(Name,password,role);
                    //this.setUser(user);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
