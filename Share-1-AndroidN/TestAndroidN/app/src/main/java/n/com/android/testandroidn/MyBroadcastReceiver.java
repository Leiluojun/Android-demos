package n.com.android.testandroidn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;

/**
 * Created by yezi on 16-7-4.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("test_receiver", "" + intent.getAction());
        Button a = new Button(context);
        a.setOnClickListener(view -> {

        });
    }
}
