package n.com.android.testandroidn;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.llRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PictrueInPictrueAcitvity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnNofity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotify(false);
            }
        });
        findViewById(R.id.btnGroupNofity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotify(true);
            }
        });
        findViewById(R.id.btnPip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PictrueInPictrueAcitvity.class));
            }
        });
        findViewById(R.id.btnPip).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    /** 构造一个ClipData，将需要传递的数据放在里面 */
                    ClipData.Item item = new ClipData.Item(KEY_TEXT_REPLY);
                    String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                    ClipData dragData = new ClipData(KEY_TEXT_REPLY, mimeTypes, item);
                    View.DragShadowBuilder shadow = new View.DragShadowBuilder(findViewById(R.id.btnPip));
                    /** startDragAndDrop是Android N SDK中的新方法，替代了以前的startDrag，flag需要设置为DRAG_FLAG_GLOBAL */
                    view.startDragAndDrop(dragData, shadow, null, View.DRAG_FLAG_GLOBAL);
                    return true;
                } else {
                    return false;
                }
            }
        });
        Log.e("asdfadfa",isInMultiWindowMode()+"");
    }


    private static final String KEY_TEXT_REPLY = "key_text_reply";

    private void sendNotify(boolean isGroup) {
        // Key for the string that's delivered in the action's intent.
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("reply")
                .build();
        // Create the reply action and add the remote input.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, PictrueInPictrueAcitvity.class),
                0);
        Notification.Action action =
                new Notification.Action.Builder(R.mipmap.ic_launcher,
                        "message from android n", pendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();
        // Build the notification and add the action.
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(largeIcon)
                .setStyle(new Notification.InboxStyle()
                        .addLine("Alex Faaborg   Check this out")
                        .addLine("Jeff Chang   Launch Party")
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("johndoe@gmail.com"))
                .setContentTitle("hello !")
                .setContentText("i'm android n");
        if (isGroup) {
            builder.setGroup("aaaaaa").setGroupSummary(true);
        } else {
            builder.setGroup("bbbbbb").setGroupSummary(true);
        }
        Notification newMessageNotification = builder
                .addAction(action).build();
        // Issue the notification.
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(234, newMessageNotification);
    }
}
