package mySql;

import org.json.JSONArray;

public class DistantAccess implements AsyncResponse {

    //change the string value
  private final String SERVERADDR = "http://serverIpAdress/folder/file.php";

  public DistantAccess(){
      super();
  }

  public void sendData(String operation, JSONArray jsonData){
    AccessHTTP dataAccess = new AccessHTTP();

    dataAccess.setDelegate(this);

    dataAccess.addParam(operation,jsonData.toString());

    dataAccess.execute(SERVERADDR);
  }

  public void requestUser(String name, String password){

  }




    @Override
    public void processFinish(String output) {

    }
}
