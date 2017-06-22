package ahmedattia.myeventbusproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ahmedattia.myeventbusproject.R;
import ahmedattia.myeventbusproject.event.EventModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.EditTextEvent)
    EditText editText;

    @BindView(R.id.buttonEvent)
    Button buttonEvent;

    @BindView(R.id.buttonGoToActivityFragment)
    Button goToSecondActivity;

    @BindView(R.id.textViewShowEvent)
    TextView textViewEvent;

    EventBus eventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //startActivity(new Intent( MainActivity.this,SecondActivity.class));
    }

    @OnClick(R.id.buttonGoToActivityFragment)
    public void goToSecondActivity() {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
        eventBus.postSticky(new EventModel(editText.getText().toString()));


        /*diference betwwen post and postSticky
      /   post  : when the event is in the same activity
         (example  we want to update only the the TextView inside the activity)

         postSticky :    when the event is in the same activity and  another
         activities that use the same event and same class EventModel

         to understand better  replace  postSticky   with post
         in this  method (@OnClick(R.id.buttonGoToActivityFragment))

         -----------------------------------------
         Astuce  :  we put comment on  eventBus.post(new EventModel(editText.getText().toString()));
         in method (@OnClick(R.id.buttonEvent))
         because   eventBus.postSticky(new EventModel(editText.getText().toString()));
         in this method   (@OnClick(R.id.buttonGoToActivityFragment))
         can send the event in same activity  and  another  activities
      */
    }

    @OnClick(R.id.buttonEvent)
    public void GetText() {
        //  eventBus.post(new EventModel(editText.getText().toString()));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEvent(EventModel eventModel) {
        textViewEvent.setText(eventModel.getMessageEvent());
    }

    @Override
    public void onStart() {
        super.onStart();
        eventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        eventBus.getDefault().unregister(this);
        super.onStop();
    }

}
