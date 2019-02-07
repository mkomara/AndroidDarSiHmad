package mySql;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Objects.User;
import Objects.Site;


public class DistantAccess implements AsyncResponse {

    //change the string value
  private final String SERVERADDR = "http://serverIpAdress/folder/file.php";
  private User user;
  private ArrayList<Site> SiteList;
// private User user;
  public DistantAccess(){
      super();
      this.SiteList = new ArrayList<Site>();
  }


    /**
     * pour envoyé les informations a la bd
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

                    int id_user = infos.getInt("id_user");
                    String email = infos.getString("email");
                    String role = infos.getString("role_id");

                    User user = new User(id_user,email,role);
                    this.setUser(user);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else if(response[0]=="site"){
                try{

                    for(int i = 1; i < response.length;i++) {
                        JSONObject infos = new JSONObject(response[i]);
                        int id = infos.getInt("id_site");
                        String name = infos.getString("site");
                        Site site = new Site(id, name);
                        this.SiteList.add(site);
                    }

                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Site> getSiteList() {
        return SiteList;
    }

    public void setSiteList(ArrayList<Site> siteList) {
        SiteList = siteList;
    }
}
