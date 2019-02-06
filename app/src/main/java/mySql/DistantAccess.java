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

    /**
     * pour envoyé les information a la bd
     * @param operation
     * @param jsonData
     */
  public void sendData(String operation, JSONArray jsonData){
    AccessHTTP dataAccess = new AccessHTTP();

    dataAccess.setDelegate(this);

    dataAccess.addParam(operation,jsonData.toString());

    dataAccess.execute(SERVERADDR);
  }

    /**
     * Demande un utilisateur a la bd
     * @param operation
     * @param email
     */
  public void requestUser(String operation, String email){
      AccessHTTP dataAccess = new AccessHTTP();

      dataAccess.setDelegate(this);

      dataAccess.addParam(operation,email);

      dataAccess.execute(SERVERADDR);
  }




    @Override
    public void processFinish(String output) {
        Log.d("response",output);
        String[] response = output.split("%");
        if(response != null){
            if(response[0].equals("User")){
                try {
                    JSONObject infos = new JSONObject(response[1]);
                    String email = infos.getString("id_user");
                    String role = infos.getString("role_id");
                    //User user = new User(Name,password,role);
                    //this.setUser(user);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(response[0]=="sites"){
                try{
                    JSONObject infos = new JSONObject(response[1]);

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
