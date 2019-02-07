package mySql;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccessHTTP  extends AsyncTask<String, Integer, Long> {

    private ArrayList<NameValuePair> parametres;
    private String ret;
    private AsyncResponse delegate;



   public AccessHTTP(){
       this.parametres = new ArrayList<NameValuePair>();
   }


    public AsyncResponse getDelegate(){
        return this.delegate;
    }
    public void setDelegate(AsyncResponse async){
        this.delegate = async;
    }

    public void addParam(String name, String value){
       this.parametres.add(new BasicNameValuePair(name,value));
    }

    @Override
    protected Long doInBackground(String... strings) {
        HttpClient clientCnx = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(strings[0]);

        try {
            paramCnx.setEntity(new UrlEncodedFormEntity(this.parametres));

            HttpResponse reponse = clientCnx.execute(paramCnx);

            ret = EntityUtils.toString(reponse.getEntity());
        } catch (UnsupportedEncodingException e) {
            Log.d("Erreur encodage" , "**********************" + e.toString());
        } catch (ClientProtocolException e) {
            Log.d("Erreur protocole","*************************" + e.toString());
        } catch (IOException e) {
            Log.d("Erreur I/O","*************" + e.toString());
        }
        return null;
    }
    @Override
    protected void onPostExecute(Long result){this.delegate.processFinish(ret);}
}
