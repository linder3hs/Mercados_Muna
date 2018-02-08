package com.linder.mercados.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linder.mercados.ApiService;
import com.linder.mercados.ApiServiceGenerator;
import com.linder.mercados.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    // SharedPreferences
    private SharedPreferences sharedPreferences;
    private Button btnLogin;
    private EditText use, pwd;
    private static final String TAG = LoginActivity.class.getSimpleName();
    ResponseMessage responseMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // init SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        btnLogin = (Button) findViewById(R.id.login);
        use = (EditText) findViewById(R.id.user);
        pwd = (EditText) findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user = use.getText().toString();
                final String password = pwd.getText().toString();
                ApiService service = ApiServiceGenerator.createService(ApiService.class);
                Call<ResponseMessage> call = null;
                call = service.loginUsuario(user, password, "password");
                call.enqueue(new Callback<ResponseMessage>() {
                    @Override
                    public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                        try {
                            int statusCode = response.code();
                            Log.d(TAG, "HTTP status code: " + statusCode);
                            if (response.isSuccessful()) {
                                responseMessage = response.body();
                                Log.d(TAG, "responseMessage: " + responseMessage.getAccess_token());
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                boolean success = editor
                                        .putString("token", responseMessage.getAccess_token())
                                        .commit();
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                intent.putExtra("token",responseMessage.getAccess_token());
                                startActivity(intent);
                                finish();
                            } else {
                                Log.e(TAG, "onError: " + response.errorBody().string());
                                //throw new Exception();
                            }

                        } catch (Throwable t) {
                            try {
                                Log.e(TAG, "onThrowable: " + t.toString(), t);
                                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                            } catch (Throwable x) {
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMessage> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.toString());
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });
            }
        });

        //initialize();
        // username remember
        final String email = sharedPreferences.getString("email", null);
        if(email != null){
            use.setText(email);
            pwd.requestFocus();
        }

        // islogged remember
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            intent.putExtra("token",responseMessage.getAccess_token());
            startActivity(intent);
            finish();

        }

    }
}
