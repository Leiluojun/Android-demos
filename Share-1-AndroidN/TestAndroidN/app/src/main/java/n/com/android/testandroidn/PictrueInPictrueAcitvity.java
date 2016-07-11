package n.com.android.testandroidn;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by yezi on 16-6-30.
 */

public class PictrueInPictrueAcitvity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pictrue_in_pictrue);
        findViewById(R.id.btnPip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PictrueInPictrueAcitvity.this, SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(intent);
            }
        });
        toastNotifyMessage();
    }

    private void toastNotifyMessage() {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(getIntent());
        if (remoteInput != null) {
            Toast.makeText(this, remoteInput.getCharSequence("key_text_reply"), Toast.LENGTH_LONG).show();
        }
    }
}
