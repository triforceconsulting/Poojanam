package com.triforce.namami;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Send_Feedback extends AppCompatActivity {
    EditText edtFeedbackMsg;
    TextView txtFeedbacktypeProblem , txtFeedbacktypeSuggestion, txtFeedbacktypeOthers;
    EditText edtEmailFeedback;
    Button btnSendFeedback;
    ImageView imgback;

    String txtFeedbackType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        edtFeedbackMsg = (EditText)findViewById(R.id.edtFeedbackmsg);
        edtEmailFeedback = (EditText)findViewById(R.id.edtEmailFeebback);
        txtFeedbacktypeProblem = (TextView)findViewById(R.id.txtFeedbacktypeProblem);
        txtFeedbacktypeSuggestion = (TextView)findViewById(R.id.txtFeedbacktypeSuggestions);
        txtFeedbacktypeOthers = (TextView)findViewById(R.id.txtFeedbacktypeOthers);
        btnSendFeedback = (Button)findViewById(R.id.btnSendFeedback);
        imgback =(ImageView)findViewById(R.id.imgFeedbackBack);

        txtFeedbackType = "Problem";

        btnSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(doesAllValid()) {
                        if(edtEmailFeedback.getText().toString().equals("")) {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("message/rfc822");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"poojanam.team@gmail.com"});
                            i.putExtra(Intent.EXTRA_SUBJECT, "Namami Android feedback");
                            i.putExtra(Intent.EXTRA_TEXT,
                                    (CharSequence) new StringBuilder()
                                                    .append("Feedback Type : " + txtFeedbackType.toString())
                                                    .append('\n')
                                                    .append("Feedback : " + edtFeedbackMsg.getText().toString())

                            );
                            startActivity(Intent.createChooser(i, "Send mail..."));

                        } else {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("message/rfc822");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"poojanam.team@gmail.com"});
                            i.putExtra(Intent.EXTRA_SUBJECT, "Namami Android feedback");
                            i.putExtra(Intent.EXTRA_TEXT,
                                    (CharSequence) new StringBuilder()
                                                    .append("Feedback Type : " + txtFeedbackType.toString())
                                                    .append('\n')
                                                    .append("Feedback : " + edtFeedbackMsg.getText().toString())
                                                    .append('\n')
                                                    .append("Email : " + edtEmailFeedback.getText().toString())

                            );
                            startActivity(Intent.createChooser(i, "Send mail..."));

                        }
                       // Toast.makeText(getApplicationContext(), "Save Successfully",Toast.LENGTH_LONG);
                    }
                }
                catch (Exception e) {
                    System.out.println("Error in Validation" +e.toString());
                }

            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send_Feedback.this.finish();
            }
        });


        txtFeedbacktypeProblem.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                txtFeedbackType = "Problem";
                txtFeedbacktypeProblem.setTextColor(getResources().getColor(R.color.colorPrimary));
                txtFeedbacktypeProblem.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback));
                txtFeedbacktypeSuggestion.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeSuggestion.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));
                txtFeedbacktypeOthers.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeOthers.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));
            }
        });

        txtFeedbacktypeSuggestion.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                txtFeedbackType = "Suggestions";
                txtFeedbacktypeSuggestion.setTextColor(getResources().getColor(R.color.colorPrimary));
                txtFeedbacktypeSuggestion.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback));
                txtFeedbacktypeProblem.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeProblem.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));
                txtFeedbacktypeOthers.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeOthers.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));

            }
        });

        txtFeedbacktypeOthers.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                txtFeedbackType = "Others";
                txtFeedbacktypeOthers.setTextColor(getResources().getColor(R.color.colorPrimary));
                txtFeedbacktypeOthers.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback));
                txtFeedbacktypeProblem.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeProblem.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));
                txtFeedbacktypeSuggestion.setTextColor(getResources().getColor(R.color.colortextGrew));
                txtFeedbacktypeSuggestion.setBackground(getResources().getDrawable(R.drawable.btn_background_feedback_grew));
            }
        });

    }

    private boolean doesAllValid() {
         try {
             if(TextUtils.isEmpty(edtFeedbackMsg.getText().toString().trim())) {
                 edtFeedbackMsg.setError(getString(R.string.error_field_required));
                 edtFeedbackMsg.requestFocus();
                 return false;
             }
             if(!TextUtils.isEmpty(edtEmailFeedback.getText().toString().trim())) {

                 if(!isValidEmailAddress(edtEmailFeedback.getText().toString().trim())) {

                     edtEmailFeedback.setError(getString(R.string.error_email_field));
                     edtEmailFeedback.requestFocus();
                     return false;
                 }
             }
         }
         catch(Exception e) {
           System.out.println("Error in DoesAllvalid" +e.toString());
        }
        return true;
    }

    public static boolean isValidEmailAddress(String emailAddress) {

        boolean temp = false;
        //String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})";
        String emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+']{1,256}[\\@]{1}[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}([\\.]{1}[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+";
        if (emailAddress.matches(emailPattern)) {
            temp = true;
        }
        return temp;

    }

    @Override
    protected void onResume() {
        super.onResume();
        edtFeedbackMsg.setText("");
        edtEmailFeedback.setText("");
    }
}
